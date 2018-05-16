package com.baozi.controller;

import com.baozi.service.SystemService;
import com.baozi.util.LogUtils;
import com.baozi.vo.UserRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 角色分配controller
 */
@RequestMapping("/console")
@Controller
public class RoleDistributionController extends BaseController{

    @Autowired
    private SystemService systemService;

    @RequestMapping("/roledistribution")
    public String roledistribution(){
        return "/permission/roleDistribution";
    }

    @RequestMapping("/userAndRolePage")
    @ResponseBody
    public Map<String,Object> userAndRolePage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(systemService.findUserRoleAllocationPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取角色分配列表数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping(value="selectRoleByUserId")
    @ResponseBody
    public CodeResult selectRoleByUserId(int userId){
        try {
            return CodeResult.ok(systemService.selectRoleByUserId(userId));
        } catch ( Exception e ){
            return CodeResult.build(500,"加载角色出错，请稍后再试");
        }
    }

    @RequestMapping(value="addRoleToUser")
    @ResponseBody
    public CodeResult addRoleToUser(int userId,String ids){
        try {
            systemService.addRoleToUser(userId,ids);
            return CodeResult.build(200,"赋予角色成功");
        } catch ( Exception e ){
            return CodeResult.build(500,"为用户【"+userId+"】赋予新角色失败，请稍后再试");
        }
    }

}
