package com.baozi.service.impl;

import com.baozi.mappers.PlatEventMapper;
import com.baozi.po.PlatEvent;
import com.baozi.service.PlatEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 17:26
 * @description 大事记相关操作逻辑类
 **/
@Service
public class PlatEventServiceImpl implements PlatEventService {

    @Autowired
    private PlatEventMapper platEventMapper;

    @Override
    public List<PlatEvent> findAllPlatEvent() {
        return platEventMapper.findAllPlatEvent();
    }
}
