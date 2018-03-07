package com.baozi.service.impl;

import com.baozi.mappers.SysUserMapper;
import com.baozi.po.SysUserExample;
import com.baozi.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 15:07
 * @description 用户相关的逻辑类处理
 **/
@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public int findAllUserCount() {
        SysUserExample sysUserExample=new SysUserExample();
        return sysUserMapper.countByExample(sysUserExample);
    }

    @Override
    public Date findUserLastLoginTime(int userId) {
        return sysUserMapper.findUserLastLoginTime(userId);
    }

}
