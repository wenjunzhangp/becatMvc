package com.baozi.mappers;

import com.baozi.po.UserLog;
import com.baozi.po.UserLogExample;
import com.baozi.vo.UserLogVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserLogMapper {
    int countByExample(UserLogExample example);

    int deleteByExample(UserLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserLog record);

    int insertSelective(UserLog record);

    List<UserLog> selectByExample(UserLogExample example);

    UserLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByExample(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByPrimaryKeySelective(UserLog record);

    int updateByPrimaryKey(UserLog record);

    List<UserLogVo> findUserLogPage(Map<String,Object> paramMap);
}