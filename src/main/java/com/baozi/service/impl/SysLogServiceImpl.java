package com.baozi.service.impl;

import com.baozi.mappers.SysLogMapper;
import com.baozi.po.SysLog;
import com.baozi.service.SysLogService;
import com.baozi.vo.SysLogVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-03-13 16:15
 * @description 系统日志逻辑类
 **/
@Service
public class SysLogServiceImpl implements SysLogService{

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int insert(SysLog record) {
        return sysLogMapper.insert(record);
    }

    @Override
    public PageInfo<SysLogVo> findSysLogPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<SysLogVo> dataList = sysLogMapper.findSysLogPage(paramMap);
        return new PageInfo<SysLogVo>(dataList);
    }


}
