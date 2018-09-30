package com.baozi.mappers;

import com.baozi.po.WechatParagraphConfig;
import com.baozi.po.WechatParagraphConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WechatParagraphConfigMapper {
    int countByExample(WechatParagraphConfigExample example);

    int deleteByExample(WechatParagraphConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatParagraphConfig record);

    int insertSelective(WechatParagraphConfig record);

    List<WechatParagraphConfig> selectByExample(WechatParagraphConfigExample example);

    WechatParagraphConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatParagraphConfig record, @Param("example") WechatParagraphConfigExample example);

    int updateByExample(@Param("record") WechatParagraphConfig record, @Param("example") WechatParagraphConfigExample example);

    int updateByPrimaryKeySelective(WechatParagraphConfig record);

    int updateByPrimaryKey(WechatParagraphConfig record);
}