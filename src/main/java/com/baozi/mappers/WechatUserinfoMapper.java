package com.baozi.mappers;

import com.baozi.po.WechatUserinfo;
import com.baozi.po.WechatUserinfoExample;
import com.baozi.vo.WechatUserinfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WechatUserinfoMapper {
    int countByExample(WechatUserinfoExample example);

    int deleteByExample(WechatUserinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatUserinfo record);

    int insertSelective(WechatUserinfo record);

    List<WechatUserinfo> selectByExample(WechatUserinfoExample example);

    WechatUserinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatUserinfo record, @Param("example") WechatUserinfoExample example);

    int updateByExample(@Param("record") WechatUserinfo record, @Param("example") WechatUserinfoExample example);

    int updateByPrimaryKeySelective(WechatUserinfo record);

    int updateByPrimaryKey(WechatUserinfo record);

    WechatUserinfoVo findWechatUserinfoByOpenId(@Param("openid") String openid);
}