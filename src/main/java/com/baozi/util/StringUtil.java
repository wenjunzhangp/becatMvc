package com.baozi.util;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class StringUtil {
	
	 public static void ZipFiles(java.io.File[] srcfile, java.io.File zipfile) {
        byte[] buf = new byte[1024]; 
        try { 
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                    zipfile)); 
            for (int i = 0; i < srcfile.length; i++) { 
                FileInputStream in = new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(srcfile[i].getName()));
                int len; 
                while ((len = in.read(buf)) > 0) { 
                    out.write(buf, 0, len); 
                } 
                out.closeEntry(); 
                in.close(); 
            } 
            out.close(); 
        } catch (IOException e) {
            e.printStackTrace(); 
        } 

    } 
	 
	/**
	 * 检测上传文件是否为文件
	 * @param url
	 * @return
	 */
	public static boolean checkFile(String url){
		if(StringUtil.isEmpty(url)){
			return false;
		}
		int lastIndex=url.lastIndexOf(".");
		String str=url.substring(lastIndex+1);
		if("jpg".equalsIgnoreCase(str)||"gif".equalsIgnoreCase(str)||"png".equalsIgnoreCase(str)||"bmp".equalsIgnoreCase(str)){
			return false;
		}
		return true;
	}
	
	/**
	 * 转换HTML中的 '&lt;' '&gt;' '"' '&amp;'
	 */
	
	static Pattern coding_pattern = Pattern.compile("[\"'<>%&\\(\\);\\+-\\[\\]\\{\\}]");
	
	static Pattern html_tag_pattern = Pattern.compile("<(?!img)[^>]*>");
	
	public static String join(String split, List objs) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < objs.size(); i++) {
			sb.append(objs.get(i));
			if (i != objs.size() - 1) {
				sb.append(split);
			}
		}
		return sb.toString();
	}
	public static String monthToString(int month, int day) {
		if (month == 0 && day != 0 && day % 30 == 0) {
			month = day / 30;
		}
		String r = "";
		if (month != 0) {
			int year = month / 12;
			int left = month % 12;
			if (year == 0) {
				return month + "个月";
			} 
			r = year + "年";
			if (left > 0) {
				r += left + "个月";
			}
		} else {
			r = day + "天";
		}
		
		return r;
	}
	
	public static boolean isNumber(String src){
		if(null == src || src.trim().isEmpty()){
			return false;
		}else{
			return src.matches("[0-9]+");
		}
	}
	
	public static boolean isEmpty(String src) {
		return src == null || src.trim().isEmpty();
	}
	
	public static boolean isPartnerPath(String src) {
		String regEx = "//www.xiaoyoucai.com/source/images/.*\\.(jpg|png)";
		return src.matches(regEx);
	}
	
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	public static boolean isMobile(String mobiles){
		if(null == mobiles || mobiles.trim().isEmpty()){
			return false;
		}else{
			String[] mobilesA = mobiles.split(",");
			for(String mobile : mobilesA){
				String r = "^(1)\\d{10}$";
				Matcher m = Pattern.compile(r).matcher(mobile);
				if (!m.find()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static String mobileCover(String mobile) {
		String r = "(\\d{3})(\\d{4})(\\d{4})";
		Matcher m = Pattern.compile(r).matcher(mobile);
		if (m.find()) {
			mobile = m.group(1) + "****" + m.group(3);
		}
		return mobile;
	}
	
	
	public static String getFormatedNumber(int number, String format) {
		 DecimalFormat df = new DecimalFormat(format);
		 return df.format(number);
	}
	public static String round(double d, int bit ) {
		if (bit == 0) {
			return "" + (long)d;
		}
		StringBuilder model = new StringBuilder("#.");
		 for(int i = 0; i < bit; i++) {
			 model.append("#");
		 }
		 DecimalFormat df = new DecimalFormat(model.toString());
		 return df.format(d);
	}
	
	public static String round3(double d){
		if(d > 10){
			return round(d,0);
		}else{
			return round(d,1);
		}
	}
	
	public static String round2(double d, int bit ) {
		if (bit == 0) {
			return "" + (long)d;
		}
		StringBuilder model = new StringBuilder("0.");
		 for(int i = 0; i < bit; i++) {
			 model.append("0");
		 }
		 DecimalFormat df = new DecimalFormat(model.toString());
		 return df.format(d);
	}
	public static String replaceScriptAndLink(String src) {
		if (src == null) return "";
//		src = src.replaceAll("[\r\n]+", "");
		src = src.replaceAll("(?i)<script.*?>(\\s|.)*?<\\/script.*?>", "");
		Matcher m = Pattern.compile("(i?)href\\s*=\\s*['\"](((?!qunar\\.com).)*?)['\"]").matcher(src);
		StringBuffer sb = new StringBuffer();
		while(m.find()) {
			m.appendReplacement(sb, "href='http://www.qunar.com'");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	
	public static boolean isEmptyWithoutHtml(String input){
		if(input == null || input.trim().isEmpty())
			return true;
		String escapeStr = escapeHtml(input);
		if(escapeStr == null || escapeStr.trim().isEmpty())
			return true;
		return false;
	}
	
	public static String escapeHtml(String input){
		if(StringUtil.isEmpty(input)){
			return "";
		}
		Matcher matcher = html_tag_pattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();  
        while (result1) {  
            matcher.appendReplacement(sb, "");  
            result1 = matcher.find();  
        }  
        matcher.appendTail(sb);  
        return sb.toString();  
	}
	
	

	/**
	 * 转换HTML中的空格，Tab，换行
	 */
	public static String convertHTMLContent(String input) {
		if(input==null) return "";
		input = input.replaceAll("  ", " &nbsp;");
		input = input.replaceAll("\t", " &nbsp; &nbsp;");

		StringBuffer filtered = new StringBuffer(input.length());

		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			switch (c) {
			case '\r':
				break;
			case '\n':
				filtered.append("<br />");
				break;
			default:
				filtered.append(c);
			}
		}
		return(filtered.toString());
	}

	public static String replaceSpecialChar(String input) {
		if (input == null) return "";
		return input.replace("＆", "&");
	}
	/**
	 * 将文本转换成相应的HTML
	 */
	public static String convertTextToHTML(String input) {
		StringBuffer filtered = new StringBuffer(input.length());

		for(int i = 0; i < input.length() - 6; i++){
			String c = input.substring(i, i + 6);
			if(c.equals("<br />"))
				filtered.append("\n");
			else if(c.equals("&nbsp;"))
				filtered.append(" ");
			else
				filtered.append(c);

		}
		return(filtered.toString());
	}

	public static String convertString(String input) {

		StringBuffer filtered = new StringBuffer(input.length());

		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			switch (c) {
			case '\'':
				filtered.append("\\'");
				break;
			case '\n':
				filtered.append("\\n");
				break;
			case '\r':
				filtered.append("\\r");
				break;
			default:
				filtered.append(c);
			}
		}
		return(filtered.toString());
	}
	
	public static String fillString(String str, List<String> args) {
		if (args == null || args.size() == 0) {
			return str;
		}

		if (str == null || str.length() == 0)
			return str;

		int startPos = 0, endPos = 0;
		String res = "";
		int i = 0;
		while ((endPos = str.indexOf("$$", startPos)) != -1) {
			res += str.substring(startPos, endPos) + args.get(i);
			startPos = endPos + 2;
			i++;
		}
		res += str.substring(startPos);

		return res;
	}
	
	public static String normalizeTitle(String title) {
		title = title.replaceAll("<|《|>|》|●", " ");
		title = title.replace("(", "（");
		title = title.replace(")", "）");
		title = title.replace("*", "");
		title = title.replace("１", "1")
					 .replace("０", "0")
					 .replace("２", "2")
					 .replace("３", "3")
					 .replace("４", "4")
					 .replace("５", "5")
					 .replace("６", "6")
					 .replace("７", "7")
					 .replace("８", "8")
					 .replace("９", "9");
		title = title.replaceAll("\\s|\u00A0|\u3000|&nbsp;", "");
		
		return title;
	}
	
	public static String trim(String raw) {
		if (raw == null) return "";
		raw = raw.replaceAll("^[\\s\u00A0\u3000]*|[\\s\u00A0\u3000]*$", "");
		return raw;
	}
	public static String normalizeFeature(String feature){
		feature = feature.replaceAll("\\s|\u00A0|\u3000|&nbsp;", "");
		return feature;
	}
	public static String normalizePrice(String price) {
		String regex = "([\\d\\.]+)";
		Matcher matcher = Pattern.compile(regex).matcher(price);
		if (matcher.find()) {
			return matcher.group(1);
		} else return price;		
	}
	public static String normalizeCJKSpace(String string) {
		if (string == null) return null;
		return string.replaceAll("\u00A0|\u3000|&?nbsp;?", " ");
	}
	
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	
	
	public static String MD5Encode(String origin) {
		String resultString = null;

		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {

		}
		return resultString;
	}
	
	
	public static String MD5EncodeUTF8(String origin) {
		String resultString = null;

		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
		} catch (Exception ex) {

		}
		return resultString;
	}
	
	public final static String strDelim = ",";
	
	public static String bSubstring(String s, int length) throws Exception {
		byte[] bytes = s.getBytes("Unicode");
		int n = 0; // 表示当前的字节数
		int i = 2; // 要截取的字节数，从第3个字节开始
		for (; i < bytes.length && n < length; i++){
			// 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
			if (i % 2 == 1){
				n++; // 在UCS2第二个字节时n加1
			}else{
				// 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
				if (bytes[i] != 0){
					n++;
				}
			}
		}
		// 如果i为奇数时，处理成偶数
		if (i % 2 == 1){
			// 该UCS2字符是汉字时，去掉这个截一半的汉字
			if (bytes[i - 1] != 0)
				i = i - 1;
			// 该UCS2字符是字母或数字，则保留该字符
			else
				i = i + 1;
		}
		return new String(bytes, 0, i, "Unicode");
	}
	
	public static String shortStr(String str, int len){
		if(str == null || str.trim().isEmpty())
			return "";
		if(len < 1)
			return str;
		if(str.length() > len){
			return str.substring(0, len) + "...";
		}
		return str;
	}
	
	/**
	 * 截取长度  不加...
	 * @param str
	 * @param len
	 * @return
	 */
	public static String shortStrEnd(String str, int len){
		if(str == null || str.trim().isEmpty())
			return "";
		if(len < 1)
			return str;
		if(str.length() > len){
			return str.substring(0, len);
		}
		return str;
	}
	
	public static String shortenStr(int maxLen, int shotLen, String str) {
		if (str == null) {
			return "";
		}
		if (str.length() <= maxLen) {
			return str;
		}
		
		return str.substring(0, shotLen) + "...";
	}
	public static String shortStr(String str, int len, int suffixLen){
		if(str == null || str.trim().isEmpty())
			return "";
		if(len < 1)
			return str;
		if(str.length() > len){
			if(suffixLen < len)
				len = suffixLen;
			return str.substring(0, len) + "...";
		}
		return str;
	}
	
	  public static String encoding(String src){

	        if (src==null)

	            return "";

	        StringBuilder result=new StringBuilder();

	        if (src!=null){

	            src=src.trim();

	            for (int pos=0;pos<src.length();pos++){

	                switch(src.charAt(pos)){

	                    case '\"':;break;

	                    case ',':;break;

	                    case '.':result.append('。');break;

	                    case '\'':;break;

	                    case '{':;break;

	                    case '}':;break;

	                    case ':':;break;



	                    default:result.append(src.charAt(pos));break;

	                }

	            }

	        }

	        return result.toString();

	    }
	

	
	
	/**
	 * 判断一个字符串 是否是 "数字，" 这种格式
	 * 
	 * @param ids
	 * @return
	 */
	public static boolean checkValidNumsList(String ids) {
		for (int i = 0; i < ids.length(); i++) {
			if (ids.charAt(i) != ',' && !Character.isDigit(ids.charAt(i)))
				return false;
		}
		return true;
	}

	/**
	 * 隐藏手机号吗的4-7位， 让供应商不知道这个用户的联系方式。除非她已经确认了资源
	 * @param phone
	 * @return
	 */
	public static String hiddenTelphone(String phone) {
		if (phone.length() != 11){
			// 不是11位，肯定不是手机
			return phone;
		}

		StringBuffer sb = new StringBuffer();
		sb.append(phone.substring(0, 3)).append("xxxx").append(phone.substring(7));
		return sb.toString();
	}
	
	public static String truncatZero(String str){
		if(StringUtil.isEmpty(str))
			return "0";
		str = str.trim();
		if(str.endsWith(".0")){
			str = str.replace(".0", "");
		}
		return str;
	}
	
	public static String truncatZero2(String str){
		if(StringUtil.isEmpty(str))
			return "0";
		str = str.trim();
		int dotIndex = str.indexOf(".");
		if(dotIndex == -1)
			return str;
		return str.substring(0, dotIndex);
	}
	
	
	
	/**
	 * 
	* @描述：网页漏洞过滤
	 */
	public static String escapeHtml2(String input){
		if(input!=null){
			input = input.replace ('<',' '); 
			input = input.replace ('>',' '); 
			input = input.replace ('"',' ');
			input = input.replace ('\'',' ');
			input = input.replace ('/',' ');
			input = input.replace ('%',' '); 
			input = input.replace (';',' '); 
			input = input.replace ('(',' '); 
			input = input.replace (')',' '); 
			input = input.replace ('&',' '); 
			input = input.replace ('+','_'); 
		}
       
        return input.trim();  
	}
	
	public static long getMoney(String money_str){
		if(isEmpty(money_str))
			return -1;
		long money = -1;
		try{
			money = Long.parseLong(money_str) * 10000;
		}catch(Exception e){}
		return money;
	}
	
	public static long getMoney(String money_str, boolean isyuan){
		if(isEmpty(money_str))
			return -1;
		long money = -1;
		try{
			money = Long.parseLong(money_str);
		}catch(Exception e){}
		if(isyuan)
			return money;
		return money * 10000;
	}
	//去掉空格
		public static String getStringRemoveSpace(String str){
			String entyValue="";
			entyValue=str.replaceAll("\\s+"," ");
			return entyValue;
		}
	
	public static int getMonthOrDay(String mod_str){
		if(isEmpty(mod_str))
			return 0;
		int mod = 0;
		try{
			mod = Integer.parseInt(mod_str);
		}catch(Exception e){}
		return mod;
	}
	
	private static String bytesToHex(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		int t;
		for (int i = 0; i < 16; i++) {
			t = bytes[i];
			if (t < 0)
				t += 256;
			sb.append(hexDigits[(t >>> 4)]);
			sb.append(hexDigits[(t % 16)]);
		}
		return sb.toString();
	}

	public static String md5(String input, int length)  {
		try {
			return code(input, length);
		} catch (Exception e) {
			return "";
		}
	}

	public static String code(String input, int bit) throws Exception {
		try {
			MessageDigest md = MessageDigest.getInstance(System.getProperty(
					"MD5.algorithm", "MD5"));
			if (bit == 16)
				return bytesToHex(md.digest(input.getBytes("utf-8")))
						.substring(8, 24);
			return bytesToHex(md.digest(input.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new Exception("Could not found MD5 algorithm.", e);
		}
	}

	public static String md5_3(String b) throws Exception {
		MessageDigest md = MessageDigest.getInstance(System.getProperty(
				"MD5.algorithm", "MD5"));
		byte[] a = md.digest(b.getBytes());
		a = md.digest(a);
		a = md.digest(a);

		return bytesToHex(a);
	}
	
	/**
	 * 
	* @描述：计算器金额显示
	* @开发时间： 2013-8-6 下午12:07:49
	 */
	public static String amountFormat(String str0){
		String higeh="";
		String format="";
		/*int zs=(int) (amount/1);
		double xs=amount-zs;*/
		String[] s=str0.split("\\.");
		if(s.length>0){
			String str=s[0];
			String xs="";
			if(s.length==2){
				xs=s[1];
			}
			
			int inputLength=str.length();//字符长度
			int strLength;
			String str_temp ;
			boolean b=true;
			if(inputLength%3==0){
				strLength=inputLength/3;
			}else{
				strLength=inputLength/3+1;
				 higeh=str.substring(0,inputLength%3);
				str=str.substring(inputLength%3);
				b=false;
			}
			for(int i=strLength-1;i>=0;i--){
				
				if(b){
					str_temp=str.substring(3*i,3*i+3);
					if(i!=0){
						//format+=str_temp+",";
						format=","+str_temp+format;
					}else {
						//format+=str_temp+".";
						format=str_temp+format;
					}
					
				}else{
					
					if(i!=0){
						str_temp=str.substring(3*(i-1),3*(i-1)+3);
						//format+=str_temp+",";
						format=","+str_temp+format;
					}else{
						//str_temp=str.substring(0,strLength%3);
						format=higeh+format;
					}
					//format+=".";
				}
			}
			if(!xs.equals("")){
				format+="."+xs;
			}
			
		}
		
		return format;
	}
	
	/**
	 * 
	* @描述：控制手机格式
	* @开发时间： 2013-9-4 上午10:41:09
	 */
	public static String phoneFormat(String phone){
		String str="";
		str+=phone.subSequence(0, 3)+"****";
		str+=phone.substring(7);
		return str;
	}
	
	public static String emailFormat(String email){
		String[] emailS=null;
		String str="";
		emailS=email.split("@");
		if(emailS==null){			
			return null;
		}
		int emailLong=emailS[0].length();
		if(emailS[0].length()<4){
			str=email;
		}else{
			str=email.substring(0,3)+"***"+email.substring(emailLong-1, emailLong)+"@"+emailS[1];			
		}
		return str;
	}
	
	/**
	 * 
	* @描述：获取detail的上级url  子类别  父类别
	* @开发时间： 2013-9-24 下午2:27:08
	 */
	public static String urlType(String url, int count){
		if(url==null)
			return null;
		//0   二级类别   1的话三级类别
		url=url.substring(7);
		String str=null;
		String[] type=url.split("/");
		if(count==0){
			str= type[1];//返回一级标题
		}else if(count==1){
			if(type[2].indexOf("list")>=0){
				str= null;
			}else{
				str=type[2];
			}
		}
		return str;
	}
	
	public static String maskRealNameString(String src){
		if (src == null) {
			return "";
		}
		int length = src.length(); 
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < length - 1; i++) {
			sb.append("*");
		}
		
		return sb.append(src.charAt(length-1)).toString();
		
	}
	
	public static String maskNickNameString(String src) {
		if (src == null) {
			return "";
		}
		int lenght = src.length(); 
		if ( lenght <= 1) {
			return src;
		}else if ( lenght == 2) {
			return "*" + src.charAt(1);
		}else 	if ( lenght == 3) {
			return src.charAt(0) + "*" + src.charAt(2);
		}else if ( lenght == 4) {
			return src.charAt(0) + "**" + src.charAt(3);
		}else if ( lenght == 5 || lenght == 6 || lenght == 7 ){
			String str = src.substring(  0 , 2 ) ;
			if ( lenght == 5 ){
				str += "*";
			}else if ( lenght == 6) {
				str += "**";
			}else{
				str += "***";
			}
			
			str += src.substring( lenght -2 , lenght );
			return str ;
		}
		String str = src.substring(0, 3 ) + "***";
		return str + src.substring( lenght - 3 , lenght );
		
	}

	public static String maskNickNameStringNew(String nickName) {
		if (nickName == null) {
			return "*";
		}

		int lenght = nickName.length();

		if (lenght <= 3) {
			return nickName.charAt(0) + "*";
		}

		StringBuffer sb = new StringBuffer();
		sb.append(nickName.charAt(0));
		sb.append(nickName.charAt(1));
		sb.append("***");
		sb.append(nickName.charAt(lenght - 2));
		sb.append(nickName.charAt(lenght - 1));

		return sb.toString();
	}

	public static String maskString(String src) {
		if (src == null) {
			return "";
		}
		if (src.length() <= 1) {
			return src;
		}
		if (src.length() == 2) {
			return "*" + src.charAt(1);
		}
		if (src.length() == 3) {
			return src.charAt(0) + "*" + src.charAt(2);
		}
//		if (src.length() == 4) {
//			return src.charAt(0) + "**" + src.charAt(3);
//		}
		if (src.length() % 2 == 0) {
			int lf = src.length() / 2;
			String reg = "(^.{1," + (lf - 1) + "})(.*?)(.{1," + (lf -1) + "}$)";
			Matcher m = Pattern.compile(reg).matcher(src);
			if (m.find()) {
				String a = m.group(1);
				String b = m.group(2);
				String c = m.group(3);
				return a + "**" + c;
			}
		} else {
			int lf = (src.length() - 3) / 2;
			String reg = "(^.{1," + lf + "})(.*?)(.{1," + lf + "}$)";
			Matcher m = Pattern.compile(reg).matcher(src);
			if (m.find()) {
				String a = m.group(1);
				String b = m.group(2);
				String c = m.group(3);
				return a + "***" + c;
			}
		}
		return src;
		
	}
	
	public static String maskBankId(String src){
		if (src == null) {
			return "";
		}
		if (src.length() <= 1) {
			return src;
		}
		if (src.length() == 2) {
			return "*" + src.charAt(1);
		}
		if (src.length() == 3) {
			return src.charAt(0) + "*" + src.charAt(2);
		}
		if (src.length() == 4) {
			return src.charAt(0) + "**" + src.charAt(3);
		}

		String fist4 = src.substring(0, 4);
		String last4 = src.substring(src.length() - 4, src.length());
		return fist4 + "*******" + last4;
	}
	
	public static String maskStr(String src) {
		if (src == null) return "";
		
		Matcher m = Pattern.compile("\\{(.*?)\\}").matcher(src);
		StringBuffer sb = new StringBuffer();
		while(m.find()) {
			int l = m.group(1).length();
			String r = "";
			for(int i= 0; i < l; i++) {
				r += "*";
			}
			m.appendReplacement(sb, r);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	public static String maskStr3(String src){
		if(StringUtil.isEmpty(src))
			return "";
		return "*" + src.substring(1, src.length());
	}
	
	public static String maskStr2(String src) {
		if (src == null) return "";
		src=src.replaceAll("[{}]", "");	 
		return src;
	}
	
	public static void ensureDir(String path) {
		File f = new File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
	}
	
	/**
	 * 根据裁剪后的imgId获取原始图片
	 * @param imageUrl
	 * @param w
	 * @param h
	 * @return
	 */
	public static String getOrignImageId(String imageUrl, int w, int h){
		int dotIndex = imageUrl.lastIndexOf(".");
		String suffix = "";
		if(dotIndex != -1){
			suffix = imageUrl.substring(dotIndex, imageUrl.length());
		}
		String replace = "_o_s_" + w + "x" + h + suffix;
		String orignId = imageUrl.replaceAll(replace, "");
		return orignId + "_origin_" + suffix;
	}
	
	/**
	 * 根据裁剪后的imgId获取等比压缩过的大图
	 * @param imageUrl
	 * @param w
	 * @param h
	 * @return
	 */
	public static String getComperssImageId(String imageUrl, int w, int h){
		int dotIndex = imageUrl.lastIndexOf(".");
		String suffix = "";
		if(dotIndex != -1){
			suffix = imageUrl.substring(dotIndex, imageUrl.length());
		}
		String replace = "_o_s_" + w + "x" + h + suffix;
		return imageUrl.replaceAll(replace, "");
	}
	
	public static String getSmallImageId(String imageUrl, int w, int h){
		int dotIndex = imageUrl.lastIndexOf(".");
		String suffix = "";
		if(dotIndex != -1){
			suffix = imageUrl.substring(dotIndex, imageUrl.length());
		}
		String ost = "_o_s_" + w + "x" + h + suffix;
		return imageUrl + ost;
	}
	
	/**
	 * 根据等比压缩的大图imgId获取原始图片
	 * @param imageUrl
	 * @return
	 */
	public static String getOrignImageId(String imageUrl){
		int dotIndex = imageUrl.lastIndexOf(".");
		String suffix = "";
		if(dotIndex != -1){
			suffix = imageUrl.substring(dotIndex, imageUrl.length());
		}
		return imageUrl + "_origin_" + suffix;
	}
	
	/**
	 * 
	* @描述：按小图获取大图信息
	* @开发时间： 2014-9-12 下午4:40:50
	 */
	public static String getOrignImageIdByMinImg(String imageUrl, int lw, int lh){
		int dotIndex = imageUrl.lastIndexOf(".");		
		String suffix = "";
		if(dotIndex != -1){
			suffix = imageUrl.substring(dotIndex, imageUrl.length());
			imageUrl=imageUrl.replace(suffix+"_o_s_"+lw+"x"+lh, "");
		}
		return imageUrl + "_origin_" + suffix;
	}
	
	
	/**
	 * 
	* @描述：按小图获取大图信息
	* @开发时间： 2014-9-12 下午4:40:50
	 */
	public static String getOrignImageIdByMinImgUrl(String imageUrl){
		int dotIndex = imageUrl.lastIndexOf(".");		
		String suffix = "";
		if(dotIndex != -1){
			suffix = imageUrl.substring(dotIndex, imageUrl.length());
			//String r = ".jpg_o_s_()x78.jpg";
			Pattern pattern = Pattern.compile(suffix+"_o_s_(\\d+)x(\\d+)"+suffix);
			Matcher m = pattern.matcher(imageUrl);
			if(m.find()){
				int lw= Integer.parseInt(m.group(1));
				int lh= Integer.parseInt(m.group(2));
				imageUrl=imageUrl.replaceAll(suffix+"_o_s_"+lw+"x"+lh, "");
				imageUrl+="_origin_" + suffix;
			}
		}
		return imageUrl;
	}
	
	
	public static void getInnerDescs(Node node, StringBuilder sb) {
		if ("STYLE".equals(node.getNodeName())) return;
		NodeList children = node.getChildNodes();
		if (HtmlUtil.isNewLineTag(node.getNodeName().toUpperCase())) {
			sb.append("\r\n");
		}
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if ("#text".equals(child.getNodeName())) {
				String content = child.getTextContent();
				if (content.replaceAll("\\s|\u00A0|\u3000|&nbsp;?", "").isEmpty()) {
					continue;
				}
				sb.append(StringUtil.trim(content)).append(" ");				
			} else {
				getInnerDescs(child, sb);
			}
		}
		if (HtmlUtil.isNewLineTag(node.getNodeName().toUpperCase())) {
			sb.append("\r\n");
		}
		
	}
	
	
	public static List<String> getDescs(Node node) {
		if (node == null) return new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<String>();
		NodeList children = node.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if ("#text".equals(child.getNodeName())) {
				String content = child.getTextContent();
				if (content.replaceAll("\\s|\u00A0|\u3000|&nbsp;?", "").isEmpty()) {
					continue;
				}
				sb.append(StringUtil.trim(content)).append(" ");
			} else {
				getInnerDescs(child, sb);
			}
		}
		String html = sb.toString();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new StringReader(html));
			String line = null;
			while ( (line = br.readLine())!= null) {
				if (line.isEmpty()) continue;
				result.add(line);
			}
		} catch(Exception e) {
			
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				br = null;
			}
		}
		
		return result;
	}
	
	public static void invest(double amount) {
		int total = 0;
		double m1 = Math.max(amount * 0.05, 30000); //0~8点金额
		Map mm = new HashMap();
		Map mkl = new HashMap();
		Map tm = new HashMap();
		for(int i = 0; i <=8; i++) {
			mm.put(i, m1);
			mkl.put("0-8", m1);
			tm.put(i, "0-8");
		}
		
		double m2 = Math.max(amount * 0.2,30000); //9~11点金额
		for(int i = 9; i <=11; i++) {
			mm.put(i, m2);
			mkl.put("9-11", m1 + m2);
			tm.put(i, "9-11");
		}
		
		double m3 = Math.max(amount * 0.2, 30000); //12~14点金额
		for(int i = 12; i <= 14; i++) {
			mm.put(i, m3);
			mkl.put("12-14", m1 + m2 + m3);
			tm.put(i, "12-14");
		}
		
		double m4 = Math.max(amount * 0.3, 30000); //15~19点金额
		for(int i = 15; i <= 19; i++) {
			mm.put(i, m4);
			mkl.put("15-19", m1 + m2 + m3 + m4);
			tm.put(i, "15-19");
		}
		
		double m5 = Math.max(amount * 0.15, 30000); //20~21点金额
		for(int i = 20; i <=21; i++) {
			mm.put(i, m5);
			mkl.put("20-21", m1 + m2 + m3 + m4 + m5);
			tm.put(i, "20-21");
		}
		
		double m6 = Math.max(amount - m1 - m2 - m3 - m4 - m5, 30000);
		for(int i = 22; i <= 23; i++) {
			mm.put(i, m6);
			mkl.put("22-23", amount);
			tm.put(i, "22-23");
		}
		
		Date d = DateUtil.parseDate("2014-04-01", "yyyy-MM-dd");
		for(int i = 0; i < 24 * 60 ;i++) {
			Date ds = new Date(d.getTime() + i * 60 * 1000L);
			int h = Integer.valueOf(DateUtil.formatDate(ds, "HH"));
			String k = (String)tm.get(h);
			double tml = (Double)mkl.get(k);
			if (total >= tml) {
				continue;
			}
			int r = (int)(Math.random() * 100);
			if (r >= 97) {
				
				int ra = (int)(Math.random() * 10000);
				Map m = new HashMap();
				List<Integer> f1Lst = new ArrayList<Integer>();
				for(int j = 1; j < 99; j++) {
					f1Lst.add(j * 100);
					if (j == 100) {
						for(int n = 0; n < 10; n++) {
							f1Lst.add(100);
						}
					}
					if (j % 5 == 0) {
						for(int n = 0; n < 10; n++) {
							f1Lst.add(j * 100);
						}
					}
				}
				m.put(0, f1Lst);
				
				List<Integer> f2Lst = new ArrayList<Integer>();
				for(int j = 100; j < 499; j++) {
					f2Lst.add(j * 100);
					if (j % 50 == 0) {
						for(int n = 0; n < 10; n++) {
							f2Lst.add(j * 100);
						}
					}
				}
				m.put(1, f2Lst);
				
				List<Integer> f3Lst = new ArrayList<Integer>();
				for(int j = 500; j < 999; j++) {
					f3Lst.add(j * 100);
					if (j % 50 == 0) {
						for(int n = 0; n < 10; n++) {
							f3Lst.add(j * 100);
						}
					}
				}
				m.put(2, f3Lst);
				int p = 0;
				if (ra < 8500) {
					p = 0;
				} else if (ra < 9000) {
					p = 1;
				} else {
					p = 2;
				}
				
				List<Integer> ll = (List)m.get(p);
				
				
				r = (int)(Math.random() * ll.size());
				
				total += ll.get(r);
				String s = DateUtil.formatDate(ds, "HH:mm:ss");
				System.out.println(s + " -> " + (ll.get(r)));
			}
		}
		System.out.println("t:" + total);
	}
	
	public static final StringBuilder code = new StringBuilder("abcdefghijklmnopqrstuvwxyz0123456789");
	
	public static String genCode(int n) {
		String ret = "";
		for(int i = 0; i < n; i++) {
			int j = (int)(Math.random() * 35);
			char c = code.charAt(j);
			ret += c;
		}
		return ret;
	}
	
	public synchronized static String genTicketNum(int type) {
		String num = "";
		if(type==1){
			num="J"+DateUtil.formatDate(new Date(), "yyyyMMddHHmmss");
		}else{
			num="X"+DateUtil.formatDate(new Date(), "yyyyMMddHHmmss");
		}
		
		int r = (int)(Math.random() * 9999);
		DecimalFormat df2 = new DecimalFormat("0000");
		num += df2.format(r);
		try {
			Thread.sleep(10L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public static String maskMobile(String mobile) {
		if (StringUtil.isEmpty(mobile)) return "";
		Matcher m = Pattern.compile("(\\d{3})(\\d{4})(\\d{4})").matcher(mobile);
		if (m.find()) {
			return m.group(1) + "****" + m.group(3);
		} else {
			return mobile;
		}
	}
	
	public static String maskMobileLast4(String mobile){
		if(StringUtil.isEmpty(mobile)) return "";
		Matcher m = Pattern.compile("(\\d{3})(\\d{4})(\\d{4})").matcher(mobile);
		if (m.find()) {
			return m.group(3);
		} else {
			return mobile;
		}
	}
	
	/**
	 * 
	* @描述：获取字符串的最后指定位数
	* @开发时间： 2014-7-30 下午3:03:27
	 */
	public static String substrLastNum(String str, int endNum){
		if(StringUtil.isEmpty(str)){
			return null;
		}
		int len=str.length();
		if(len<=endNum){
			return str;
		}
		
		return str.substring(len-endNum);
		
	}
	
	public static String maskIDCardNo(String idno){
		if(StringUtil.isEmpty(idno)){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(idno.substring(0, 1));
		sb.append("*************");
		sb.append(idno.substring(idno.length()-1, idno.length()));
		return sb.toString();
	}
	
	/**
	 * 前边3位后边4位
	 * @param idno
	 * @return
	 */
	public static String maskIDCardNo (String idno , int startNum , int lastNum ){
		
		if(StringUtil.isEmpty(idno)){
			return "";
		}
		int totalNum = idno.length() ;
		if ( startNum >= totalNum || lastNum >= totalNum  ){
			return maskIDCardNo( idno );
		}
		if ( startNum <0 ){
			startNum = 1 ;
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(idno.substring(0, startNum ));
		sb.append("*************");
		sb.append(idno.substring(idno.length()-lastNum, idno.length()));
		return sb.toString();
	}
	
	/**
	 * 判断已“，”号 分割的字符串 是否是数字
	 * */
	public static boolean isNotNaN(String str){
		if(str != null && !"".equals(str.trim())){
			String[] ids = str.split(",");
			ids = str.split(",");
			for (int j = 0; j < ids.length; j++) {
				for (int j2 = 0; j2 < ids[j].length(); j2++) {
					if(!Character.isDigit(ids[j].charAt(j2))){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * 隐藏密保
	 * @param idno
	 * @return
	 */
	
	public static String maskProPasswd(String pro){
		StringBuffer sb = new StringBuffer();
		sb.append(pro.substring(0, 2));
		sb.append("****");
		sb.append(pro.substring(pro.length()-1, pro.length()));
		return sb.toString();
	}
	
	
	public static List<Integer> genIntList(String ids) {
		if (StringUtil.isEmpty(ids)) {
			return new ArrayList<Integer>();
		}
		List<Integer> ret = new ArrayList<Integer>();
		String[] idSplits = ids.split(",");
		for(String id : idSplits) {
			ret.add(Integer.valueOf(id));
		}
		return ret;
	}
	public static String buildIntSplits(List<Integer> ids) {
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < ids.size(); i++) {
			sb.append(ids.get(i));
			if (i != ids.size() - 1) {
				sb.append(",");
			}
		}
		
		return sb.toString();
	}
	public static String buildStringSplits(List<String> ids) {
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < ids.size(); i++) {
			sb.append(ids.get(i));
			if (i != ids.size() - 1) {
				sb.append(",");
			}
		}
		
		return sb.toString();
	}

	public static String buildIntSplits(Integer[] ids) {
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < ids.length; i++) {
			sb.append(ids[i]);
			if (i != ids.length - 1) {
				sb.append(",");
			}
		}
		
		return sb.toString();
	}
	
	public static String buildStringSplits(String[] ids){
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < ids.length; i++) {
			sb.append(ids[i]);
			if (i != ids.length - 1) {
				sb.append(",");
			}
		}
		
		return sb.toString();
	}
	
	public static String buildIntInSql(List<Integer> inLst) {
		StringBuilder sb = new StringBuilder("(");
		
		for(int i = 0; i < inLst.size(); i++) {
			sb.append(inLst.get(i));
			if (i != inLst.size() - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		
		return sb.toString();
	}
	
	
	public static String buildIntInSql(Integer[] inLst) {
		StringBuilder sb = new StringBuilder("(");
		
		for(int i = 0; i < inLst.length; i++) {
			sb.append(inLst[i] + "");
			if (i != inLst.length - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		
		return sb.toString();
	}
	
	public static String buildStrInSql(List<String> inLst) {
		StringBuilder sb = new StringBuilder("(");
		
		for(int i = 0; i < inLst.size(); i++) {
			sb.append("'").append(inLst.get(i)).append("'");
			if (i != inLst.size() - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		
		return sb.toString();
	}
	
    /**
     * 
     * @方法说明：根据身份证号生成出生日期
     * @param cardID 15位或18位的身份证号
     * @return 出生日期
     * @throws BusinessException 
     *
     */
    public static Date cardID2Birthday(String cardID) {
            Date returnDate=null;
            StringBuffer tempStr=null;
            if(cardID!=null&&cardID.trim().length()>0){
                    if(cardID.trim().length()==15){
                            tempStr=new StringBuffer(cardID.substring(6, 12));
                            tempStr.insert(4, '-');
                            tempStr.insert(2, '-');
                            tempStr.insert(0, "19");
                    }else if(cardID.trim().length()==18){
                            tempStr=new StringBuffer(cardID.substring(6, 14));
                            tempStr.insert(6, '-');
                            tempStr.insert(4, '-');
                    }                        
            }
            if(tempStr!=null&&tempStr.toString().trim().length()>0){
                    try{
                            returnDate=new SimpleDateFormat("yy-MM-dd").parse(tempStr.toString());
                    }catch(Exception e){
                            throw new RuntimeException("输入的身份证错误，不能转换为相应的出生日期");
                    }
            }
            return returnDate;
    }
    
	public static String null2Empty(Object str) {
		if (str == null) {
			return "";
		}
		return str.toString();
	}


   public static int getPercentScale(double b){
	  BigDecimal ba = new BigDecimal(b);
	  int bar = ba.intValue();
	  if(bar <= 0)
		  return 0;
	  if(bar == 100)
		  return 20;
	  int mod = bar%5;
	  int d = bar/5;
	  if(mod > 0)
		  return d+1;
	  else
		  return d;
		  
   }

   //将阿拉伯数字转成中文（可带小数点）
   public static String albToCN(double num) {
       String beforePoint = "";
       String afterPoint = "";
       int index = -1;
       //对number进行格式处理
       String number = StringUtil.round(num, 2);
       /* 判断是否存在小数点 有就拆分两个部分，没有就直接把number赋值到 beforePoint */
       if (-1 != (index = number.indexOf('.')))
       {
           /* 根据 index 拆分成2部分 */
           beforePoint = number.substring(0, index);
           afterPoint = number.substring(index);
           afterPoint = getAfterPoint(afterPoint);/* 获取小数点后的中文写法 */
       } else
       {
           beforePoint = number;
       }
       beforePoint = getBeforePoint(beforePoint);/* 获取小数点前（包括无小数点时）的中文写法 */
       return  beforePoint + afterPoint;
   }
   
   /* 获取小数点前（包括无小数点时）的中文写法 */
   private static String getBeforePoint(String beforePoint)
   {
	   if ( "0".equals( beforePoint ) ){
		   return "零";
	   }
       StringBuffer temp = new StringBuffer();
       String[] key = { "", "拾", "佰", "仟" };/* 3个位值 */
       //对10进行特殊处理
       if("10".equals(beforePoint)){
       	return "十";
       }
      
       for (int i = 0; i < beforePoint.length(); i++)
       {
           char ch = beforePoint.charAt(i);/* ch 为当前索引的char值 */
           /*
            * countBit
            * 为当前统计的位数，以便于添加 万，亿
            */
           int countBit = beforePoint.length() - 1 - i;
           /* 判断是否为 0 值，不是就进行转换，是则进行else处理 */

           if (ch != '0')
           {
               temp.append(switchNumber(ch) + key[countBit % 4]);
           } else
           {
               char isZeroOrNotstr = temp.toString().charAt(temp.length() - 1);
               /* isZeroOrNotstr 获取最后一位的 中文写法,在后面进行判断是否为 “零” */

               /* 不等于“零” 才进行添加，一旦存在“零” 了，就不添加了 */
               if (isZeroOrNotstr != '零'&&i!=beforePoint.length()-1)
               {
                   temp.append("零");
               }
           }

           char isZeroOrNotstr = temp.toString().charAt(temp.length() - 1);
           /* isZeroOrNotstr 获取最后一位的 中文写法,在后面进行判断是否为 “零” */
           if (countBit == 4)/* 判断当前 countBit位数 是否为 4，是就添加“万” */
           {
               /* 假如最后一位中文写法为 “零”了，则进行替换，替换成 “万” */
               if (isZeroOrNotstr == '零')
               {
                   temp.replace(temp.length() - 1, temp.length(), "万");
               } else
               {
                   temp.append("万");
               }
           }
           if (countBit == 8)/* 判断当前 countBit位数 是否为8，是就添加“亿” */
           {
               /* 假如最后一位中文写法为 “零”了，则进行替换，替换成 “亿” */
               if (isZeroOrNotstr == '零')
               {
                   temp.replace(temp.length() - 1, temp.length(), "亿");
               } else
               {
                   temp.append("亿");
               }
           }
       }
       return temp.toString();
   }

   /* 获取小数点后的中文写法 */
   private static String getAfterPoint(String afterPoint)
   {
       StringBuffer temp = new StringBuffer("点");/* 首先加个 “点” */
       /* 小数点依次转换，不考虑位值 */
       for (int i = 0; i < afterPoint.length(); i++)
       {
           temp.append(switchNumber(afterPoint.charAt(i)));
       }
       return temp.toString();
   }

   /* 数字 ---转换---- 中文写法的方法 */
   private static String switchNumber(char ch)
   {
       String returnStr = "";

       switch (ch)
       {
       case '1':
           returnStr = "壹";
           break;
       case '2':
           returnStr = "贰";
           break;
       case '3':
           returnStr = "叁";
           break;
       case '4':
           returnStr = "肆";
           break;
       case '5':
           returnStr = "伍";
           break;
       case '6':
           returnStr = "陆";
           break;
       case '7':
           returnStr = "柒";
           break;
       case '8':
           returnStr = "捌";
           break;
       case '9':
           returnStr = "玖";
           break;
       case '0':
           returnStr = "零";
           break;
       }
       return returnStr;
   }
   
	public static String maskIDCardNo8(String idno){
		if(StringUtil.isEmpty(idno)){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(idno.substring(0, 8));
		sb.append("********");
		return sb.toString();
	}
	

   /**
    * 只保留小数
    * @param d
    * @return
    */
   public static String round4(double d ) {
	   String s = StringUtil.round2( d , 2 );
	   if ( StringUtil.isEmpty( s ) ) {
		   return "";
	   }
	   if ( s.indexOf(".") > 0 ){
		   return s.substring( s.indexOf(".") );
	   }
	   return ".00";
   }
   
   /**
    * 只保留1位小数
    * @param d
    * @return
    */
   public static String round6(double d ) {
	   String s = StringUtil.round2( d , 1 );
	   if ( StringUtil.isEmpty( s ) ) {
		   return "";
	   }
	   if ( s.indexOf(".") > 0 ){
		   return s.substring( s.indexOf(".") );
	   }
	   return ".0";
   }
   
   /**
    * 舍去小数
    * @param d
    * @return
    */
   public static String round5(double d){
	   return round(d,0);
	}
	
	
	public static String maskName(String name){
		if(StringUtil.isEmpty(name)){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(name.substring(0, 1));
		//长度为2处理，其余
		if(name.length()==2){
			sb.append("*");
		}else {
			sb.append("**");
		}
		return sb.toString();
	}
	
	public static String maskFirstName(String name){
		if(StringUtil.isEmpty(name)){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("*");
		if(name.length() >= 2){
			sb.append(name.substring(1, name.length()));
		}
		return sb.toString();
	}
	
	/**   
     * @param htmlStr  要搜索的字符串   
     * @param searchTag  要修改的目标标签  
     * @param searchAttrib  目标标签中的属性  
     * @param prefix  替换的内容
     */    
    public static String updateHtmlTag(String htmlStr, String searchTag, String searchAttrib, String prefix) {
    	 String regxpForTag ="<\\s*" + searchTag + "\\s+([^>]*)\\s*>";
         String regxpForTagAttrib = searchAttrib+"=\"([^\"]+)\"";
         Pattern patternForTag = Pattern.compile(regxpForTag);
         Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib);
         Matcher matcherForTag = patternForTag.matcher(htmlStr);
         StringBuffer sb = new StringBuffer();
         boolean result = matcherForTag.find();     
         while (result) {     
             StringBuffer sbreplace = new StringBuffer("<"+searchTag +" ");
             Matcher matcherForAttrib = patternForAttrib.matcher(matcherForTag.group(1));
             /*System.out.println(matcherForAttrib.group(1));*/
             if (matcherForAttrib.find()) {  
                 matcherForAttrib.appendReplacement(sbreplace,prefix);     
             }     
             matcherForAttrib.appendTail(sbreplace);   
             matcherForTag.appendReplacement(sb, sbreplace.toString()+">");  
             result = matcherForTag.find();     
         }     
         matcherForTag.appendTail(sb);     
         return sb.toString();           
    }
    
    public static String getDomain(HttpServletRequest request){
		String host = request.getHeader("host");
		if(StringUtil.isEmpty(host))
			return null;
		return host.replaceAll(":.*?$","").toLowerCase();
	}

    public static String maskString4Mobile(String src) {
		if (src == null) {
			return "";
		}
		return maskNickNameString( src );
	}

	public static String lowNumToUpStr(int index){
		switch (index) {
		case 1:
			return "一";
		case 2:
			return "二";
		case 3:
			return "三";
		case 4:
			return "四";
		case 5:
			return "五";
		case 6:
			return "六";
		case 7:
			return "七";
		case 8:
			return "八";
		case 9:
			return "九";
		case 10:
			return "十";
		case 11:
			return "十一";
		case 12:
			return "十二";
		case 13:
			return "十三";
		case 14:
			return "十四";
		case 15:
			return "十五";
		case 16:
			return "十六";
		default:
			return "一";
		}
	}

  	/**
	 * 参数做一个字母小写升序排序
	 * @param strParam
	 * @return
	 */
	@Deprecated
	public static String paramSort(String strParam){
		if(null != strParam){
			String[] str = strParam.split("&");
			StringBuilder sb = new StringBuilder();
			if(null != str){
				List<String> list = new ArrayList<String>();
				Map<String, String> map = new HashMap<String, String>();
				for(int i=0;i<str.length;i++){
					String str1[] = str[i].split("=");
					if(null != str1){
						if(str1.length>1){
							map.put(str1[0], str1[1]);
						}else{
							map.put(str1[0], "");
						}
						list.add(str1[0].toLowerCase()); // 全部转成小写字母
					}
				}
				// 排序后
				list = StringUtil.sort(list);
				for(int i=0;i<list.size();i++){
					sb.append(list.get(i)+"="+map.get(list.get(i)));
					if(list.size()-1 != i){
						sb.append("&");
					}
				}
			}else{
				return null;
			}
			return sb.toString();
		}
		return null;
	}
	
	/**
	 * 按字母升序排序 ac,ba,c,d
	 * @param list
	 * @return
	 */
	public static List<String> sort(List<String> list){
		Collections.sort(list);
		return list;
	}

	/**
	 * 得到参数数据封装到Map
	 * @param strParam
	 * @return
	 */
	public static Map<String,String> paramMap(String strParam){
		Map<String,String> map = null;
		if(null != strParam){
			String[] str = strParam.split("&");
			if(null != str){
				map = new HashMap<String, String>();
				for(int i=0;i<str.length;i++){
					String str1[] = str[i].split("=");
					if(null != str1){
						if(str1.length>1){
							map.put(str1[0], str1[1]);
						}else{
							map.put(str1[0], "");
						}
					}
				}
				return map;
			}
		}
		return null;
	}

	public static String encode(String str){
		if(StringUtil.isEmpty(str))
			return "";
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	public static int SIZE =6;
	public static String SYMBOL = "*";

	public static String toConceal(String str) {
		if(null == str || "".equals(str))
			return str;
		int l = str.length();
		int a = l/2;
		int b = a-1;
		int c = l%2;
		StringBuffer sb = new StringBuffer(l);
		if(l <= 2) {
			if(c==1)
				return SYMBOL;
			sb.append(SYMBOL);
			sb.append(str.charAt(l-1));
		}else {
			if(b<=0) {
				sb.append(str.substring(0, 1));
				sb.append(SYMBOL);
				sb.append(str.substring(l-1, l));
			}else if(b>=SIZE/2 && SIZE+1!=l){
				int e = (l-SIZE)/2;
				sb.append(str.substring(0, e));
				for(int i = 0;i<SIZE;i++)
					sb.append(SYMBOL);
				if((c==0&&SIZE%2==0)||(c!=0&&SIZE%2!=0))
					sb.append(str.substring(l-e, l));
				else
					sb.append(str.substring(l-(e+1), l));
			}else {
				int d = l -2 ;
				sb.append(str.substring(0, 1));
				for(int i = 0;i<d;i++)
					sb.append(SYMBOL);
				sb.append(str.substring(l-1, l));
			}
		}
		return sb.toString();
	}
	public static <V> List<V> randomList(List<V> sourceList) {
		if (sourceList == null || sourceList.size() == 0) {
			return sourceList;
		}
		List<V> random = new ArrayList<V>(sourceList.size());
		do {
			int index = Math.abs(new Random().nextInt(sourceList.size()));
			random.add(sourceList.remove(index));

		} while (sourceList.size() > 0);

		return random;

	}
	
	public static BigDecimal parseDecimal(String src, BigDecimal def) {
    	BigDecimal ret = def;
    	try {
    		ret = new BigDecimal(src);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return ret;
    }
	
}
 
	
