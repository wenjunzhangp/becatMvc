package com.baozi.mappers;

import com.baozi.po.WechatGraffiti;
import com.baozi.po.WechatGraffitiExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WechatGraffitiMapper {
    int countByExample(WechatGraffitiExample example);

    int deleteByExample(WechatGraffitiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatGraffiti record);

    int insertSelective(WechatGraffiti record);

    List<WechatGraffiti> selectByExample(WechatGraffitiExample example);

    WechatGraffiti selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatGraffiti record, @Param("example") WechatGraffitiExample example);

    int updateByExample(@Param("record") WechatGraffiti record, @Param("example") WechatGraffitiExample example);

    int updateByPrimaryKeySelective(WechatGraffiti record);

    int updateByPrimaryKey(WechatGraffiti record);

    List<WechatGraffiti> findWechatGraffitiByAuthor(String author);

    List<WechatGraffiti> findWechatGraffitiList();

    void updateWechatGraffitiLike(Map<String, Object> map);

    void updateWechatGraffitiNotLike(Map<String, Object> map);

}