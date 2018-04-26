package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.po.SysUser;
import com.baozi.service.SysUserService;
import com.baozi.util.GenerateLogFactory;
import com.baozi.util.LogUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author 老笼包
 * @create 2017-06-16 11:11
 * @description 用户登录认证
 **/
@RequestMapping("/console")
@Controller
public class LoginController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    /**
     * 跳转到登录界面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 后台首页
     * @param request
     * @return
     */
    @RequiresUser
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        setValueRequest(request,"activeUser",super.loginUser());
        return "index";
    }

    /**
     * 登录检测
     * @param request
     * @return
     */
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
                /*System.out.println("session的Id"+session.getId());
                System.out.println("session主机地址"+session.getHost());
                System.out.println("session有效期间"+session.getId());*/
                ActiveUser activeUser = super.loginUser();
                Session session = subject.getSession();
                SysUser sysUser = sysUserService.findSysUserByUserId(activeUser.getUserid());
                sysUser.setLastLoginTime(new Date());
                sysUserService.updateUserInfo(sysUser);
                userLogService.insert(GenerateLogFactory.buildUserLogCurrency(activeUser,"登陆",(short) 0,activeUser.getUsername()+"登陆后台系统",session.getHost()));
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
            } catch ( Exception e ) {
                return CodeResult.build(500,e.getMessage());
            }
        }
        return CodeResult.build(500,"发生未知错误");
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value="logout",method =RequestMethod.GET)
    @ResponseBody
    public CodeResult logout(){
        try {
            SecurityUtils.getSubject().logout();
            return CodeResult.ok();
        } catch (Exception e) {
            LogUtils.logError("退出出现错误"+e.getMessage(),e);
            return CodeResult.build(500,"退出遇到问题请重试");
        }
    }

    /**
     * 锁屏
     * @param request
     * @return
     */
    @RequestMapping("/lock")
    @ResponseBody
    public CodeResult lock(HttpServletRequest request) {
        return CodeResult.ok();
    }

    /**
     * 解锁
     * @param request
     * @return
     */
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
