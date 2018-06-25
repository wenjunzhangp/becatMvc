package com.baozi.vo.weixin;

import lombok.Data;

/**
 * Copyright:   互融云
 * 微信图片类型信息交互实体类
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 17:30
 */
@Data
public class ImageMessage extends BaseMessage {

    // 图片链接
    private String PicUrl;
    //媒体ID
    private String MediaId;

}
