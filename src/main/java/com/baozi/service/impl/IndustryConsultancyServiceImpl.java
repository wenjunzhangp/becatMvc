package com.baozi.service.impl;

import com.baozi.mappers.IndustryConsultancyMapper;
import com.baozi.po.IndustryConsultancy;
import com.baozi.service.IndustryConsultancyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<IndustryConsultancy> findIndustryConsultancyTop5() {
        return industryConsultancyMapper.findIndustryConsultancyTop5();
    }

    @Override
    public PageInfo<IndustryConsultancy> findIndustryConsultancyPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<IndustryConsultancy> dataList = industryConsultancyMapper.findIndustryConsultancyPage(paramMap);
        return new PageInfo<IndustryConsultancy>(dataList);
    }
}
