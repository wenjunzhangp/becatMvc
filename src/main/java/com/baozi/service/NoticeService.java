package com.baozi.service;

import com.baozi.po.Notice;
import com.baozi.po.PlatEvent;
import com.baozi.vo.NoticeVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-04-26 15:52
 * @description
 **/
public interface NoticeService {

    /**
     * 分页查询平台公告数据
     * @param paramMap
     * @return
     */
    public PageInfo<NoticeVo> findNoticePage (Map<String,Object> paramMap);

    /**
     * 批量删除平台公告
     * @param idList
     * @return
     */
    public int deleteNoticeSingleOrBatch(List idList);

    /**
     * 启动或者禁用平台公告
     * @param id
     * @param status
     * @return
     */
    public int updateNoticeStatus(int id,int status);

    /**
     * 修改平台公告
     * @param notice
     * @return
     */
    public int updateNotice(Notice notice);

    /**
     * 新增平台公告
     * @param notice
     * @return
     */
    public int insert(Notice notice);
}
