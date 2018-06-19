package com.baozi.service.impl;

import com.baozi.mappers.PlatEventMapper;
import com.baozi.mappers.SysLogMapper;
import com.baozi.po.ActiveUser;
import com.baozi.po.PlatEvent;
import com.baozi.service.PlatEventService;
import com.baozi.util.GenerateLogFactory;
import com.baozi.vo.PlatEventViewVo;
import com.baozi.vo.PlatEventVo;
import com.baozi.vo.SysLinkVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.session.Session;
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

    @Autowired
    private SysLogMapper sysLogMapper;

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
    public int deletePlatEventSingleOrBatch(List idList, ActiveUser activeUser, Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"删除大事记",(short) 0,activeUser.getUsername()+"删除大事记",session.getHost()));
        return platEventMapper.deletePlatEventSingleOrBatch(idList);
    }

    @Override
    public int updatePlatEventStatus(int id, int status, ActiveUser activeUser, Session session) {
        PlatEvent platEvent = new PlatEvent();
        platEvent.setId(id);
        platEvent.setStatus(status);
        String str = status==0?"禁用成功":"启用成功";
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"大事记"+str,(short) 0,activeUser.getUsername()+str+"大事记",session.getHost()));
        return platEventMapper.updateByPrimaryKeySelective(platEvent);
    }

    @Override
    public int updatePlatEvent(PlatEvent platEvent, ActiveUser activeUser, Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"修改大事记",(short) 0,activeUser.getUsername()+"修改大事记",session.getHost()));
        return platEventMapper.updateByPrimaryKeySelective(platEvent);
    }

    @Override
    public int insert(PlatEvent platEvent, ActiveUser activeUser, Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"新增大事记",(short) 0,activeUser.getUsername()+"新增大事记",session.getHost()));
        return platEventMapper.insertSelective(platEvent);
    }

    @Override
    public PageInfo<PlatEventViewVo> footerPagination(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<PlatEventViewVo> dataList = platEventMapper.footerPagination();
        return new PageInfo<PlatEventViewVo>(dataList);
    }
}
