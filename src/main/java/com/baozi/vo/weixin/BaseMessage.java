package com.baozi.vo.weixin;

import lombok.Data;

/**
 * Copyright:   互融云
 * 封装微信交互消息基类
 * 文本消息，图片消息，语音消息，视频消息，小视频消息，地理位置消息，链接消息。
 *  ToUserName（开发者微信号）；
    FromUserName（发送方帐 号，OPEN_ID）；
    CreateTime（消息的创建时间）；
    MsgType（消息类型）；
    MsgId（消息ID）。
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 17:26
 */
@Data
public class BaseMessage {

    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String MsgId;

}
