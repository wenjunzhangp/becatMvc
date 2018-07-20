package com.baozi.statics;


import com.baozi.config.Iconfig;

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
	//cacheManager bean name
	public static final String CACHE_MANAGER = "cacheManager" ;
	/**cache常用变量 end**/
	
	/**当前年份**/
	public static final int NOW_YEAY = Calendar.getInstance().get(Calendar.YEAR);

	/**常亮 0**/
	public static final Long ZERO = 0L;

	/**地址 前端域名**/
	public static final String WWW_DOMAIN = Iconfig.get("www.becat.domain");

	/**系统版本号**/
	public static double VERSION = 1.0;

	/*超级管理员的userid*/
	public static final int SUPER_MANAGER_USERID = 1;

	/*友链出现的展示位置 1 首页 0子页*/
	public static final int LINK_POSITION_PARENT = 1;
	public static final int LINK_POSITION_CHILDREN = 0;

	/*数据取多少条在这里定义*/
	public static final int SHOW_SIZE_NINE = 10;
	public static final int SHOW_SIZE_FIVE = 5;

	/*IPUtil类相关配置*/
	public static final String UNKNOWN = "unknown";
	public static final String INTEGER_NUM = "0:0:0:0:0:0:0:1";

	/*自定义验证码错误常量*/
	public static final String RANDOMCODEERROR = "randomCodeError";

	/*后台锁屏密码的密码   额这里因为服务器配置的原因  redis就不装了  所以缓存机制目前没实现*/
	public static final String LOCK_DESKTOP_PASSWORD = "admin";

	/*微信订阅号 关键字交互定义*/
	public static final String WECHAT_HELLO = "你好";
	public static final String WECHAT_WEATHER = "天气";
	public static final String WECHAT_CLICK_EVENT_ABOUT = "about";
	public static final String WECHAT_LUMAO = "撸猫";
	public static final String WECHAT_SINGSONG = "唱歌";
}
