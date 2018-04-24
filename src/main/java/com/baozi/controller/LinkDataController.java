package com.baozi.controller;

import com.baozi.service.SysLinkService;
import com.baozi.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-04-23 18:55
 * @description
 **/
@RequestMapping("/console")
@Controller
public class LinkDataController extends BaseController{

    @Autowired
    private SysLinkService sysLinkService;

    @RequestMapping("/friend")
    public String friendUI(){
        return "/systemSetting/linkData";
    }

    @RequestMapping("/linkadd")
    public String linkadd(){
        return "/systemSetting/linkModify";
    }

    @RequestMapping("/sysLinkPage")
    @ResponseBody
    public Map<String,Object> sysLinkPage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(sysLinkService.findSysLinkPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取友情链接数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }
}
