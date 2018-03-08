package com.baozi.service.impl;

import com.baozi.mappers.SysUserMapper;
import com.baozi.po.SysUser;
import com.baozi.po.SysUserExample;
import com.baozi.service.SysUserService;
import com.baozi.util.MD5Factory;
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

    @Override
    public SysUser findSysUserByUserId(int userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUserInfo(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int updateUserPwd(int userId, String newpwd) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        String newPassWord = MD5Factory.genPassWordWithUserSalt(newpwd,sysUser.getSalt(),1);
        sysUser.setPassword(newPassWord);
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

}
