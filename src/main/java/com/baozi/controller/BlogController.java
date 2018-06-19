package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.po.Blog;
import com.baozi.po.IndustryConsultancy;
import com.baozi.service.BlogService;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 16:39
 * @description 技术博客相关控制器
 **/
@RequestMapping("/console")
@Controller
public class BlogController extends BaseController{

    @Autowired
    private BlogService blogService;

    @RequestMapping("/blog")
    public String blogUI(){
        return "/blog/blogData";
    }

    @RequestMapping("/addOrUpdateBlog")
    public String addOrUpdateBlog(){
        return "/blog/blogMofidy";
    }

    @RequestMapping("/blogPage")
    @ResponseBody
    public Map<String,Object> blogPage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(blogService.findBlogPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取博客列表数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/deleteBlogSingleOrBatch")
    @ResponseBody
    public CodeResult deleteBlogSingleOrBatch(String ids){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            List idList = Arrays.asList(ids.split(","));
            blogService.deleteBlogSingleOrBatch(idList,activeUser,session);
            return CodeResult.build(200,"批量操作成功");
        } catch ( Exception e ) {
            LogUtils.logError("删除博客出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/updateBlogStatus")
    @ResponseBody
    public CodeResult updateBlogStatus(int id,int status){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            blogService.updateBlogStatus(id,status,activeUser,session);
            return CodeResult.build(200,status==0?"禁用成功":"启用成功");
        } catch ( Exception e ) {
            LogUtils.logError("出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/updateBlogStick")
    @ResponseBody
    public CodeResult updateBlogStick(int id,int status){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            blogService.updateBlogStick(id,status,activeUser,session);
            return CodeResult.build(200,status==0?"下顶成功":"置顶成功");
        } catch ( Exception e ) {
            LogUtils.logError("出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/modifyBlog")
    @ResponseBody
    public CodeResult modifyBlog(Blog blog){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            if (null!=blog.getId()) {
                blog.setLastmodifytime(new Date());
                blogService.updateBlog(blog,activeUser,session);
            } else {
                blog.setDisplay(1);
                blog.setCreatetime(new Date());
                blogService.insert(blog,activeUser,session);
            }
            return CodeResult.ok();
        } catch ( Exception e ) {
            LogUtils.logError("博客编辑出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

}
