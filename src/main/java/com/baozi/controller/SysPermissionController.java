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

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/allauthc")
    public String allauthcUI(){
        return "/permission/allauthc";
    }

    @RequestMapping("/sysPermissionData")
    @ResponseBody
    public Map<String, Object> sysPermissionData(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(systemService.findSysPermissionPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取权限列表数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/deleteSysPermissionSingleOrBatch")
    @ResponseBody
    public CodeResult deleteSysPermissionSingleOrBatch(String ids){
        try {
            List idList = Arrays.asList(ids.split(","));
            systemService.deleteSysPermissionSingleOrBatch(idList);
            return CodeResult.build(200,"批量操作成功");
        } catch ( Exception e ) {
            LogUtils.logError("删除权限出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }
}
