package com.baozi.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author wenjun.zhang
 * @create 2018-02-26 11:54
 * @description MD5生成工具
 **/
public class MD5Factory {

    /**
     * MD5密码生成器
     * @param source 要加密的密码
     * @param salt 用户自己的盐
     * @param hashIterations md5加密次数
     * @return
     */
    public static String genPassWordWithUserSalt(String source,String salt,int hashIterations){
        Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
        String password_md5 =  md5Hash.toString();
        SimpleHash simpleHash = new SimpleHash("md5", source, salt, hashIterations);
        return simpleHash.toString();
    }

    public static void main(String[] args) {
        String source = "1";
        String salt = "uiwueylm";
        int hashIterations = 1;
        Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
        String password_md5 =  md5Hash.toString();
        System.out.println(password_md5);
        SimpleHash simpleHash = new SimpleHash("md5", source, salt, hashIterations);
        System.out.println(simpleHash.toString());
    }
}
