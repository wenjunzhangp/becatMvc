package com.baozi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wenjun.zhang
 * @create 2018-02-26 11:54
 * @description 个人信息
 **/
@RequestMapping("/console")
@Controller
public class PersonInfoController {

    @RequestMapping("/personInfo")
    public String personInfo() {
        return "personInfo";
    }

}
