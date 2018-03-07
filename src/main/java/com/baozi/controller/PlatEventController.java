package com.baozi.controller;

import com.baozi.service.PlatEventService;
import com.baozi.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
            return CodeResult.build(500,"error");
        }
    }
}
