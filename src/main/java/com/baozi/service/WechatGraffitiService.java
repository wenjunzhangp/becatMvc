package com.baozi.service;

import com.baozi.po.WechatGraffiti;

import java.util.List;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-09-18 10:10
 */
public interface WechatGraffitiService {

    /**
     * 用户保存一个作品
     * @param nickname
     * @param gender
     * @param websitePath
     * @param fileName
     */
    void newWeChatImage(String nickname,String gender, String websitePath, String fileName);

    /**
     * 根据作者查询个人的作品 目前暂不分页
     * @param author
     * @return
     */
    List<WechatGraffiti> findWechatGraffitiByAuthor(String author);

    /**
     * 查询全部优秀作品列表
     * @return
     */
    List<WechatGraffiti> findWechatGraffitiList();

    /**
     * 根据小程序传过来的画作id和作者修改喜欢数 +1
     * @param id
     * @param author
     */
    void updateWechatGraffitiByIdAndAuthor(Integer id,String author);
}
