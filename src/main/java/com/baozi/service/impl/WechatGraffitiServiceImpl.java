package com.baozi.service.impl;

import com.baozi.mappers.WechatGraffitiMapper;
import com.baozi.po.WechatGraffiti;
import com.baozi.service.WechatGraffitiService;
import com.baozi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-09-18 10:10
 */
@Service
public class WechatGraffitiServiceImpl implements WechatGraffitiService {

    @Autowired
    private WechatGraffitiMapper wechatGraffitiMapper;


    @Override
    public void newWeChatImage(String nickname, String gender, String websitePath, String fileName) {
        WechatGraffiti wechatGraffiti = new WechatGraffiti();
        wechatGraffiti.setAuthor(nickname);
        wechatGraffiti.setGender(Integer.parseInt(gender));
        wechatGraffiti.setLikenum(0);
        wechatGraffiti.setMonth(DateUtil.formatDate(new Date(), "MM"));
        wechatGraffiti.setUrl(websitePath);
        wechatGraffiti.setFilename(fileName);
        wechatGraffiti.setCreatetime(new Date());
        wechatGraffiti.setModifytime(new Date());
        wechatGraffitiMapper.insertSelective(wechatGraffiti);
    }

    @Override
    public List<WechatGraffiti> findWechatGraffitiByAuthor(String author) {
        return wechatGraffitiMapper.findWechatGraffitiByAuthor(author);
    }

    @Override
    public void updateWechatGraffitiByIdAndAuthor(boolean operate, Integer id, String author) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("author", author);
        //operate为true，调用点赞方法，false为踩 likenum数量-1
        if (operate) {
            wechatGraffitiMapper.updateWechatGraffitiLike(map);
        } else {
            wechatGraffitiMapper.updateWechatGraffitiNotLike(map);
        }
    }
}
