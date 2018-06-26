package com.baozi.controller;

import com.baozi.config.WeiXinConfig;
import com.baozi.util.LogUtils;
import com.baozi.util.MessageUtil;
import com.baozi.util.WeiXinMessageFactory;
import com.baozi.vo.weixin.TextMessage;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Copyright:   互融云
 * 微信相关controller
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-19 19:41
 */
@Controller
@RequestMapping("weixin")
public class WeixinSignatureController extends BaseController{

    /**
     * 微信验证方法
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @param response
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.GET)
    public void signature(
            @RequestParam(value = "signature", required = true) String signature,
            @RequestParam(value = "timestamp", required = true) String timestamp,
            @RequestParam(value = "nonce", required = true) String nonce,
            @RequestParam(value = "echostr", required = true) String echostr,
            HttpServletResponse response) throws IOException {
        String[] values = { WeiXinConfig.get("weixin_Token"), timestamp, nonce };
        // 字典序排序
        Arrays.sort(values);
        String value = values[0] + values[1] + values[2];
        String sign = DigestUtils.sha1Hex(value);
        PrintWriter writer = response.getWriter();
        // 验证成功返回ehcostr
        if (signature.equals(sign)) {
            writer.print(echostr);
        } else {
            writer.print("error");
        }
        writer.flush();
        writer.close();
    }

    /**
     * 处理微信发来的请求  文字 图片等
     * @param request
     * @return
     */
    @RequestMapping(method = { RequestMethod.POST })
    @ResponseBody
    public String handleWeiXinMessageRequest(HttpServletRequest request) {
        String respMessage = null;
        try {

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.xmlToMap(request);

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            // 消息内容
            String content = requestMap.get("Content");

            LogUtils.logInfo("FromUserName is:" + fromUserName + ", ToUserName is:" + toUserName + ", MsgType is:" + msgType);

            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respMessage = WeiXinMessageFactory.handleWeiXinTextMessage(fromUserName,toUserName,msgType,content);
            } else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respMessage = WeiXinMessageFactory.handleWeiXinVoiceMessage(requestMap);
            } else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_PHOTO)) {
                // TODO 拍照功能暂不实现，以后再说 2018-06-21 11:15
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                respMessage = WeiXinMessageFactory.handleWeiXinEventPush(fromUserName,toUserName,requestMap);
            } else {
                respMessage = "BeCat还有很多不完善的地方，请您多多理解~";
            }

        } catch (Exception e) {
            respMessage = "订阅号发生内部错误，请发邮件告知作者:zhangwenjunp@126.com";
            LogUtils.logError("回复消息异常",e);
        }
        return respMessage;
    }
}
