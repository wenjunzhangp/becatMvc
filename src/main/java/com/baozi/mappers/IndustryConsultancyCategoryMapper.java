package com.baozi.mappers;

import com.baozi.po.IndustryConsultancyCategory;
import com.baozi.po.IndustryConsultancyCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndustryConsultancyCategoryMapper {
    int countByExample(IndustryConsultancyCategoryExample example);

    int deleteByExample(IndustryConsultancyCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndustryConsultancyCategory record);

    int insertSelective(IndustryConsultancyCategory record);

    List<IndustryConsultancyCategory> selectByExample(IndustryConsultancyCategoryExample example);

    IndustryConsultancyCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndustryConsultancyCategory record, @Param("example") IndustryConsultancyCategoryExample example);

    int updateByExample(@Param("record") IndustryConsultancyCategory record, @Param("example") IndustryConsultancyCategoryExample example);

    int updateByPrimaryKeySelective(IndustryConsultancyCategory record);

    int updateByPrimaryKey(IndustryConsultancyCategory record);
}