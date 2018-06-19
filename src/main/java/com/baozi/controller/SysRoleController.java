package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.po.PlatEvent;
import com.baozi.po.SysRole;
import com.baozi.service.PlatEventService;
import com.baozi.service.SystemService;
import com.baozi.util.LogUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 17:37
 * @description 大事记的控制器
 **/
@RequestMapping("/console")
@Controller
public class SysRoleController extends BaseController{

    @Autowired
    private SystemService systemService;

    @RequestMapping("/allrole")
    public String allroleUI(){
        return "/role/roleData";
    }

    @RequestMapping("/addOrUpdateSysRole")
    public String addOrUpdateSysRole(){
        return "/role/roleMofidy";
    }

    @RequestMapping("/rolePage")
    @ResponseBody
    public Map<String,Object> rolePage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(systemService.findSysRolePage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取角色分页数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/deleteSysRole")
    @ResponseBody
    public CodeResult deleteSysRole(int id){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            boolean flag = systemService.deleteSysRole(id,activeUser,session);
            if (flag)
                return CodeResult.build(200,"操作成功");
            if (!flag)
                return CodeResult.build(500,"超级管理员不能删除!");
        } catch ( Exception e ) {
            LogUtils.logError("删除平台大事记出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
        return CodeResult.ok();
    }

    @RequestMapping("/modifySysRole")
    @ResponseBody
    public CodeResult modifySysRole(SysRole sysRole){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            if ( sysRole.getId() > 0 ) {
                systemService.updateSysRole(sysRole,activeUser,session);
            } else {
                sysRole.setAvailable("1");
                systemService.insert(sysRole,activeUser,session);
            }
            return CodeResult.ok();
        } catch ( Exception e ) {
            LogUtils.logError("角色编辑出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }
}
