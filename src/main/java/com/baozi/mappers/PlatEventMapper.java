package com.baozi.mappers;

import com.baozi.po.PlatEvent;
import com.baozi.po.PlatEventExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    public List<PlatEvent> findAllPlatEvent();
}