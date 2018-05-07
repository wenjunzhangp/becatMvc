package com.baozi.mappers;

import com.baozi.po.SysRole;
import com.baozi.po.SysRoleExample;
import com.baozi.vo.SysRoleVo;
import com.baozi.vo.UserRoleAllocationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(int id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> findNowAllPermission(@Param("userId")int userId);

    public List<SysRoleVo> findSysRolePage(Map<String, Object> paramMap);

    public List<UserRoleAllocationVo> findUserRoleAllocationPage(Map<String, Object> paramMap);
}