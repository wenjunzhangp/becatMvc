package com.baozi.service.impl;

import com.baozi.mappers.BlogMapper;
import com.baozi.po.Blog;
import com.baozi.service.BlogService;
import com.baozi.vo.BlogViewVo;
import com.baozi.vo.BlogVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-11 15:31
 */
@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public PageInfo<BlogVo> findBlogPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<BlogVo> dataList = blogMapper.findBlogPage(paramMap);
        return new PageInfo<BlogVo>(dataList);
    }

    @Override
    public int deleteBlogSingleOrBatch(List idList) {
        return blogMapper.deleteBlogSingleOrBatch(idList);
    }

    @Override
    public int updateBlogStatus(int id, int status) {
        Blog blog = new Blog();
        blog.setId(id);
        blog.setStatus(status);
        blog.setLastmodifytime(new Date());
        return blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public int insert(Blog blog) {
        return blogMapper.insertSelective(blog);
    }

    @Override
    public PageInfo<BlogViewVo> footerPagination(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<BlogViewVo> dataList = blogMapper.footerPagination();
        return new PageInfo<BlogViewVo>(dataList);
    }

    @Override
    public Blog findBlogById(int id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateBlogLookNum(int id) {
        return blogMapper.updateBlogLookNum(id);
    }

    @Override
    public int updateBlogStick(int id, int status) {
        Blog blog = new Blog();
        blog.setId(id);
        blog.setStick(status==1?true:false);
        blog.setLastmodifytime(new Date());
        return blogMapper.updateByPrimaryKeySelective(blog);
    }
}
