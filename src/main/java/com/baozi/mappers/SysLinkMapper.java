package com.baozi.mappers;

import com.baozi.po.SysLink;
import com.baozi.po.SysLinkExample;
import com.baozi.vo.SysLinkVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    List<SysLinkVo> findSysLinkPage(Map<String, Object> paramMap);

    int deleteSysLinkSingleOrBatch(List idList);

    List<SysLinkVo> findSysLinkByLimitAndPosition(int position);
}