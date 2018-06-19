package com.baozi.controller;

import com.baozi.enums.NoticeEnum;
import com.baozi.po.Blog;
import com.baozi.po.IndustryConsultancy;
import com.baozi.po.Notice;
import com.baozi.service.*;
import com.baozi.statics.Constant;
import com.baozi.util.IDEncryptor;
import com.baozi.util.LogUtils;
import com.baozi.vo.IndustryConsultancyViewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ViewJumpController extends BaseController{

    @Autowired
    private IndustryConsultancyService industryConsultancyService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private PlatEventService platEventService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @RequestMapping("/product")
    public String product(){
        return "product";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/joinus")
    public String joinus(){
        return "join";
    }

    @RequestMapping("/pet")
    public String pet(){
        return "pet";
    }

    @RequestMapping("/event")
    public ModelAndView event(){
        ModelAndView mav = new ModelAndView("event");
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("page",1);
        paramMap.put("limit",1);
        mav.addObject("total", platEventService.footerPagination(paramMap).getTotal());
        return mav;
    }

    @RequestMapping("/notice")
    public ModelAndView notice(){
        ModelAndView mav = new ModelAndView("notice");
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("page",1);
        paramMap.put("limit",1);
        mav.addObject("total", noticeService.footerPagination(paramMap).getTotal());
        return mav;
    }

    @RequestMapping("/noticedetail")
    public ModelAndView noticedetail(String id){
        ModelAndView mav = new ModelAndView("noticecontent");
        Integer noticeId = IDEncryptor.getInstance().decryptWithoutException(id);
        //取得当前公告
        Notice notice = noticeService.findNoticeById(noticeId);
        mav.addObject("noticeObject",notice);
        mav.addObject("noticeCategory", NoticeEnum.genNoticeCategory(notice.getCategory()).getName());
        return mav;
    }

    @RequestMapping("/news")
    public ModelAndView news(){
        ModelAndView mav = new ModelAndView("news");
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("page",1);
        paramMap.put("limit",1);
        mav.addObject("total", industryConsultancyService.footerPagination(paramMap).getTotal());
        return mav;
    }

    @RequestMapping("/newsdetail")
    public ModelAndView newsdetail(String id){
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);

        ModelAndView mav = new ModelAndView("newscontent");
        Integer indusId = IDEncryptor.getInstance().decryptWithoutException(id);
        try {
            //文章阅读数+1
            industryConsultancyService.updateIndustryConsultancyLookNum(indusId);
            transactionManager.commit(status);
        } catch ( Exception e ) {
            transactionManager.rollback(status);
            LogUtils.logError("文章【"+indusId+"】修改阅读数+1失败",e);
        }
        //取得当前文章
        IndustryConsultancy industryConsultancy = industryConsultancyService.findIndustryConsultancyById(indusId);
        mav.addObject("indusObject",industryConsultancy);
        return mav;
    }

    @RequestMapping("/blog")
    public ModelAndView blog(){
        ModelAndView mav = new ModelAndView("blog");
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("page",1);
        paramMap.put("limit",1);
        mav.addObject("total", blogService.footerPagination(paramMap).getTotal());
        return mav;
    }

    @RequestMapping("/blogdetail")
    public ModelAndView blogdetail(String id){
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);

        ModelAndView mav = new ModelAndView("blogcontent");
        Integer indusId = IDEncryptor.getInstance().decryptWithoutException(id);
        try {
            //文章阅读数+1
            blogService.updateBlogLookNum(indusId);
            transactionManager.commit(status);
        } catch ( Exception e ) {
            transactionManager.rollback(status);
            LogUtils.logError("技术博客【"+indusId+"】修改阅读数+1失败",e);
        }
        //取得当前技术博客
        Blog blog = blogService.findBlogById(indusId);
        mav.addObject("blogObject",blog);
        return mav;
    }

}
