package com.baozi.mappers;

import com.baozi.po.SysLink;
import com.baozi.po.SysLinkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysLinkMapper {
    int countByExample(SysLinkExample example);

    int deleteByExample(SysLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysLink record);

    int insertSelective(SysLink record);

    List<SysLink> selectByExample(SysLinkExample example);

    SysLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysLink record, @Param("example") SysLinkExample example);

    int updateByExample(@Param("record") SysLink record, @Param("example") SysLinkExample example);

    int updateByPrimaryKeySelective(SysLink record);

    int updateByPrimaryKey(SysLink record);
}