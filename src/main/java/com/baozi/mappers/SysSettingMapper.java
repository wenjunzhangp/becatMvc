package com.baozi.mappers;

import com.baozi.po.SysSetting;
import com.baozi.po.SysSettingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysSettingMapper {
    int countByExample(SysSettingExample example);

    int deleteByExample(SysSettingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysSetting record);

    int insertSelective(SysSetting record);

    List<SysSetting> selectByExample(SysSettingExample example);

    SysSetting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysSetting record, @Param("example") SysSettingExample example);

    int updateByExample(@Param("record") SysSetting record, @Param("example") SysSettingExample example);

    int updateByPrimaryKeySelective(SysSetting record);

    int updateByPrimaryKey(SysSetting record);
}