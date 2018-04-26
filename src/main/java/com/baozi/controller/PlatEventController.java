package com.baozi.controller;

import com.baozi.po.PlatEvent;
import com.baozi.service.PlatEventService;
import com.baozi.util.IConfig;
import com.baozi.util.LogUtils;
import com.baozi.util.StringUtil;
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
public class PlatEventController extends BaseController{

    @Autowired
    private PlatEventService platEventService;

    @RequestMapping("/eventData")
    @ResponseBody
    public CodeResult eventData(){
        try {
            return CodeResult.ok(platEventService.findAllPlatEvent());
        } catch ( Exception e ) {
            LogUtils.logError("调取平台大事记错误",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/memorabilia")
    public String memorabiliaUI(){
        return "/platEvent/platEventData";
    }

    @RequestMapping("/addOrUpdatePlatEvent")
    public String addOrUpdatePlatEvent(){
        return "/platEvent/platEventMofidy";
    }

    @RequestMapping("/platEventPage")
    @ResponseBody
    public Map<String,Object> platEventPage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(platEventService.findPlatEventPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取平台大事记数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/deletePlatEventSingleOrBatch")
    @ResponseBody
    public CodeResult deletePlatEventSingleOrBatch(String ids){
        try {
            List idList = Arrays.asList(ids.split(","));
            platEventService.deletePlatEventSingleOrBatch(idList);
            return CodeResult.build(200,"批量操作成功");
        } catch ( Exception e ) {
            LogUtils.logError("删除平台大事记出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/updatePlatEventStatus")
    @ResponseBody
    public CodeResult updatePlatEventStatus(int id,int status){
        try {
            platEventService.updatePlatEventStatus(id,status);
            return CodeResult.build(200,status==0?"禁用成功":"启用成功");
        } catch ( Exception e ) {
            LogUtils.logError(status==0?"禁用成功":"启用成功"+"大事记出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/modifyPlatEvent")
    @ResponseBody
    public CodeResult modifyPlatEvent(PlatEvent platEvent){
        try {
            if (null!=platEvent.getId()) {
                platEventService.updatePlatEvent(platEvent);
            } else {
                platEvent.setDisplay(1);
                platEvent.setCreatetime(new Date());
                platEvent.setEdate(new Date());
                platEventService.insert(platEvent);
            }
            return CodeResult.ok();
        } catch ( Exception e ) {
            LogUtils.logError("大事记编辑出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }
}
