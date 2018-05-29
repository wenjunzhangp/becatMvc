package com.baozi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewIndexController {

    @RequestMapping("/product")
    public String viewIndex(){
        return "product";
    }
}
