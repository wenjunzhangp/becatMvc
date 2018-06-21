package com.baozi.vo.weixin;

/**
 * Copyright:   互融云
 * 微信图片类型信息交互实体类
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 17:30
 */
public class ImageMessage extends BaseMessage {

    // 图片链接
    private String PicUrl;
    //媒体ID
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
