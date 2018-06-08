package com.baozi.service;

import com.baozi.po.IndustryConsultancy;
import com.baozi.vo.IndustryConsultancyViewVo;
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
    List<IndustryConsultancyViewVo> findIndustryConsultancyTopLimit(int limit);

    /**
     * 分页查询文章列表
     * @param paramMap
     * @return
     */
     PageInfo<IndustryConsultancyVo> findIndustryConsultancyPage(Map<String,Object> paramMap);

    /**
     * 加载所有文章分类
     * @return
     */
     List<Map> selectAllCategory();

    /**
     * 执行批量删除文章
     * @param idList
     * @return
     */
     int deleteIndusSingleOrBatch(List idList);

    /**
     * 启动或者禁用文章
     * @param id
     * @param status
     * @return
     */
     int updateIndusStatus(int id,int status);

    /**
     * 修改文章表
     * @param industryConsultancy
     * @return
     */
     int updateIndustryConsultancy(IndustryConsultancy industryConsultancy);

    /**
     * 新增文章
     * @param industryConsultancy
     * @return
     */
     int insert(IndustryConsultancy industryConsultancy);

    /**
     * 前台页脚分页列表
     * @return
     */
    PageInfo<IndustryConsultancyViewVo> footerPagination(Map<String,Object> paramMap);
}
