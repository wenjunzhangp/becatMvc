package com.baozi.controller;

import com.baozi.po.IndustryConsultancy;
import com.baozi.service.IndustryConsultancyService;
import com.baozi.statics.Constant;
import com.baozi.util.LogUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 16:39
 * @description 文章相关控制器
 **/
@RequestMapping("/console")
@Controller
public class IndustryConsultancyController extends BaseController{

    @Autowired
    private IndustryConsultancyService industryConsultancyService;

    @RequestMapping("/indusData")
    @ResponseBody
    public CodeResult sysconfigData(){
        try {
            return CodeResult.ok(industryConsultancyService.findIndustryConsultancyTop5());
        } catch ( Exception e ) {
            LogUtils.logError("调取最新文章错误",e);
            return CodeResult.build(500,"error");
        }
    }

    @RequestMapping("/article")
    public String articleUI(){
        return "/industry/industryData";
    }

    @RequestMapping("/indusPage")
    @ResponseBody
    public Map<String,Object> indusPage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOk(industryConsultancyService.findIndustryConsultancyPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取文章列表数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }
}
