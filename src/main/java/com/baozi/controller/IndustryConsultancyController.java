package com.baozi.controller;

import com.baozi.service.IndustryConsultancyService;
import com.baozi.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
