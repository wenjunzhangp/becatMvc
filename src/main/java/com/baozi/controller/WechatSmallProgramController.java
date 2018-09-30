package com.baozi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baozi.config.WeiXinConfig;
import com.baozi.po.WechatIdiom;
import com.baozi.service.WechatIdiomService;
import com.baozi.service.WechatUserinfoService;
import com.baozi.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-09-30 11:03
 */
@RequestMapping("/wexin")
@Controller
public class WechatSmallProgramController extends BaseController {

    @Autowired
    private WechatIdiomService wechatIdiomService;

    @Autowired
    private WechatUserinfoService wechatUserinfoService;

    /**
     * 初始化成语试题答案
     * @param request
     * @return
     */
    @RequestMapping("/initAnswerData")
    @ResponseBody
    public CodeResult initAnswerData(HttpServletRequest request) {
        try {
            List<WechatIdiom> wechatIdiomList = wechatIdiomService.findWechatIdiomServiceALL();
            wechatIdiomService.updateAnswer(wechatIdiomList);
            return CodeResult.build(200, "初始化成功");
        } catch (Exception e) {
            LogUtils.logError("初始化成语表answer字段失败", e);
            return CodeResult.build(500, e.getMessage());
        }
    }

    /**
     * 获取凭证校检接口 微信小程序登录接口
     * @param request
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request) {
        //微信的接口
        String code = request.getParameter("code");
        String url = WeiXinConfig.get("weixin_login_url")+"appid="+WeiXinConfig.get("weixin_samll_program_appid")+"&secret="+WeiXinConfig.get("weixin_samll_program_secret")+"&js_code=" + code + "&grant_type="+WeiXinConfig.get("weixin_samll_program_granttype");
        RestTemplate restTemplate = new RestTemplate();
        //进行网络请求,访问url接口
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        //根据返回值进行后续操作
        if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
            String sessionData = responseEntity.getBody();
            JSONObject jsonObject = JSONObject.parseObject(sessionData);
            return jsonObject.getString("openid");
        }
        return "unkown openid";
    }

    /**
     * 加载微信小程序用户信息根据openid查询
     * @param request
     * @return
     */
    @RequestMapping("/loadUserInfo")
    @ResponseBody
    public CodeResult loadUserInfo(HttpServletRequest request) {
        try {
            String openid = request.getParameter("openid");
            return CodeResult.build(200, "加载成功",wechatUserinfoService.findWechatUserinfoByOpenId(openid));
        } catch (Exception e) {
            LogUtils.logError("初始化成语表answer字段失败", e);
            return CodeResult.build(500, "无效的openid",null);
        }
    }

    @RequestMapping("/authorizedRegister")
    @ResponseBody
    public CodeResult authorizedRegister(HttpServletRequest request) {
        try {
            String openid = request.getParameter("openid");
            String nickname = request.getParameter("nickname");
            String gender = request.getParameter("gender");
            String url = request.getParameter("url");
            wechatUserinfoService.insertWechatUserinfo(openid,nickname,gender,url);
            return CodeResult.build(200, "授权注册成功");
        } catch (Exception e) {
            LogUtils.logError("初始化成语表answer字段失败", e);
            return CodeResult.build(500, "授权注册失败/服务器异常",null);
        }
    }


}
