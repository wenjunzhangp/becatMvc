package com.baozi.mappers;

import com.baozi.po.Blog;
import com.baozi.po.BlogExample;
import com.baozi.vo.BlogViewVo;
import com.baozi.vo.BlogVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

    List<BlogVo> findBlogPage(Map<String,Object> paramMap);

    int deleteBlogSingleOrBatch(List idList);

    List<BlogViewVo> footerPagination();

    int updateBlogLookNum(int id);
}