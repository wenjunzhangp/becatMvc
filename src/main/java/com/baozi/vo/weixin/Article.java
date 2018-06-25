package com.baozi.vo.weixin;

import lombok.Data;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 18:19
 */
@Data
public class Article {

    // 图文消息名称
    private String Title;
    // 图文消息描述
    private String Description;
    // 图片链接，支持JPG、PNG格式，较好的效果为大�?40*320，小�?0*80，限制图片链接的域名�?��与开发�?填写的基本资料中的Url�?��
    private String PicUrl;
    // 点击图文消息跳转链接
    private String Url;

}
