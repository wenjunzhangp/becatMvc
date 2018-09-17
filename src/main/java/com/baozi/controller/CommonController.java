package com.baozi.controller;

import com.baozi.config.Iconfig;
import com.baozi.util.FileUploadUtil;
import com.baozi.util.LogUtils;
import com.baozi.util.vcode.Captcha;
import com.baozi.util.vcode.GifCaptcha;
import com.baozi.util.vcode.SpecCaptcha;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
	public String notFound(HttpServletRequest request){
		return "404";
	}
	/**
	 * 500错误
	 * @param request
	 * @return
	 */
	@RequestMapping("500")
	public String exceptionPage(HttpServletRequest request){
		return "500";
	}

	/**
	 * 没有权限提示页面
	 * @return
	 */
	@RequestMapping("unauthorized")
	public String unauthorized(){
		return "unauthorized";
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

	@RequestMapping("/uploadImg")
	@ResponseBody
	public Map<String,Object> uploadUserFaceImg(HttpServletRequest request,MultipartHttpServletRequest multiRequest) {
		Map<String,Object> map = new HashMap<>(256);
		try {
			String resultFilePaths = FileUploadUtil.uploadFile(multiRequest);
			map.put("code",0);
			map.put("msg","上传成功！");
			Map<String,Object> src = new HashMap<>(256);
			src.put("filename",resultFilePaths.substring(resultFilePaths.indexOf("/")+1,resultFilePaths.length()));
			src.put("src", Iconfig.get("becat.imgserver.prefix")+resultFilePaths);
			map.put("data",src);
		} catch (Exception e) {
			LogUtils.logError("图像文件长传失败",e);
			map.put("code",500);
			map.put("msg","上传失败，接口异常！");
			map.put("data","");
		}
		return map;
	}

	@RequestMapping("/paintingfile")
	@ResponseBody
	public Map<String,Object> paintingfile(HttpServletRequest request,MultipartHttpServletRequest multiRequest) {
		Map<String,Object> map = new HashMap<>(256);
		try {
			String nickname = request.getParameter("nickname");
			System.out.println("**********************************"+nickname);
			System.out.println(multiRequest);
			String resultFilePaths = FileUploadUtil.uploadFile(multiRequest);
			System.out.println("上传返回的路径"+resultFilePaths);
			map.put("code",0);
			map.put("msg","上传成功！");
			Map<String,Object> src = new HashMap<>(256);
			src.put("filename",resultFilePaths.substring(resultFilePaths.indexOf("/")+1,resultFilePaths.length()));
			src.put("src", Iconfig.get("becat.imgserver.prefix")+resultFilePaths);
			map.put("data",src);
		} catch (Exception e) {
			LogUtils.logError("图像文件长传失败",e);
			map.put("code",500);
			map.put("msg","上传失败，接口异常！");
			map.put("data","");
		}
		return map;
	}

}
