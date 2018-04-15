package com.baozi.controller;

import com.baozi.po.SysSetting;
import com.baozi.service.SysSettingService;
import com.baozi.util.LogUtils;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 16:13
 * @description 系统基本配置控制器
 **/
@RequestMapping("/console")
@Controller
public class SysSettingController extends BaseController{

    @Autowired
    private SysSettingService sysSettingService;

    @RequestMapping("/sysconfig")
    @ResponseBody
    public CodeResult sysconfigData(){
        try {
            return CodeResult.ok(sysSettingService.findSysSettingById());
        } catch ( Exception e ) {
            LogUtils.logError("调取系统基本配置信息错误",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/syssetting")
    public String sysSetting(HttpServletRequest request){
        setValueRequest(request,"sysSetting",sysSettingService.findSysSettingById());
        return "/systemSetting/sysSetting";
    }

    @RequestMapping("/modifySysSetting")
    @ResponseBody
    public CodeResult modifySysSetting(SysSetting sysSetting){
        try {
            sysSetting.setLastModifyTime(new Date());
            sysSettingService.updateSysSetting(sysSetting);
            return CodeResult.ok();
        } catch ( Exception e ) {
            LogUtils.logError("系统基本配置信息修改失败",e);
            return CodeResult.build(500,e.getMessage());
        }
    }
}
