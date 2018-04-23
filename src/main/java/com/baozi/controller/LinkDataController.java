package com.baozi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wenjun.zhang
 * @create 2018-04-23 18:55
 * @description
 **/
@RequestMapping("/console")
@Controller
public class LinkDataController extends BaseController{



    @RequestMapping("/friend")
    public String friendUI(){
        return "/systemSetting/linkData";
    }
}
