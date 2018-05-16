package com.baozi.mappers;

import com.baozi.po.SysRolePermission;
import com.baozi.po.SysRolePermissionExample;
import com.baozi.vo.RolePermissionAllocationVo;
import com.baozi.vo.RolePermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysRolePermissionMapper {
    int countByExample(SysRolePermissionExample example);

    int deleteByExample(SysRolePermissionExample example);

    int deleteByPrimaryKey(int id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    SysRolePermission selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);

    public List<RolePermissionAllocationVo> findRolePermissionAllocationPage(Map<String, Object> paramMap);

    public List<RolePermissionVo> selectPermissionById(int permissionId);

    public void deleteByRoleId(int roleId);
}