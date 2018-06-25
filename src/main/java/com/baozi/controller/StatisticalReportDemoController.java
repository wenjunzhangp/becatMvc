package com.baozi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baozi.service.StatisticalReportDemoService;
import com.baozi.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-25 15:16
 */
@RequestMapping("/report")
@Controller
public class StatisticalReportDemoController extends BaseController{

    @Autowired
    private StatisticalReportDemoService statisticalReportDemoService;

    @RequestMapping("/view")
    public String barView(HttpServletRequest request){
        return "/report/report";
    }

    @RequestMapping("/bar")
    @ResponseBody
    public String bar(HttpServletRequest request){
        String str = "";
        try {
            str = JSONObject.toJSONString(statisticalReportDemoService.getEchartsBarGraphOption());
            return str;
        } catch ( Exception e ) {
            LogUtils.logError("柱状图生成失败出现异常",e);
        }
        return str;
    }

    @RequestMapping("/line")
    @ResponseBody
    public String line(HttpServletRequest request){
        String str = "";
        try {
            str = JSONObject.toJSONString(statisticalReportDemoService.getEchartsLineGraphOption());
            return str;
        } catch ( Exception e ) {
            LogUtils.logError("折线图生成失败出现异常",e);
        }
        return str;
    }

    @RequestMapping("/pancake")
    @ResponseBody
    public String pancake(HttpServletRequest request){
        String str = "";
        try {
            str = JSONObject.toJSONString(statisticalReportDemoService.getEchartPancakeGraphOption());
            return str;
        } catch ( Exception e ) {
            LogUtils.logError("饼图生成失败出现异常",e);
        }
        return str;
    }
}
