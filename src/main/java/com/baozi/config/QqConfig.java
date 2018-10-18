package com.baozi.config;

import java.io.IOException;
import java.util.Properties;

public class QqConfig {

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
	private static QqConfig config = null;
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "properties/qqconnectconfig.properties";
	
	static{
		prop = new Properties();
		try {
			prop.load(QqConfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取单例模式对象实例
	 * @return 唯一对象实例
	 */
	public static QqConfig getInstance(){
		if(null==config){
			synchronized (OBJECT) {
				config = new QqConfig();
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
