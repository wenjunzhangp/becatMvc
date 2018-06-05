package com.baozi.controller;

import com.baozi.service.IndustryConsultancyService;
import com.baozi.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/view/page")
@Controller
public class ViewPageController extends BaseController{

    @Autowired
    private IndustryConsultancyService industryConsultancyService;

    @RequestMapping("/newsdata")
    @ResponseBody
    public Map<String,Object> newsdata(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(industryConsultancyService.findIndustryConsultancyPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取新闻文章前端分页异常",e);
            setResultMapError(e);
        }
        return resultMap;
    }

}
