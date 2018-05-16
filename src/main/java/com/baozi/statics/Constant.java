package com.baozi.statics;

import com.baozi.util.IConfig;

import java.util.Calendar;

public class Constant {

	/**HHTP响应状态码定义**/
	public final static String CODE = "code";
	public final static String MESSAGE = "msg";
	public final static String DATA = "data";
	public final static int HTTP_DEFAULT = 0;
	public final static int HTTP_OK = 200;
	public final static int HTTP_ERROR = 500;

	/***项目根路径*/
	public static final String CONTEXT_PATH = "contextPath";

	/**其他常用变量 begin**/
	public static final String NAME = "name" ;
	public static final String ID = "id" ;
	public static final String TOKEN = "token" ;
	public static final String LOING_USER  = "loing_user" ;
	/**其他常用变量 end**/

	/**cache常用变量 begin**/
	public static final String CACHE_NAME = "shiro_cache";
	public static final String CACHE_MANAGER = "cacheManager" ;//cacheManager bean name
	/**cache常用变量 end**/
	
	/**当前年份**/
	public static final int NOW_YEAY = Calendar.getInstance().get(Calendar.YEAR);

	/**地址**/
	public static final String WWW_DOMAIN = IConfig.get("www.becat.domain");//前端域名

	/**系统版本号**/
	public static double VERSION = 1.0;

	/*超级管理员的userid*/
	public static final int SUPER_MANAGER_USERID = 1;
}
