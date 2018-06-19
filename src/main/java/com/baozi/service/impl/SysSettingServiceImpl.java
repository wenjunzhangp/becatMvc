package com.baozi.service.impl;

import com.baozi.mappers.SysLogMapper;
import com.baozi.mappers.SysSettingMapper;
import com.baozi.po.ActiveUser;
import com.baozi.po.SysSetting;
import com.baozi.po.SysSettingExample;
import com.baozi.service.SysSettingService;
import com.baozi.util.GenerateLogFactory;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 16:08
 * @description 系统基本配置逻辑操作类
 **/
@Service
public class SysSettingServiceImpl implements SysSettingService{

    @Autowired
    private SysSettingMapper sysSettingMapper;

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public SysSetting findSysSettingById() {
        SysSettingExample sysSettingExample = new SysSettingExample();
        return sysSettingMapper.selectByExample(sysSettingExample).get(0);
    }

    @Override
    public int updateSysSetting(SysSetting sysSetting, ActiveUser activeUser, Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"编辑系统基本设置",(short) 0,activeUser.getUsername()+"编辑系统基本设置",session.getHost()));
        return sysSettingMapper.updateByPrimaryKeySelective(sysSetting);
    }

}
