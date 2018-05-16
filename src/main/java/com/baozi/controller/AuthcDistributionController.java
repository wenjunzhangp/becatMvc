package com.baozi.controller;

import com.baozi.service.SystemService;
import com.baozi.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 权限分配controller
 */
@RequestMapping("/console")
@Controller
public class AuthcDistributionController extends BaseController{

    @Autowired
    private SystemService systemService;

    @RequestMapping("/authcdistribution")
    public String authcdistribution(){
        return "/permission/authcDistribution";
    }

    @RequestMapping("/rolePermissionAllocationPage")
    @ResponseBody
    public Map<String,Object> rolePermissionAllocationPage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(systemService.findRolePermissionAllocationPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取权限分配列表数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping(value="selectPermissionById")
    @ResponseBody
    public CodeResult selectPermissionById(int permissionId){
        try {
            return CodeResult.ok(systemService.selectPermissionById(permissionId));
        } catch ( Exception e ){
            return CodeResult.build(500,"加载权限出错，请稍后再试");
        }
    }

    @RequestMapping(value="addPermissionToRole")
    @ResponseBody
    public CodeResult addPermissionToRole(int roleId,String ids){
        try {
            systemService.addPermissionToRole(roleId,ids);
            return CodeResult.build(200,"赋予权限成功");
        } catch ( Exception e ){
            return CodeResult.build(500,"为角色【"+roleId+"】赋予新权限失败，请稍后再试");
        }
    }

}
