package com.baozi.service.impl;

import com.baozi.mappers.NoticeMapper;
import com.baozi.mappers.SysLogMapper;
import com.baozi.po.ActiveUser;
import com.baozi.po.Notice;
import com.baozi.service.NoticeService;
import com.baozi.util.GenerateLogFactory;
import com.baozi.vo.NoticeViewVo;
import com.baozi.vo.NoticeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.session.Session;
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

    @Autowired
    private SysLogMapper sysLogMapper;


    @Override
    public PageInfo<NoticeVo> findNoticePage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<NoticeVo> dataList = noticeMapper.findNoticePage(paramMap);
        return new PageInfo<NoticeVo>(dataList);
    }

    @Override
    public int deleteNoticeSingleOrBatch(List idList, ActiveUser activeUser, Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"删除平台公告",(short) 0,activeUser.getUsername()+"删除平台公告",session.getHost()));
        return noticeMapper.deleteNoticeSingleOrBatch(idList);
    }

    @Override
    public int updateNoticeStatus(int id, int status,ActiveUser activeUser,Session session) {
        Notice notice = new Notice();
        notice.setId(id);
        notice.setStatus(status);
        notice.setLastmodifytime(new Date());
        String str = status==0?"禁用成功":"启用成功";
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"平台公告"+str,(short) 0,activeUser.getUsername()+str+"平台公告",session.getHost()));
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public int updateNotice(Notice notice,ActiveUser activeUser,Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"修改平台公告",(short) 0,activeUser.getUsername()+"修改平台公告",session.getHost()));
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public int insert(Notice notice,ActiveUser activeUser,Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"新增平台公告",(short) 0,activeUser.getUsername()+"新增平台公告",session.getHost()));
        return noticeMapper.insertSelective(notice);
    }

    @Override
    public PageInfo<NoticeViewVo> footerPagination(Map<String,Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<NoticeViewVo> dataList = noticeMapper.footerPagination();
        return new PageInfo<NoticeViewVo>(dataList);
    }

    @Override
    public List<NoticeViewVo> findNoticeTopLimit(int limit) {
        return noticeMapper.findNoticeTopLimit(limit);
    }

    @Override
    public Notice findNoticeById(int id) {
        return noticeMapper.selectByPrimaryKey(id);
    }
}
