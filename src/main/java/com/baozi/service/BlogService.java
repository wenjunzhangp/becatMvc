package com.baozi.service;

import com.baozi.po.Blog;
import com.baozi.vo.BlogViewVo;
import com.baozi.vo.BlogVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-11 15:28
 */
public interface BlogService {

    /**
     * 分页查询技术博客列表
     * @param paramMap
     * @return
     */
    PageInfo<BlogVo> findBlogPage(Map<String,Object> paramMap);

    /**
     * 执行批量删除博客
     * @param idList
     * @return
     */
    int deleteBlogSingleOrBatch(List idList);

    /**
     * 启动或者禁用博客
     * @param id
     * @param status
     * @return
     */
    int updateBlogStatus(int id,int status);

    /**
     * 修改博客表
     * @param blog
     * @return
     */
    int updateBlog(Blog blog);

    /**
     * 新增博客
     * @param blog
     * @return
     */
    int insert(Blog blog);

    /**
     * 前台页脚分页列表
     * @return
     */
    PageInfo<BlogViewVo> footerPagination(Map<String,Object> paramMap);

    /**
     * 获取单篇博客，做详情页用
     * @param id
     * @return
     */
    Blog findBlogById(int id);

    /**
     * 博客阅读数+1
     * @param id
     * @return
     */
    int updateBlogLookNum(int id);

    /**
     * 置顶  下顶 技术博客
     * @param id
     * @param status
     */
    int updateBlogStick(int id, int status);
}
