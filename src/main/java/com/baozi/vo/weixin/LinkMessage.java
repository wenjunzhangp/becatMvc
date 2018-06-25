package com.baozi.vo.weixin;

import lombok.Data;

/**
 * Copyright:   互融云
 * 微信链接类型信息交互实体类
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 17:35
 */
@Data
public class LinkMessage extends BaseMessage{

    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;

}
