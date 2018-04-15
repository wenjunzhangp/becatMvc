package com.baozi.service.impl;

import com.baozi.mappers.UserLogMapper;
import com.baozi.po.UserLog;
import com.baozi.service.UserLogService;
import com.baozi.vo.SysLogVo;
import com.baozi.vo.UserLogVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public PageInfo<UserLogVo> findUserLogPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<UserLogVo> dataList = userLogMapper.findUserLogPage(paramMap);
        return new PageInfo<UserLogVo>(dataList);
    }
}
