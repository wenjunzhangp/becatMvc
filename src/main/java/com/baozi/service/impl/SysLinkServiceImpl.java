package com.baozi.service.impl;

import com.baozi.mappers.SysLinkMapper;
import com.baozi.mappers.SysLogMapper;
import com.baozi.po.ActiveUser;
import com.baozi.po.SysLink;
import com.baozi.service.SysLinkService;
import com.baozi.util.GenerateLogFactory;
import com.baozi.vo.SysLinkVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysLinkServiceImpl implements SysLinkService{

    @Autowired
    private SysLinkMapper sysLinkMapper;

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public PageInfo<SysLinkVo> findSysLinkPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<SysLinkVo> dataList = sysLinkMapper.findSysLinkPage(paramMap);
        return new PageInfo<SysLinkVo>(dataList);
    }

    @Override
    public int deleteSysLinkSingleOrBatch(List idList, ActiveUser activeUser, Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"删除友情链接",(short) 0,activeUser.getUsername()+"删除友情链接",session.getHost()));
        return sysLinkMapper.deleteSysLinkSingleOrBatch(idList);
    }

    @Override
    public int updateSysLinkStatus(int id, int status,ActiveUser activeUser,Session session) {
        SysLink sysLink = new SysLink();
        sysLink.setId(id);
        sysLink.setStatus(status);
        String str = status==0?"禁用成功":"启用成功";
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"友情链接"+str,(short) 0,activeUser.getUsername()+str+"友情链接",session.getHost()));
        return sysLinkMapper.updateByPrimaryKeySelective(sysLink);
    }

    @Override
    public int updateSysLink(SysLink sysLink,ActiveUser activeUser,Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"修改友情链接",(short) 0,activeUser.getUsername()+"修改友情链接",session.getHost()));
        return sysLinkMapper.updateByPrimaryKeySelective(sysLink);
    }

    @Override
    public int insert(SysLink sysLink,ActiveUser activeUser,Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"新增友情链接",(short) 0,activeUser.getUsername()+"新增友情链接",session.getHost()));
        return sysLinkMapper.insertSelective(sysLink);
    }

    @Override
    public List<SysLinkVo> findSysLinkByLimitAndPosition(int position) {
        return sysLinkMapper.findSysLinkByLimitAndPosition(position);
    }
}

