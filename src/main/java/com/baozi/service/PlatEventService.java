package com.baozi.service;

import com.baozi.po.PlatEvent;

import java.util.List;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 17:25
 * @description 大事记相关service
 **/
public interface PlatEventService {

    /**
     * 获取所有平台大事记
     * @return
     */
    public List<PlatEvent> findAllPlatEvent();
}
