package com.baozi.controller;

import com.baozi.po.SysLink;
import com.baozi.service.SysLinkService;
import com.baozi.util.IConfig;
import com.baozi.util.LogUtils;
import com.baozi.util.StringUtil;
import com.baozi.vo.SysLinkVo;
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
 * @create 2018-04-23 18:55
 * @description
 **/
@RequestMapping("/console")
@Controller
public class LinkDataController extends BaseController{

    @Autowired
    private SysLinkService sysLinkService;

    @RequestMapping("/friend")
    public String friendUI(){
        return "/systemSetting/linkData";
    }

    @RequestMapping("/addOrUpdateLink")
    public String addOrUpdatePlatEvent(){
        return "/systemSetting/linkModify";
    }

    @RequestMapping("/sysLinkPage")
    @ResponseBody
    public Map<String,Object> sysLinkPage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(sysLinkService.findSysLinkPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取友情链接数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/deleteSysLinkSingleOrBatch")
    @ResponseBody
    public CodeResult deleteIndusSingleOrBatch(String ids){
        try {
            List idList = Arrays.asList(ids.split(","));
            sysLinkService.deleteSysLinkSingleOrBatch(idList);
            return CodeResult.build(200,"批量操作成功");
        } catch ( Exception e ) {
            LogUtils.logError("删除文章出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/updateSysLinkStatus")
    @ResponseBody
    public CodeResult updateSysLinkStatus(int id,int status){
        try {
            sysLinkService.updateSysLinkStatus(id,status);
            return CodeResult.build(200,status==0?"禁用成功":"启用成功");
        } catch ( Exception e ) {
            LogUtils.logError(status==0?"禁用成功":"启用成功"+"文章出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

    @RequestMapping("/modifySysLink")
    @ResponseBody
    public CodeResult modifySysLink(SysLink sysLink){
        try {
            if (null!=sysLink.getId()) {
                sysLinkService.updateSysLink(sysLink);
            } else {
                sysLink.setDisplay(1);
                sysLink.setCreatetime(new Date());
                sysLinkService.insert(sysLink);
            }
            return CodeResult.ok();
        } catch ( Exception e ) {
            LogUtils.logError("友链编辑出现异常",e);
            return CodeResult.build(500,e.getMessage());
        }
    }

}
