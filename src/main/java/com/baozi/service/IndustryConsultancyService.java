package com.baozi.service;

import com.baozi.po.IndustryConsultancy;
import com.baozi.vo.IndustryConsultancyVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

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

    /**
     * 分页查询文章列表
     * @param paramMap
     * @return
     */
    public PageInfo<IndustryConsultancyVo> findIndustryConsultancyPage(Map<String,Object> paramMap);

    /**
     * 加载所有文章分类
     * @return
     */
    public List<Map> selectAllCategory();

    /**
     * 执行批量删除文章
     * @param idList
     * @return
     */
    public int deleteIndusSingleOrBatch(List idList);

    /**
     * 启动或者禁用文章
     * @param id
     * @param status
     * @return
     */
    public int updateIndusStatus(int id,int status);
}
