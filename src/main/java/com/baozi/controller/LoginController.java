package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.service.SystemService;
import com.baozi.util.LogUtils;
import com.baozi.util.vcode.Captcha;
import com.baozi.util.vcode.GifCaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 老笼包
 * @create 2017-06-16 11:11
 * @description 用户登录认证
 **/
@RequestMapping("/console")
@Controller
public class LoginController {

    @Autowired
    private SystemService systemService;

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
            //request.setAttribute("validateCode",captcha.text().toLowerCase());
            HttpSession session= request.getSession();
            session.setAttribute("validateCode",captcha.text().toLowerCase());
        } catch (Exception e) {
            LogUtils.logInfo("获取验证码异常"+e.getMessage());
        }
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        //从shiro的subject中取出身份信息
        Subject subject= SecurityUtils.getSubject();
        ActiveUser activeUser=(ActiveUser)subject.getPrincipal();
        request.setAttribute("activeUser",activeUser);
        return "index";
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public CodeResult userLogin(HttpServletRequest request) {
        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                return CodeResult.build(500,"账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                return CodeResult.build(500,"用户名或者密码错误");
            }else if("randomCodeError".equals(exceptionClassName)){
                return CodeResult.build(500,"验证码错误");
            }
        }else{
            Subject subject = SecurityUtils.getSubject();
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            boolean rememberMe = Boolean.valueOf(request.getParameter("rememberMe")).booleanValue();
            UsernamePasswordToken token=null;
            if(rememberMe){
                token = new UsernamePasswordToken(userName, password,rememberMe);
            }else{
                token = new UsernamePasswordToken(userName, password);
            }
            try {
                subject.login(token);
                /*Session session = subject.getSession();
                System.out.println("session的Id"+session.getId());
                System.out.println("session主机地址"+session.getHost());
                System.out.println("session有效期间"+session.getId());*/
                return CodeResult.ok();
            } catch (IncorrectCredentialsException e) {
                return CodeResult.build(500,"用户名或者密码错误");
            } catch (ExcessiveAttemptsException e) {
                return CodeResult.build(500,"登陆次数过多");
            } catch (LockedAccountException e) {
                return CodeResult.build(500,"账号已被锁定");
            } catch (DisabledAccountException e) {
                return CodeResult.build(500,"账号已被禁用");
            } catch (ExpiredCredentialsException e) {
                return CodeResult.build(500,"账号已被禁用");
            } catch (UnknownAccountException e) {
                return CodeResult.build(500,"账号不存在");
            } catch (UnauthorizedException e) {
                return CodeResult.build(500,"登陆失败");
            }
        }
        return CodeResult.build(500,"发生未知错误");
    }

    @RequestMapping("/lock")
    @ResponseBody
    public CodeResult lock(HttpServletRequest request) {
        return CodeResult.ok();
    }

    @RequestMapping("/unlock")
    @ResponseBody
    public CodeResult unlock(HttpServletRequest request) {
        String lockPwd = request.getParameter("lockPwd");
        if ( "admin".equalsIgnoreCase(lockPwd)) {
            return CodeResult.ok();
        }
        return CodeResult.build(500,"解锁失败");
    }
}
