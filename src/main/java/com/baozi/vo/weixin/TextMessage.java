package com.baozi.vo.weixin;

/**
 * Copyright:   互融云
 * 微信文本类型信息交互实体类
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-20 15:29
 */
public class TextMessage extends BaseMessage{

    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
