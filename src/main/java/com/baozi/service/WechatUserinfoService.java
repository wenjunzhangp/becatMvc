package com.baozi.service;

import com.baozi.po.WechatUserinfo;
import com.baozi.vo.WechatUserinfoVo;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-09-30 14:31
 */
public interface WechatUserinfoService {

    /**
     * 根据openid查询用户信息
     * @param openid
     * @return
     */
    WechatUserinfoVo findWechatUserinfoByOpenId(String openid);

    /**
     * 小程序用户同意授权，代表注册，入库记录
     * @param openid
     * @param nickname
     * @param gender
     * @param url
     */
    void insertWechatUserinfo(String openid,String nickname,String gender,String url);
}
