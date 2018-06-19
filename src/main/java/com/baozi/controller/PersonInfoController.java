package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.po.SysUser;
import com.baozi.service.SysUserService;
import com.baozi.util.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @author wenjun.zhang
 * @create 2018-02-26 11:54
 * @description 个人信息
 **/
@RequestMapping("/console")
@Controller
public class PersonInfoController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    /**
     * 个人信息界面
     * @return
     */
    @RequestMapping("/personInfo")
    public String personInfo(HttpServletRequest request) {
        SysUser sysUser = sysUserService.findSysUserByUserId(super.loginUser().getUserid());
        setValueRequest(request,"userInfo",sysUser);
        setValueRequest(request,"userImg",IConfig.get("becat.imgserver.prefix")+sysUser.getSourceimg());
        return "/user/personInfo";
    }

    /**
     * 修改密码界面
     * @return
     */
    @RequestMapping("/updatepwd")
    public String updatepwd() {
        return "/user/updatepwd";
    }

    /**
     * 提交个人资料修改
     * @param request
     * @param sysUser
     * @return
     */
    @RequestMapping("/updateper")
    @ResponseBody
    public CodeResult updateper(HttpServletRequest request,SysUser sysUser) {
        try {
            //替换掉爱好的第一个字母
            StringBuilder sb = new StringBuilder(sysUser.getHobby());
            sb.replace(0,1,"");
            sysUser.setHobby(sb.toString());
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            sysUserService.updateUserInfo(sysUser,activeUser,session);
            return CodeResult.ok();
        } catch ( Exception e ) {
            LogUtils.logError("个人资料更新失败!用户id是"+sysUser.getId(),e);
            return CodeResult.build(500,"个人资料更新失败!");
        }
    }

    /**
     * 检测用户输入的密码是否一致
     * @param request
     * @param oldpwd
     * @return
     */
    @RequestMapping("/checkPwd")
    @ResponseBody
    public CodeResult checkPwd(HttpServletRequest request,String oldpwd) {
        ActiveUser activeUser = super.loginUser();
        SysUser checkUser = sysUserService.findSysUserByUserId(activeUser.getUserid());
        String checkPwd = MD5Factory.genPassWordWithUserSalt(oldpwd,checkUser.getSalt(),1);
        if ( checkPwd.equalsIgnoreCase(checkUser.getPassword()) ) {
            return CodeResult.ok();
        } else {
            return CodeResult.build(500,"原密码校验失败，停止改密！");
        }
    }

    /**
     * 提交修改密码
     * @param request
     * @param newpwd
     * @return
     */
    @RequestMapping("/updatepassword")
    @ResponseBody
    public CodeResult updatepassword(HttpServletRequest request,String newpwd) {
        ActiveUser activeUser = super.loginUser();
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            sysUserService.updateUserPwd(activeUser.getUserid(),newpwd,activeUser,session);
            return CodeResult.ok();
        } catch ( Exception e ) {
            LogUtils.logError("个人密码更新失败!用户id是"+activeUser.getUserid(),e);
            return CodeResult.build(500,"密码更新失败!");
        }
    }

    @RequestMapping("/uploadUserFaceImg")
    @ResponseBody
    public CodeResult uploadUserFaceImg(HttpServletRequest request,MultipartHttpServletRequest multiRequest) {
        try {
            ActiveUser activeUser = super.loginUser();
            String resultFilePaths = FileUploadUtil.uploadFile(multiRequest);
            SysUser sysUser = new SysUser();
            sysUser.setId(activeUser.getUserid());
            sysUser.setSourceimg(resultFilePaths);
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            sysUserService.updateUserInfo(sysUser,activeUser,session);
            return CodeResult.ok(IConfig.get("becat.imgserver.prefix")+resultFilePaths);
        } catch (Exception e) {
            LogUtils.logError("用户头像文件长传失败",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

}
