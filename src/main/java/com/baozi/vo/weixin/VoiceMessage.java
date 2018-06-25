package com.baozi.vo.weixin;

import lombok.Data;

/**
 * Copyright:   互融云
 * 微信语音类型信息交互实体类
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 17:31
 */
@Data
public class VoiceMessage extends BaseMessage {

    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

}
