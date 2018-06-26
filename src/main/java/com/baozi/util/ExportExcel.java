package com.baozi.util;

import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * @author JH
 * POI导出excel
 * */

public class ExportExcel<T> {

    private static Pattern p = Pattern.compile("^//d+(//.//d+)?$");

	   /** 
	     * @param path 图片路径
	     * 			      传入图片路径
	     * @param out
	     *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	     * @param title 
	     *            表格标题名 
	     * @param headers 
	     *            表格属性列名数组 （第一行标题）
	     * @param col
	     *            需要显示的表格属性列名数组 如果是javabean 必须和字段名字一直 如果为Map 必须为Map的key名字对应
	     * @param dataset 
	     *            需要显示的数据集合,集合泛型支持两种，1：符合javabean风格的类的对象 2：Map类型。此方法支持的 
	     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据) 
	     * @param pattern 
	     *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd" 
	     */ 
	public HSSFWorkbook exportExcel(String path,OutputStream out,String title, String[] headers,String[] col,Collection<T> dataset, String pattern) {
		FileOutputStream fileOut = null;     
        BufferedImage bufferImg = null; 
		if(pattern == null || "".equals(pattern)) {
            {
                pattern = "yyy-MM-dd";
            }
        }
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.WHITE.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();      
       
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        
        int cellbig = 0;
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(cellbig);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
            cellbig ++ ;
        }
        // 插入图片   
        try {  
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();     
            bufferImg = ImageIO.read(new File(path));     
            ImageIO.write(bufferImg, "png", byteArrayOut);  
            //anchor主要用于设置图片的属性  
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 250, 255,(short) 0, 1, (short) col.length,20);
            anchor.setAnchorType(3);     
            patriarch.createPicture(anchor, workbook.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));   
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            if(fileOut != null){  
                 try {  
                    fileOut.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 20;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            String[] fields = col;
            cellbig = 0;
            for (short i = 0; i < fields.length; i++) {
                String fieldName = fields[i];
                HSSFCell cell = row.createCell(cellbig);
                cell.setCellStyle(style2);
                try {
                    Object value = "";
                    Class tCls = null;
                    Map map = null;
                    if(t instanceof Map){
                        map = (Map)t;
                        value = map.get(fieldName);
                    } else {
                        String getMethodName = "get"
                                + fieldName.substring(0, 1).toUpperCase()
                                + fieldName.substring(1);
                        tCls = t.getClass();
                        Method getMethod = tCls.getMethod(getMethodName,new Class[] {});
                        value = getMethod.invoke(t, new Object[] {});
                    }
                    if(value == null ) {
                        {
                            value = "";
                        }
                    }
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    // 利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                            HSSFFont font3 = workbook.createFont();
                            font3.setColor(HSSFColor.BLUE.index);
                            richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }
                    cellbig ++ ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
       /* sheet.addMergedRegion(new Region((index+3),(short)3,(index+3),(short)4));
        HSSFCell cell = row.createCell(Cell);   
        cell.setCellValue("merging"); // 跨单元格显示的数据   
        cell.setCellStyle(style); // 样式   
        */ 
        /*File f = new File(path);
        f.delete();*/
        return workbook;
    }
	
	 //测试图片导出
    /*public static void main(String[] args) {  
         FileOutputStream fileOut = null;     
         BufferedImage bufferImg = null;     
        //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray    
        try {  
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();     
            bufferImg = ImageIO.read(new File("E:/eclipse/Eclipse worksplace/nscg/web/upload/20161118162753109.png"));     
            ImageIO.write(bufferImg, "png", byteArrayOut);  
              
            HSSFWorkbook wb = new HSSFWorkbook();     
            HSSFSheet sheet1 = wb.createSheet("test picture");    
            //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）  
            HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();     
            //anchor主要用于设置图片的属性  
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255,(short) 0, 0, (short) 11, 20);     
            anchor.setAnchorType(3);     
            //插入图片    
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));   
            fileOut = new FileOutputStream("E:/测试Excel.xls");     
            // 写入excel文件     
             wb.write(fileOut);     
             System.out.println("----Excle文件已生成------");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            if(fileOut != null){  
                 try {  
                    fileOut.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  */
	
	/*else if (value instanceof byte[]) {
    // 有图片时，设置行高为60px;
    row.setHeightInPoints(60);
    // 设置图片所在列宽度为80px,注意这里单位的一个换算
    sheet.setColumnWidth(Cell, (short) (35.7 * 80));
    // sheet.autoSizeColumn(i);
    byte[] bsValue = (byte[]) value;
    HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
            1023, 255, (short) 6, index, (short) 6, index);
    anchor.setAnchorType(2);
    patriarch.createPicture(anchor, workbook.addPicture(
            bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
} */
}
