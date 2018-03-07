package com.baozi.mappers;

import com.baozi.po.MessageAuthor;
import com.baozi.po.MessageAuthorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageAuthorMapper {
    int countByExample(MessageAuthorExample example);

    int deleteByExample(MessageAuthorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageAuthor record);

    int insertSelective(MessageAuthor record);

    List<MessageAuthor> selectByExample(MessageAuthorExample example);

    MessageAuthor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageAuthor record, @Param("example") MessageAuthorExample example);

    int updateByExample(@Param("record") MessageAuthor record, @Param("example") MessageAuthorExample example);

    int updateByPrimaryKeySelective(MessageAuthor record);

    int updateByPrimaryKey(MessageAuthor record);
}