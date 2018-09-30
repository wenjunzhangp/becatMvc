package com.baozi.service.impl;

import com.baozi.mappers.WechatUserinfoMapper;
import com.baozi.po.WechatUserinfo;
import com.baozi.service.WechatUserinfoService;
import com.baozi.vo.WechatUserinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-09-30 14:32
 */
@Service
public class WechatUserinfoServiceImpl implements WechatUserinfoService {

    @Autowired
    private WechatUserinfoMapper wechatUserinfoMapper;

    @Override
    public WechatUserinfoVo findWechatUserinfoByOpenId(String openid) {
        return wechatUserinfoMapper.findWechatUserinfoByOpenId(openid);
    }

    @Override
    public void insertWechatUserinfo(String openid, String nickname, String gender, String url) {
        WechatUserinfo wechatUserinfo = new WechatUserinfo();
        //补全bean属性，入库
        wechatUserinfo.setNickname(nickname);
        wechatUserinfo.setOpenid(openid);
        wechatUserinfo.setUrl(url);
        wechatUserinfo.setGender(Integer.valueOf(gender));
        wechatUserinfo.setIntelligencenum(0);
        wechatUserinfo.setParagraphid(1);
        wechatUserinfo.setCreatetime(new Date());
        wechatUserinfo.setModifytime(new Date());
        wechatUserinfoMapper.insertSelective(wechatUserinfo);
    }
}
