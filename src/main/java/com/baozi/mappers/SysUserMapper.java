package com.baozi.mappers;

import com.baozi.po.SysUser;
import com.baozi.po.SysUserExample;
import com.baozi.vo.SysUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    Date findUserLastLoginTime(@Param("userId") int userId);

    List<SysUserVo> findSysUserPage(Map<String, Object> paramMap);

    void updateSysUserLock(Map<String, Object> paramMap);
}