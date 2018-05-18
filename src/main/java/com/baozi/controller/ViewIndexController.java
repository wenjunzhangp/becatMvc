package com.baozi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewIndexController {

    @RequestMapping("/main")
    public String viewIndex(){
        return "/index";
    }
}
