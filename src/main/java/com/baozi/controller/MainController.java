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
 * @description 后台主界面
 **/
@RequestMapping("/console")
@Controller
public class MainController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PetService petService;

    /**
     * 主体界面
     * @return
     */
    @RequestMapping("/main")
    public String main(HttpServletRequest request) {
        ActiveUser activeUser = super.loginUser();
        //获取平台用户总数
        request.setAttribute("userCount",sysUserService.findAllUserCount());
        //获取平台宠物数量
        request.setAttribute("petCount",petService.findAllPetCount());
        //获取用户最后登录时间
        request.setAttribute("userLastLoginTime", DateUtil.formatDate(sysUserService.findUserLastLoginTime(activeUser.getUserid()),"yyyy-MM-dd HH:mm:ss"));
        return "main";
    }

}
