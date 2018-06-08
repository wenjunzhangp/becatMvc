package com.baozi.mappers;

import com.baozi.po.IndustryConsultancy;
import com.baozi.po.IndustryConsultancyExample;
import com.baozi.vo.IndustryConsultancyViewVo;
import com.baozi.vo.IndustryConsultancyVo;
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

    IndustryConsultancyViewVo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndustryConsultancy record, @Param("example") IndustryConsultancyExample example);

    int updateByExampleWithBLOBs(@Param("record") IndustryConsultancy record, @Param("example") IndustryConsultancyExample example);

    int updateByExample(@Param("record") IndustryConsultancy record, @Param("example") IndustryConsultancyExample example);

    int updateByPrimaryKeySelective(IndustryConsultancy record);

    int updateByPrimaryKeyWithBLOBs(IndustryConsultancy record);

    int updateByPrimaryKey(IndustryConsultancy record);

    List<IndustryConsultancyViewVo> findIndustryConsultancyTopLimit(int limit);

    List<IndustryConsultancyVo> findIndustryConsultancyPage(Map<String,Object> paramMap);

    int deleteIndusSingleOrBatch(List idList);

    List<IndustryConsultancyViewVo> footerPagination();

    int updateIndustryConsultancyLookNum(int id);
}