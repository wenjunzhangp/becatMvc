package com.baozi.service.impl;

import com.baozi.mappers.TaobaoCouponMapper;
import com.baozi.po.TaobaoCoupon;
import com.baozi.service.TaobaoCouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-08-28 10:03
 */
@Service
public class TaobaoCouponServiceImpl implements TaobaoCouponService {

    @Autowired
    private TaobaoCouponMapper taobaoCouponMapper;

    @Override
    public PageInfo<TaobaoCoupon> findTaobaoCouponPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<TaobaoCoupon> dataList = taobaoCouponMapper.findTaobaoCouponPage(paramMap);
        return new PageInfo<TaobaoCoupon>(dataList);
    }
}
