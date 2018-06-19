package com.baozi.service;

import com.baozi.po.ActiveUser;
import com.baozi.po.Notice;
import com.baozi.po.PlatEvent;
import com.baozi.vo.NoticeViewVo;
import com.baozi.vo.NoticeVo;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.session.Session;

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
     PageInfo<NoticeVo> findNoticePage (Map<String,Object> paramMap);

    /**
     * 批量删除平台公告
     * @param idList
     * @return
     */
     int deleteNoticeSingleOrBatch(List idList,ActiveUser activeUser,Session session);

    /**
     * 启动或者禁用平台公告
     * @param id
     * @param status
     * @return
     */
     int updateNoticeStatus(int id,int status,ActiveUser activeUser,Session session);

    /**
     * 修改平台公告
     * @param notice
     * @return
     */
     int updateNotice(Notice notice,ActiveUser activeUser,Session session);

    /**
     * 新增平台公告
     * @param notice
     * @return
     */
     int insert(Notice notice, ActiveUser activeUser, Session session);

    /**
     * 前台页脚分页列表
     * @return
     */
    PageInfo<NoticeViewVo> footerPagination(Map<String,Object> paramMap);

    /**
     * 查询站内最新的五篇公告
     */
    List<NoticeViewVo> findNoticeTopLimit(int limit);

    /**
     * 获取单篇公告，做详情页用
     * @param id
     * @return
     */
    Notice findNoticeById(int id);
}
