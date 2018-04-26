package com.baozi.service.impl;

import com.baozi.mappers.PlatEventMapper;
import com.baozi.po.PlatEvent;
import com.baozi.service.PlatEventService;
import com.baozi.vo.PlatEventVo;
import com.baozi.vo.SysLinkVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public PageInfo<PlatEventVo> findPlatEventPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<PlatEventVo> dataList = platEventMapper.findPlatEventPage(paramMap);
        return new PageInfo<PlatEventVo>(dataList);
    }

    @Override
    public int deletePlatEventSingleOrBatch(List idList) {
        return platEventMapper.deletePlatEventSingleOrBatch(idList);
    }

    @Override
    public int updatePlatEventStatus(int id, int status) {
        PlatEvent platEvent = new PlatEvent();
        platEvent.setId(id);
        platEvent.setStatus(status);
        return platEventMapper.updateByPrimaryKeySelective(platEvent);
    }

    @Override
    public int updatePlatEvent(PlatEvent platEvent) {
        return platEventMapper.updateByPrimaryKeySelective(platEvent);
    }

    @Override
    public int insert(PlatEvent platEvent) {
        return platEventMapper.insertSelective(platEvent);
    }
}
