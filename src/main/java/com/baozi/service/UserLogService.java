package com.baozi.service;

import com.baozi.po.UserLog;

/**
 * @author wenjun.zhang
 * @create 2018-03-13 16:10
 * @description 用户日志操作的service
 **/
public interface UserLogService {

    /**
     * 添加用户日志
     * @param record
     * @return
     */
    public int insert(UserLog record);
}
