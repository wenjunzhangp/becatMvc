package com.baozi.service;

import com.github.abel533.echarts.Option;

import java.util.Map;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-25 14:26
 */
public interface StatisticalReportDemoService {

    /**
     * 柱状统计图demo
     * @param
     * @return
     */
    Option getEchartsBarGraphOption();

    /**
     * 折线统计图demo
     * @param
     * @return
     */
    Option getEchartsLineGraphOption();

    /**
     * 饼状统计图demo
     * @param
     * @return
     */
    Option getEchartPancakeGraphOption();
}
