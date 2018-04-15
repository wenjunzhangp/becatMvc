package com.baozi.service;

import com.baozi.po.SysLog;
import com.baozi.vo.SysLogVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

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

    /**
     * 分页查询系统日志列表
     * @param paramMap
     * @return
     */
    public PageInfo<SysLogVo> findSysLogPage(Map<String,Object> paramMap);
}
