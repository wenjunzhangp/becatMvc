package com.baozi.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * MD5测试生成器
 */
public class MD5Factory {
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
