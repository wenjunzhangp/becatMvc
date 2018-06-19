package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.service.SysUserService;
import com.baozi.util.LogUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-04-27 15:05
 * @description
 **/
@RequestMapping("/console")
@Controller
public class SysUserController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/alluser")
    public String alluserUI(){
        return "user/userData";
    }

    @RequestMapping("/userPage")
    @ResponseBody
    public Map<String,Object> userPage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(sysUserService.findSysUserPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取用户列表数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/updateSysUserLock")
    @ResponseBody
    public CodeResult updateSysUserLock(String lock){
        ActiveUser activeUser = super.loginUser();
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            sysUserService.updateSysUserLock(activeUser.getUsercode(),lock,activeUser,session);
            return CodeResult.build(200,lock.equals("0")?"解锁成功":"已锁定登录");
        } catch ( Exception e ) {
            LogUtils.logError(lock.equals("0")?"解锁用户【"+activeUser.getUsercode()+"】":"锁定用户【"+activeUser.getUsercode()+"】"+"出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }
}
