package com.baozi.service.impl;

import com.baozi.mappers.SysLinkMapper;
import com.baozi.po.SysLink;
import com.baozi.service.SysLinkService;
import com.baozi.vo.SysLinkVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysLinkServiceImpl implements SysLinkService{

    @Autowired
    private SysLinkMapper sysLinkMapper;

    @Override
    public PageInfo<SysLinkVo> findSysLinkPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<SysLinkVo> dataList = sysLinkMapper.findSysLinkPage(paramMap);
        return new PageInfo<SysLinkVo>(dataList);
    }

    @Override
    public int deleteSysLinkSingleOrBatch(List idList) {
        return sysLinkMapper.deleteSysLinkSingleOrBatch(idList);
    }

    @Override
    public int updateSysLinkStatus(int id, int status) {
        SysLink sysLink = new SysLink();
        sysLink.setId(id);
        sysLink.setStatus(status);
        return sysLinkMapper.updateByPrimaryKeySelective(sysLink);
    }

    @Override
    public int updateSysLink(SysLink sysLink) {
        return sysLinkMapper.updateByPrimaryKeySelective(sysLink);
    }

    @Override
    public int insert(SysLink sysLink) {
        return sysLinkMapper.insertSelective(sysLink);
    }

    @Override
    public List<SysLinkVo> findSysLinkByLimitAndPosition(int position) {
        return sysLinkMapper.findSysLinkByLimitAndPosition(position);
    }
}

