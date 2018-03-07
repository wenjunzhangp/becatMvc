package com.baozi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wenjun.zhang
 * @create 2018-02-25 0:58
 * @description 后台主界面
 **/
@RequestMapping("/console")
@Controller
public class MainController extends BaseController{

    /**
     * 主体界面
     * @return
     */
    @RequestMapping("/main")
    public String main() {
        return "main";
    }


}
