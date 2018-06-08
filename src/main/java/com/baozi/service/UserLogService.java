package com.baozi.service;

import com.baozi.po.UserLog;
import com.baozi.vo.UserLogVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

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
    int insert(UserLog record);

    /**
     * 分页查询用户日志列表
     * @param paramMap
     * @return
     */
    PageInfo<UserLogVo> findUserLogPage(Map<String,Object> paramMap);
}
