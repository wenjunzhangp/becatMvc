package com.baozi.util;

import com.baozi.config.Iconfig;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

/**
 * @author wenjun.zhang
 * @create 2018-03-15 10:25
 * @description 文件上传工具类
 **/
public class FileUploadUtil {

    public static String uploadFile(MultipartHttpServletRequest multiRequest) throws IOException {
        String filePath = Iconfig.get("becat.ftp.filepath");
        String resultFilePath = "";
        String imgPath = "";
        File dir = new File(filePath);
        if(!dir.exists()) {
            {
                dir.mkdirs();
            }
        }
        Iterator<String> filesNames = multiRequest.getFileNames();
        while (filesNames.hasNext()) {
            String fileName = filesNames.next();
            MultipartFile file = multiRequest.getFile(fileName);
            String originalFilename = file.getOriginalFilename();
            if (!file.isEmpty()) {
                String imgname = IDUtils.genImageName()+originalFilename;
                String dick = DateUtil.formatDate(new Date(),"yyyyMMdd");
                resultFilePath = dick +"/" + imgname;
                FtpUtil.uploadFile(Iconfig.get("becat.ftp.ip"),Integer.valueOf(Iconfig.get("becat.ftp.port")), Iconfig.get("becat.ftp.user"), Iconfig.get("becat.ftp.password"),
                        filePath,dick,imgname,file.getInputStream());
            }
        }
        return resultFilePath;
    }
}
