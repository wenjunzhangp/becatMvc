package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.service.SysLogService;
import com.baozi.service.UserLogService;
import com.baozi.statics.Constant;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.Map.Entry;

public class BaseController {

	@Autowired
	protected UserLogService userLogService;

	protected int pageNo =1;
	protected int pageSize = 10;
	private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
	protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
	public static String URL404 =  "/open/404.shtml";
	public static String URL500 =  "/open/500.shtml";
	public static String URLUNAUTHORIZED =  "/open/unauthorized.shtml";

	/**
	 * 往Request里带值
	 * @param request
	 * @param key
	 * @param value
	 */
	protected static void setValueRequest(HttpServletRequest request,String key,Object value){
		request.setAttribute(key, value);
	}

	/**
	 * 赋值分页参数信息
	 * @param request
	 */
	protected void setPageInfo(HttpServletRequest request){
		String pageNoStr = request.getParameter("page");
		if ( StringUtils.isNotBlank(pageNoStr) ) {
			pageNo = Integer.valueOf(pageNoStr);
		}
		String pageSizeStr = request.getParameter("limit");
		if ( StringUtils.isNotBlank(pageSizeStr) ) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
	}

	/**
	 * 分页返回成功的响应体
	 * @param pageInfo
	 */
	protected void setResultMapOkByPage(PageInfo pageInfo){
		resultMap.put(Constant.CODE,Constant.HTTP_DEFAULT);
		resultMap.put(Constant.MESSAGE,"");
		resultMap.put("count",pageInfo.getTotal());
		resultMap.put(Constant.DATA,pageInfo.getList());
	}

	/**
	 * 普通请求返回成功的响应体
	 * @param object
	 */
	protected void setResultMapOk(Object object){
		resultMap.put(Constant.CODE,Constant.HTTP_DEFAULT);
		resultMap.put(Constant.MESSAGE,"");
		resultMap.put(Constant.DATA,object);
	}

	/**
	 * 分页返回失败的响应体
	 * @param e 异常信息
	 */
	protected void setResultMapError( Exception e ){
		resultMap.put(Constant.CODE,Constant.HTTP_ERROR);
		resultMap.put(Constant.MESSAGE,e.getMessage());
	}

	/**
	 * 获取请求属性封装为Map类型
	 * @param request
	 * @return
	 */
	protected Map<String, Object> genRequestMapSingle(HttpServletRequest request) {
		Map<String, Object> conditions = new HashMap<>(256);
		Map map = request.getParameterMap();
		for (Object o : map.keySet()) {
			String key = (String) o;
			conditions.put(key, ((String[]) map.get(key))[0]);
		}
		setPageInfo(request);
		return conditions;
	}

	/**
	 * 获取session
	 * @param request
	 * @return
	 */
	public static HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}

	public ModelAndView redirect(String redirectUrl, Map<String,Object>...parament){
		ModelAndView view = new ModelAndView(new RedirectView(redirectUrl));
		if(null != parament && parament.length > 0){
			view.addAllObjects(parament[0]);
		}
		return view;
	}

	public ModelAndView redirect404(){
		return new ModelAndView(new RedirectView(URL404));
	}

	/**
	 * 获取用户登录信息
	 * @return
	 */
	protected ActiveUser loginUser(){
		//从shiro的subject中取出身份信息
		Subject subject= SecurityUtils.getSubject();
		ActiveUser activeUser=(ActiveUser)subject.getPrincipal();
		if ( null != activeUser ) {
			return activeUser;
		}
		return null;
	}
	
}
