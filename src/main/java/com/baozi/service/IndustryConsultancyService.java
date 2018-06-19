package com.baozi.service;

import com.baozi.po.ActiveUser;
import com.baozi.po.IndustryConsultancy;
import com.baozi.vo.IndustryConsultancyViewVo;
import com.baozi.vo.IndustryConsultancyVo;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.session.Session;

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
     int deleteIndusSingleOrBatch(List idList,ActiveUser activeUser,Session session);

    /**
     * 启动或者禁用文章
     * @param id
     * @param status
     * @return
     */
     int updateIndusStatus(int id, int status, ActiveUser activeUser, Session session);

    /**
     * 修改文章表
     * @param industryConsultancy
     * @return
     */
     int updateIndustryConsultancy(IndustryConsultancy industryConsultancy,ActiveUser activeUser,Session session);

    /**
     * 新增文章
     * @param industryConsultancy
     * @return
     */
     int insert(IndustryConsultancy industryConsultancy,ActiveUser activeUser,Session session);

    /**
     * 前台页脚分页列表
     * @return
     */
    PageInfo<IndustryConsultancyViewVo> footerPagination(Map<String,Object> paramMap);

    /**
     * 获取单篇文章，做详情页用
     * @param id
     * @return
     */
    IndustryConsultancy findIndustryConsultancyById(int id);

    /**
     * 文章阅读数+1
     * @param id
     * @return
     */
    int updateIndustryConsultancyLookNum(int id);
}
