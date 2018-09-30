package com.baozi.service;

import com.baozi.po.WechatIdiom;

import java.util.List;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-09-30 10:56
 */
public interface WechatIdiomService {

    /**
     * 查询全部成语题
     * @return
     */
    List<WechatIdiom> findWechatIdiomServiceALL();

    /**
     * 按照固定格式初始化answer字段
     * @param wechatIdiom
     */
    void updateAnswer(List<WechatIdiom> wechatIdiom);
}
