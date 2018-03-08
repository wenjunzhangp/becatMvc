package com.baozi.controller;

import com.baozi.util.LogUtils;
import com.baozi.util.vcode.Captcha;
import com.baozi.util.vcode.GifCaptcha;
import com.baozi.util.vcode.SpecCaptcha;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Scope(value="prototype")
@RequestMapping("open")
public class CommonController extends BaseController {
	/**
	 * 404错误
	 * @param request
	 * @return
	 */
	@RequestMapping("404")
	public ModelAndView _404(HttpServletRequest request){
		ModelAndView view = new ModelAndView("/404");
		return view;
	}
	/**
	 * 500错误
	 * @param request
	 * @return
	 */
	@RequestMapping("500")
	public ModelAndView _500(HttpServletRequest request){
		ModelAndView view = new ModelAndView("/500");
		
		Throwable t = (Throwable)request.getAttribute("javax.servlet.error.exception");
		String defaultMessage = "未知" ;
		if(null == t){
			view.addObject("line", defaultMessage);
			view.addObject("clazz", defaultMessage);
			view.addObject("methodName",defaultMessage);
			return view;
		}
		String message = t.getMessage() ;//错误信息
		StackTraceElement[] stack = t.getStackTrace();
		view.addObject("message", message);
		if(null != stack && stack.length != 0 ){
			StackTraceElement element = stack[0];
			int line = element.getLineNumber();//错误行号
			String clazz = element.getClassName();//错误java类
			String fileName = element.getFileName();
			
			String methodName = element.getMethodName() ;//错误方法
			view.addObject("line", line);
			view.addObject("clazz", clazz);
			view.addObject("methodName",methodName);
			LogUtils.logError("line:"+line+",clazz:+"+clazz+",fileName:"+fileName+",methodName:"+methodName+"");
		}
		return view;
	}

	/**
	 * 没有权限提示页面
	 * @return
	 */
	@RequestMapping(value="unauthorized",method= RequestMethod.GET)
	public ModelAndView unauthorized(){
		return new ModelAndView("/unauthorized");
	}

	/**
	 * 获取验证码（Gif版本）
	 * @param response
	 */
	@RequestMapping(value="/getGifCode",method= RequestMethod.GET)
	public void getGifCode(HttpServletResponse response, HttpServletRequest request){
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/gif");
			/**
			 * gif格式动画验证码
			 * 宽，高，位数。
			 */
			Captcha captcha = new GifCaptcha(146,42,4);
			//输出
			ServletOutputStream out = response.getOutputStream();
			captcha.out(out);
			out.flush();
			HttpSession session= request.getSession();
			session.setAttribute("validateCode",captcha.text().toLowerCase());
		} catch (Exception e) {
			LogUtils.logInfo("获取验证码异常"+e.getMessage());
		}
	}

	/**
	 * 获取验证码（jpg版本）
	 * @param response
	 */
	@RequestMapping(value="getJPGCode",method= RequestMethod.GET)
	public void getJPGCode(HttpServletResponse response,HttpServletRequest request){
		try {
			response.setHeader("Pragma", "No-cache");  
			response.setHeader("Cache-Control", "no-cache");  
			response.setDateHeader("Expires", 0);  
			response.setContentType("image/jpg");  
			/**
			 * jgp格式验证码
			 * 宽，高，位数。
			 */
			Captcha captcha = new SpecCaptcha(146,33,4);
			//输出
			captcha.out(response.getOutputStream());
			HttpSession session = request.getSession(true);  
			//存入Session
			session.setAttribute("_code",captcha.text().toLowerCase());  
		} catch (Exception e) {
			LogUtils.logError("获取验证码异常",e);
		}
	}

}
