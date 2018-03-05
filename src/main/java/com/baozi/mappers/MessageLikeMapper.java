package com.baozi.mappers;

import com.baozi.po.MessageLike;
import com.baozi.po.MessageLikeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageLikeMapper {
    int countByExample(MessageLikeExample example);

    int deleteByExample(MessageLikeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageLike record);

    int insertSelective(MessageLike record);

    List<MessageLike> selectByExample(MessageLikeExample example);

    MessageLike selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageLike record, @Param("example") MessageLikeExample example);

    int updateByExample(@Param("record") MessageLike record, @Param("example") MessageLikeExample example);

    int updateByPrimaryKeySelective(MessageLike record);

    int updateByPrimaryKey(MessageLike record);
}