package com.baozi.service.impl;

import com.baozi.mappers.SysLogMapper;
import com.baozi.po.SysLog;
import com.baozi.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
