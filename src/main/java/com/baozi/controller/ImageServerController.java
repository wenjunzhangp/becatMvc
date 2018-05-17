package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.service.PetService;
import com.baozi.service.SysUserService;
import com.baozi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wenjun.zhang
 * @create 2018-02-25 0:58
 * @description 服务器图片列表
 **/
@RequestMapping("/console")
@Controller
public class ImageServerController extends BaseController{

    @RequestMapping("/image")
    public String image(HttpServletRequest request) {
        return "/img/images";
    }

}
