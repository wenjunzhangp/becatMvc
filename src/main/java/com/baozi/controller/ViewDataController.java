package com.baozi.controller;

import com.baozi.service.IndustryConsultancyService;
import com.baozi.service.NoticeService;
import com.baozi.service.PlatEventService;
import com.baozi.service.SysLinkService;
import com.baozi.statics.Constant;
import com.baozi.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/view/page")
@Controller
public class ViewDataController extends BaseController{

    @Autowired
    private IndustryConsultancyService industryConsultancyService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private PlatEventService platEventService;

    @Autowired
    private SysLinkService sysLinkService;

    @RequestMapping("/newslimit")
    @ResponseBody
    public CodeResult newslimit(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            return CodeResult.ok(industryConsultancyService.findIndustryConsultancyTopLimit(Constant.SHOW_SIZE_NINE));
        } catch ( Exception e ) {
            LogUtils.logError("读取新闻文章前端分页异常",e);
            return CodeResult.build(500,"读取新闻文章前端分页异常");
        }
    }

    @RequestMapping("/newsdata")
    @ResponseBody
    public Map<String,Object> newsdata(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(industryConsultancyService.footerPagination(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取新闻文章前端分页异常",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/noticedata")
    @ResponseBody
    public Map<String,Object> noticedata(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(noticeService.footerPagination(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取平台公告前端分页异常",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/eventdata")
    @ResponseBody
    public Map<String,Object> eventdata(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(platEventService.footerPagination(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取平台大事记前端分页异常",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/blogdata")
    @ResponseBody
    public Map<String,Object> blogdata(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(null);
        } catch ( Exception e ) {
            LogUtils.logError("读取技术博客前端分页异常",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/noticelimit")
    @ResponseBody
    public CodeResult noticelimit(HttpServletRequest request){
        return CodeResult.ok(noticeService.findNoticeTopLimit(Constant.SHOW_SIZE_FIVE));
    }

    @RequestMapping("/linklimit")
    @ResponseBody
    public CodeResult linklimit(HttpServletRequest request){
        return CodeResult.ok(sysLinkService.findSysLinkByLimitAndPosition(Constant.LINK_POSITION_CHILDREN));
    }
}
