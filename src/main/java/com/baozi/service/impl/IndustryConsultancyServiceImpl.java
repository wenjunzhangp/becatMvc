package com.baozi.service.impl;

import com.baozi.mappers.IndustryConsultancyCategoryMapper;
import com.baozi.mappers.IndustryConsultancyMapper;
import com.baozi.mappers.SysLogMapper;
import com.baozi.po.ActiveUser;
import com.baozi.po.IndustryConsultancy;
import com.baozi.service.IndustryConsultancyService;
import com.baozi.util.GenerateLogFactory;
import com.baozi.vo.IndustryConsultancyViewVo;
import com.baozi.vo.IndustryConsultancyVo;
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
 * @create 2018-03-07 16:34
 * @description 文章逻辑操作类
 **/
@Service
public class IndustryConsultancyServiceImpl implements IndustryConsultancyService{

    @Autowired
    private IndustryConsultancyMapper industryConsultancyMapper;

    @Autowired
    private IndustryConsultancyCategoryMapper industryConsultancyCategoryMapper;

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public List<IndustryConsultancyViewVo> findIndustryConsultancyTopLimit(int limit) {
        return industryConsultancyMapper.findIndustryConsultancyTopLimit(limit);
    }

    @Override
    public PageInfo<IndustryConsultancyVo> findIndustryConsultancyPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<IndustryConsultancyVo> dataList = industryConsultancyMapper.findIndustryConsultancyPage(paramMap);
        return new PageInfo<IndustryConsultancyVo>(dataList);
    }

    @Override
    public List<Map> selectAllCategory() {
        return industryConsultancyCategoryMapper.selectAllCategory();
    }

    @Override
    public int deleteIndusSingleOrBatch(List idList, ActiveUser activeUser, Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"删除新闻文章",(short) 0,activeUser.getUsername()+"删除新闻文章",session.getHost()));
        return industryConsultancyMapper.deleteIndusSingleOrBatch(idList);
    }

    @Override
    public int updateIndusStatus(int id, int status,ActiveUser activeUser,Session session) {
        IndustryConsultancy industryConsultancy = new IndustryConsultancy();
        industryConsultancy.setId(id);
        industryConsultancy.setStatus(status);
        industryConsultancy.setLastmodifytime(new Date());
        String str = status==0?"禁用成功":"启用成功";
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"新闻文章"+str,(short) 0,activeUser.getUsername()+str+"新闻文章",session.getHost()));
        return industryConsultancyMapper.updateByPrimaryKeySelective(industryConsultancy);
    }

    @Override
    public int updateIndustryConsultancy(IndustryConsultancy industryConsultancy,ActiveUser activeUser,Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"修改新闻文章",(short) 0,activeUser.getUsername()+"修改新闻文章",session.getHost()));
        return industryConsultancyMapper.updateByPrimaryKeySelective(industryConsultancy);
    }

    @Override
    public int insert(IndustryConsultancy industryConsultancy,ActiveUser activeUser,Session session) {
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"新增新闻文章",(short) 0,activeUser.getUsername()+"新增新闻文章",session.getHost()));
        return industryConsultancyMapper.insertSelective(industryConsultancy);
    }

    @Override
    public PageInfo<IndustryConsultancyViewVo> footerPagination(Map<String,Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<IndustryConsultancyViewVo> dataList = industryConsultancyMapper.footerPagination();
        return new PageInfo<IndustryConsultancyViewVo>(dataList);
    }

    @Override
    public IndustryConsultancy findIndustryConsultancyById(int id) {
        return industryConsultancyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateIndustryConsultancyLookNum(int id) {
        return industryConsultancyMapper.updateIndustryConsultancyLookNum(id);
    }
}
