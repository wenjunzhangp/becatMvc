package com.baozi.controller;

import com.baozi.service.TaobaoCouponService;
import com.baozi.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-08-28 10:04
 */
@RequestMapping("/taobao")
@Controller
public class TaobaoCouponController extends BaseController {

    @Autowired
    private TaobaoCouponService taobaoCouponService;

    @RequestMapping("/coupon")
    public ModelAndView coupon(){
        ModelAndView mav = new ModelAndView("coupon");
        return mav;
    }

    @RequestMapping("/coupondata")
    @ResponseBody
    public Map<String,Object> coupondata(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            setResultMapOkByPage(taobaoCouponService.findTaobaoCouponPage(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("读取淘宝优惠券数据失败",e);
            setResultMapError(e);
        }
        return resultMap;
    }
}
