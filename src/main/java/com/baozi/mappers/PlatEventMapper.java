package com.baozi.mappers;

import com.baozi.po.PlatEvent;
import com.baozi.po.PlatEventExample;
import com.baozi.vo.PlatEventViewVo;
import com.baozi.vo.PlatEventVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PlatEventMapper {
    int countByExample(PlatEventExample example);

    int deleteByExample(PlatEventExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlatEvent record);

    int insertSelective(PlatEvent record);

    List<PlatEvent> selectByExampleWithBLOBs(PlatEventExample example);

    List<PlatEvent> selectByExample(PlatEventExample example);

    PlatEvent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlatEvent record, @Param("example") PlatEventExample example);

    int updateByExampleWithBLOBs(@Param("record") PlatEvent record, @Param("example") PlatEventExample example);

    int updateByExample(@Param("record") PlatEvent record, @Param("example") PlatEventExample example);

    int updateByPrimaryKeySelective(PlatEvent record);

    int updateByPrimaryKeyWithBLOBs(PlatEvent record);

    int updateByPrimaryKey(PlatEvent record);

    List<PlatEvent> findAllPlatEvent();

    List<PlatEventVo> findPlatEventPage(Map<String, Object> paramMap);

    int deletePlatEventSingleOrBatch(List idList);

    List<PlatEventViewVo> footerPagination();
}