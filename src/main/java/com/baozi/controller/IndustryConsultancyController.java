package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.po.IndustryConsultancy;
import com.baozi.service.IndustryConsultancyService;
import com.baozi.statics.Constant;
import com.baozi.util.LogUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.logging.Logger;

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
            return CodeResult.ok(industryConsultancyService.findIndustryConsultancyTopLimit(Constant.SHOW_SIZE_FIVE));
        } catch ( Exception e ) {
            LogUtils.logError("调取最新文章错误",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/article")
    public String articleUI(){
        return "/industry/industryData";
    }

    @RequestMapping("/addOrUpdateIndus")
    public String addOrUpdateIndus(){
        return "/industry/indusMofidy";
    }

    @RequestMapping("/initIndusAllCategory")
    @ResponseBody
    public CodeResult initIndusAllCategory(){
        try {
            return CodeResult.ok(industryConsultancyService.selectAllCategory());
        } catch ( Exception e ) {
            LogUtils.logError("加载文章分类错误",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/indusPage")
    @ResponseBody
    public Map<String,Object> indusPage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(industryConsultancyService.findIndustryConsultancyPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取文章列表数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/deleteIndusSingleOrBatch")
    @ResponseBody
    public CodeResult deleteIndusSingleOrBatch(String ids){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            List idList = Arrays.asList(ids.split(","));
            industryConsultancyService.deleteIndusSingleOrBatch(idList,activeUser,session);
            return CodeResult.build(200,"批量操作成功");
        } catch ( Exception e ) {
            LogUtils.logError("删除文章出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/updateIndusStatus")
    @ResponseBody
    public CodeResult updateIndusStatus(int id,int status){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            industryConsultancyService.updateIndusStatus(id,status,activeUser,session);
            return CodeResult.build(200,status==0?"禁用成功":"启用成功");
        } catch ( Exception e ) {
            LogUtils.logError("删除文章出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/modifyIndus")
    @ResponseBody
    public CodeResult modifyIndus(IndustryConsultancy industryConsultancy){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            if (industryConsultancy.getStatus()==1) {
               industryConsultancy.setPublictime(new Date());
            }
            if (null!=industryConsultancy.getId()) {
                industryConsultancy.setLastmodifytime(new Date());
                industryConsultancyService.updateIndustryConsultancy(industryConsultancy,activeUser,session);
            } else {
                industryConsultancy.setDisplay(true);
                industryConsultancy.setCreatetime(new Date());
                industryConsultancyService.insert(industryConsultancy,activeUser,session);
            }
            return CodeResult.ok();
        } catch ( Exception e ) {
            LogUtils.logError("文章编辑出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

}
