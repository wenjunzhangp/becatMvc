package com.baozi.service;

import com.baozi.po.PlatEvent;
import com.baozi.vo.PlatEventViewVo;
import com.baozi.vo.PlatEventVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 17:25
 * @description 大事记相关service
 **/
public interface PlatEventService {

    /**
     * 获取所有平台大事记
     * @return
     */
    List<PlatEvent> findAllPlatEvent();

    /**
     * 分页查询大事记数据
     * @param paramMap
     * @return
     */
    PageInfo<PlatEventVo> findPlatEventPage (Map<String,Object> paramMap);

    /**
     * 批量删除大事记
     * @param idList
     * @return
     */
    int deletePlatEventSingleOrBatch(List idList);

    /**
     * 启动或者禁用大事记
     * @param id
     * @param status
     * @return
     */
    int updatePlatEventStatus(int id,int status);

    /**
     * 修改大事记
     * @param platEvent
     * @return
     */
    int updatePlatEvent(PlatEvent platEvent);

    /**
     * 新增大事记
     * @param platEvent
     * @return
     */
    int insert(PlatEvent platEvent);

    /**
     * 前端页脚分页列表
     * @return
     */
    PageInfo<PlatEventViewVo> footerPagination(Map<String,Object> paramMap);
}
