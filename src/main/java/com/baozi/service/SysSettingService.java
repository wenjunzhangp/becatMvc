package com.baozi.service;

import com.baozi.po.SysSetting;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 16:07
 * @description 系统基本配置相关service
 **/
public interface SysSettingService {

    /**
     * 根据主键获取系统基本配置信息
     * @return
     */
    public SysSetting findSysSettingById();
}
