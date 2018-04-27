package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.po.SysRole;
import com.baozi.service.SystemService;
import com.baozi.util.LogUtils;
import com.baozi.util.PermissionDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author wenjun.zhang
 * @create 2018-04-27 11:17
 * @description
 **/
@RequestMapping("/console")
@Controller
public class SysPermissionController extends BaseController{

    @Autowired
    private SystemService systemService;

    @RequestMapping("/myauthc")
    public String myauthcUI(){
        return "/permission/myAuthc";
    }

    @RequestMapping("/myPermissionTree")
    @ResponseBody
    public Map<String, Object> myPermissionTree(){
        Map<String, Object> treeMap = new HashMap<String, Object>();
        try {
            ActiveUser activeUser = super.loginUser();
            List<SysRole> roles = systemService.findNowAllPermission(activeUser.getUserid());
            List<Map<String, Object>> data  = PermissionDataFactory.toTreeData(roles);
            treeMap.put("data",data);
        } catch ( Exception e ) {
            LogUtils.logError("获取我的权限出现异常",e);
        }
        return treeMap;
    }
}
