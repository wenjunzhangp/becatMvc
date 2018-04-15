package com.baozi.controller;

import com.baozi.service.SysLogService;
import com.baozi.service.UserLogService;
import com.baozi.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 日志控制器
 */
@RequestMapping("/console")
@Controller
public class LogController extends BaseController {

    @Autowired
    private UserLogService userLogService;

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/userlog")
    public String userlogUI(){
        return "/log/userLog";
    }

    @RequestMapping("/syslog")
    public String syslogUI(){
        return "/log/sysLog";
    }

    @RequestMapping("/userLogPage")
    @ResponseBody
    public Map<String,Object> userLogPage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(userLogService.findUserLogPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取用户访问日志失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }

    @RequestMapping("/sysLogPage")
    @ResponseBody
    public Map<String,Object> sysLogPage(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(sysLogService.findSysLogPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取系统操作日志失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }
}
