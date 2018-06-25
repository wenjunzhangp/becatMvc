package com.baozi.vo.weixin;

import lombok.Data;

import java.util.List;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 18:18
 */
@Data
public class NewsMessage extends BaseMessage {

    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第1条为大图
    private List<Article> Articles;

}
