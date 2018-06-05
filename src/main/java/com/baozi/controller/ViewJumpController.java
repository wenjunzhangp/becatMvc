package com.baozi.controller;

import com.baozi.service.IndustryConsultancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ViewJumpController extends BaseController{

    @Autowired
    private IndustryConsultancyService industryConsultancyService;

    @RequestMapping("/product")
    public String product(){
        return "product";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/joinus")
    public String joinus(){
        return "join";
    }

    @RequestMapping("/event")
    public String event(){
        return "event";
    }

    @RequestMapping("/notice")
    public String notice(){
        return "notice";
    }

    @RequestMapping("/news")
    public ModelAndView news(){
        ModelAndView mav = new ModelAndView("news");
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("page",1);
        paramMap.put("limit",1);
        mav.addObject("total", industryConsultancyService.findIndustryConsultancyPage(paramMap).getTotal());
        return mav;
    }

    @RequestMapping("/blog")
    public String blog(){
        return "blog";
    }

}
