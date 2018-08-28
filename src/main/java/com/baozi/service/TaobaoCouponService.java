package com.baozi.service;

import com.baozi.po.TaobaoCoupon;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-08-28 10:02
 */
public interface TaobaoCouponService {

    /**
     * 分页查询淘宝订单优惠券数据
     * @param paramMap
     * @return
     */
    PageInfo<TaobaoCoupon> findTaobaoCouponPage(Map<String,Object> paramMap);

}
