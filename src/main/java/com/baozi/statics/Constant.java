package com.baozi.statics;

import com.baozi.util.IConfig;

import java.util.Calendar;

public interface Constant {
	
	static final String CONTEXT_PATH = "contextPath";/***项目根路径*/

	static final String TARGET = "target";//标签使用目标
	
	static final String OUT_TAG_NAME = "outTagName";//输出标签Name

	/**其他常用变量 begin**/
	static final String NAME = "name" ;
	static final String ID = "id" ;
	static final String TOKEN = "token" ;
	static final String LOING_USER  = "loing_user" ;

	/**cache常用变量 begin**/
	static final String CACHE_NAME = "shiro_cache";
	static final String CACHE_MANAGER = "cacheManager" ;//cacheManager bean name
	/**cache常用变量 end**/
	
	/**当前年份**/
	static final int NOW_YEAY = Calendar.getInstance().get(Calendar.YEAR);

	/**地址**/
	static final String DOMAIN_WWW = IConfig.get("www.becat.domain");//前端域名

	/**系统版本号，与数据库版本对应**/
	static int VERSION = 1;
}
