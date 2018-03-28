package com.baozi.mappers;

import com.baozi.po.IndustryConsultancy;
import com.baozi.po.IndustryConsultancyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IndustryConsultancyMapper {
    int countByExample(IndustryConsultancyExample example);

    int deleteByExample(IndustryConsultancyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndustryConsultancy record);

    int insertSelective(IndustryConsultancy record);

    List<IndustryConsultancy> selectByExampleWithBLOBs(IndustryConsultancyExample example);

    List<IndustryConsultancy> selectByExample(IndustryConsultancyExample example);

    IndustryConsultancy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndustryConsultancy record, @Param("example") IndustryConsultancyExample example);

    int updateByExampleWithBLOBs(@Param("record") IndustryConsultancy record, @Param("example") IndustryConsultancyExample example);

    int updateByExample(@Param("record") IndustryConsultancy record, @Param("example") IndustryConsultancyExample example);

    int updateByPrimaryKeySelective(IndustryConsultancy record);

    int updateByPrimaryKeyWithBLOBs(IndustryConsultancy record);

    int updateByPrimaryKey(IndustryConsultancy record);

    public List<IndustryConsultancy> findIndustryConsultancyTop5();

    public List<IndustryConsultancy> findIndustryConsultancyPage(Map<String,Object> paramMap);
}