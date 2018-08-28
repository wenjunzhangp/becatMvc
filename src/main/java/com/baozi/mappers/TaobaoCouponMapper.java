package com.baozi.mappers;

import com.baozi.po.TaobaoCoupon;
import com.baozi.po.TaobaoCouponExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TaobaoCouponMapper {
    int countByExample(TaobaoCouponExample example);

    int deleteByExample(TaobaoCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaobaoCoupon record);

    int insertSelective(TaobaoCoupon record);

    List<TaobaoCoupon> selectByExampleWithBLOBs(TaobaoCouponExample example);

    List<TaobaoCoupon> selectByExample(TaobaoCouponExample example);

    TaobaoCoupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaobaoCoupon record, @Param("example") TaobaoCouponExample example);

    int updateByExampleWithBLOBs(@Param("record") TaobaoCoupon record, @Param("example") TaobaoCouponExample example);

    int updateByExample(@Param("record") TaobaoCoupon record, @Param("example") TaobaoCouponExample example);

    int updateByPrimaryKeySelective(TaobaoCoupon record);

    int updateByPrimaryKeyWithBLOBs(TaobaoCoupon record);

    int updateByPrimaryKey(TaobaoCoupon record);

    List<TaobaoCoupon> findTaobaoCouponPage(Map<String, Object> paramMap);
}