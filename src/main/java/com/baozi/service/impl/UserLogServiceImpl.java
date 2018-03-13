package com.baozi.service.impl;

import com.baozi.mappers.UserLogMapper;
import com.baozi.po.UserLog;
import com.baozi.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenjun.zhang
 * @create 2018-03-13 16:13
 * @description 用户日志逻辑类
 **/
@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public int insert(UserLog record) {
        return userLogMapper.insert(record);
    }
}
