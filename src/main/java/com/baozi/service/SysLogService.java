package com.baozi.service;

import com.baozi.po.SysLog;

/**
 * @author wenjun.zhang
 * @create 2018-03-13 16:10
 * @description 系统日志操作的service
 **/
public interface SysLogService {

    /**
     * 添加系统日志
     * @param record
     * @return
     */
    public int insert(SysLog record);
}
