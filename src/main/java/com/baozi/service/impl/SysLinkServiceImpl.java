package com.baozi.service.impl;

import com.baozi.mappers.SysLinkMapper;
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
}

