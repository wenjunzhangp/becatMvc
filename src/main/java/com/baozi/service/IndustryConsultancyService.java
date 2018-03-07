package com.baozi.service;

import com.baozi.po.IndustryConsultancy;

import java.util.List;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 16:31
 * @description 文章相关的service
 **/
public interface IndustryConsultancyService {

    /**
     * 查询最新的五篇文章
     */
    public List<IndustryConsultancy> findIndustryConsultancyTop5();
}
