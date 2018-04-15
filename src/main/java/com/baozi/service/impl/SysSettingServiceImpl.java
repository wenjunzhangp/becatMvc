package com.baozi.service.impl;

import com.baozi.mappers.SysSettingMapper;
import com.baozi.po.SysSetting;
import com.baozi.po.SysSettingExample;
import com.baozi.service.SysSettingService;
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

    @Override
    public SysSetting findSysSettingById() {
        SysSettingExample sysSettingExample = new SysSettingExample();
        return sysSettingMapper.selectByExample(sysSettingExample).get(0);
    }

    @Override
    public int updateSysSetting(SysSetting sysSetting) {
        return sysSettingMapper.updateByPrimaryKeySelective(sysSetting);
    }

}
