package com.baozi.mappers;

import com.baozi.po.SysPermission;
import com.baozi.po.SysPermissionExample;
import com.baozi.vo.SysPermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysPermissionMapper {
    int countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermissionVo> findSysPermissionPage(Map<String, Object> paramMap);

    int deleteSysPermissionSingleOrBatch(List idList);
}