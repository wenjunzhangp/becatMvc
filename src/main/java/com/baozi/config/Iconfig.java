package com.baozi.config;

import com.baozi.util.LogUtils;

import java.io.IOException;
import java.util.Properties;

public class Iconfig {

	/**
	 * 同步锁
	 */
	private static final Object OBJECT = new Object();
	
	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	/**
	 * 配置对象单例模式
	 */
	private static Iconfig config = null;
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/config.properties";
	
	static{
		prop = new Properties();
		try {
			prop.load(Iconfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			LogUtils.logError("加载文件异常，文件路径：%s", e);
		}
		
	}
	
	/**
	 * 获取单例模式对象实例
	 * @return 唯一对象实例
	 */
	public static Iconfig getInstance(){
		if(null==config){
			synchronized (OBJECT) {
				config = new Iconfig();
			}
		}
		return config;
	}
	
	/**
	 */
	public static String get(String key){
		return prop.getProperty(key);
	}
	
}
