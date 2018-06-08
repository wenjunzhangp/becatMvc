package com.baozi.service.impl;

import com.baozi.mappers.NoticeMapper;
import com.baozi.po.Notice;
import com.baozi.service.NoticeService;
import com.baozi.vo.NoticeViewVo;
import com.baozi.vo.NoticeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-04-26 15:54
 * @description
 **/
@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public PageInfo<NoticeVo> findNoticePage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<NoticeVo> dataList = noticeMapper.findNoticePage(paramMap);
        return new PageInfo<NoticeVo>(dataList);
    }

    @Override
    public int deleteNoticeSingleOrBatch(List idList) {
        return noticeMapper.deleteNoticeSingleOrBatch(idList);
    }

    @Override
    public int updateNoticeStatus(int id, int status) {
        Notice notice = new Notice();
        notice.setId(id);
        notice.setStatus(status);
        notice.setLastmodifytime(new Date());
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public int insert(Notice notice) {
        return noticeMapper.insertSelective(notice);
    }

    @Override
    public PageInfo<NoticeViewVo> footerPagination(Map<String,Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<NoticeViewVo> dataList = noticeMapper.footerPagination();
        return new PageInfo<NoticeViewVo>(dataList);
    }
}
