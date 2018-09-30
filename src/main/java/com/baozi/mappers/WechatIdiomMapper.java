package com.baozi.mappers;

import com.baozi.po.WechatIdiom;
import com.baozi.po.WechatIdiomExample;
import com.baozi.po.WechatIdiomWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WechatIdiomMapper {
    int countByExample(WechatIdiomExample example);

    int deleteByExample(WechatIdiomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatIdiomWithBLOBs record);

    int insertSelective(WechatIdiomWithBLOBs record);

    List<WechatIdiomWithBLOBs> selectByExampleWithBLOBs(WechatIdiomExample example);

    List<WechatIdiom> selectByExample(WechatIdiomExample example);

    WechatIdiomWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatIdiomWithBLOBs record, @Param("example") WechatIdiomExample example);

    int updateByExampleWithBLOBs(@Param("record") WechatIdiomWithBLOBs record, @Param("example") WechatIdiomExample example);

    int updateByExample(@Param("record") WechatIdiom record, @Param("example") WechatIdiomExample example);

    int updateByPrimaryKeySelective(WechatIdiomWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WechatIdiomWithBLOBs record);

    int updateByPrimaryKey(WechatIdiom record);

    List<WechatIdiom> findWechatIdiomServiceALL();

    void updateAnswer(Map<String,Object> map);
}