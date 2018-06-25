package com.baozi.vo.weixin;

import lombok.Data;

/**
 * Copyright:   互融云
 * 微信视频多媒体类型信息交互实体类
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 17:33
 */
@Data
public class VideoMessage extends BaseMessage {

    // 媒体ID
    private String MediaId;
    // 视频格式
    private String ThumbMediaId;

}