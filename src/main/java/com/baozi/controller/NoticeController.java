package com.baozi.controller;

import com.baozi.po.ActiveUser;
import com.baozi.po.IndustryConsultancy;
import com.baozi.po.Notice;
import com.baozi.service.IndustryConsultancyService;
import com.baozi.service.NoticeService;
import com.baozi.util.IConfig;
import com.baozi.util.LogUtils;
import com.baozi.util.StringUtil;
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
 * @description 文章相关控制器
 **/
@RequestMapping("/console")
@Controller
public class NoticeController extends BaseController{

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/notice")
    public String noticeUI(){
        return "/notice/noticeData";
    }

    @RequestMapping("/addOrUpdateNotice")
    public String addOrUpdateNotice(){
        return "/notice/noticeMofidy";
    }

    @RequestMapping("/noticePage")
    @ResponseBody
    public Map<String,Object> noticePage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(noticeService.findNoticePage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取平台公告列表数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/deleteNoticeSingleOrBatch")
    @ResponseBody
    public CodeResult deleteNoticeSingleOrBatch(String ids){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            List idList = Arrays.asList(ids.split(","));
            noticeService.deleteNoticeSingleOrBatch(idList,activeUser,session);
            return CodeResult.build(200,"批量操作成功");
        } catch ( Exception e ) {
            LogUtils.logError("删除公告出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/updateNoticeStatus")
    @ResponseBody
    public CodeResult updateNoticeStatus(int id,int status){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            noticeService.updateNoticeStatus(id,status,activeUser,session);
            return CodeResult.build(200,status==0?"禁用成功":"启用成功");
        } catch ( Exception e ) {
            LogUtils.logError(status==0?"禁用成功":"启用成功"+"文章出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/modifyNotice")
    @ResponseBody
    public CodeResult modifyNotice(Notice notice){
        try {
            ActiveUser activeUser = super.loginUser();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            if (notice.getStatus()==1) {
                notice.setPublictime(new Date());
            }
            if (null!=notice.getId()) {
                notice.setLastmodifytime(new Date());
                noticeService.updateNotice(notice,activeUser,session);
            } else {
                notice.setDisplay(1);
                notice.setCreatetime(new Date());
                notice.setLastmodifytime(new Date());
                noticeService.insert(notice,activeUser,session);
            }
            return CodeResult.ok();
        } catch ( Exception e ) {
            LogUtils.logError("公告编辑出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

}
