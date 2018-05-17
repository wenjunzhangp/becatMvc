package com.baozi.util;

import net.sf.json.JSONObject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author 包子
 * @version 1.0,2016年5月27日 <br/>
 */
public class ShiroFilterUtils {

	final static Class<? extends ShiroFilterUtils> CLAZZ = ShiroFilterUtils.class;

	//登录页面
	public static final String LOGIN_URL = "/console/login.shtml";
	//没有权限提醒
	public final static String UNAUTHORIZED = "/open/unauthorized.shtml";

	/**
	 * 是否是Ajax请求
	 * @param request
	 * @return
	 */
	public static boolean isAjax(ServletRequest request){
		return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
	}
	
	/**
	 * response 输出JSON
	 * @param resultMap
	 * @throws IOException
	 */
	public static void out(ServletResponse response, Map<String, String> resultMap){
		
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.println(JSONObject.fromObject(resultMap).toString());
		} catch (Exception e) {
			LogUtils.logError("输出JSON异常",e);
		}finally{
			if(null != out){
				out.flush();
				out.close();
			}
		}
	}
}
