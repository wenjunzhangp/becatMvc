package com.baozi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baozi.service.StatisticalReportDemoService;
import com.baozi.vo.MovieVo;
import com.github.abel533.echarts.*;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.series.Series;
import com.github.abel533.echarts.style.ItemStyle;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-25 14:46
 */
@Service
public class StatisticalReportDemoServiceImpl implements StatisticalReportDemoService {

    @Override
    public Option getEchartsBarGraphOption() {
        List<MovieVo> list = MovieVo.genMovieFactory();
        //echarts option 对象
        Option option = new Option();
        option.title("电影评价人数统计").tooltip(Trigger.axis).legend("评价人数");
        //x轴为值轴
        option.xAxis(new ValueAxis().boundaryGap(0d, 0.01));

        //y轴为类目轴
        CategoryAxis category = new CategoryAxis();
        //柱状数据
        Bar bar = new Bar("评价人数");
        //循环数据
        for (MovieVo m : list) {
            //设置类目
            category.data(m.getTitle());
            //类目对应的柱状图
            bar.data(m.getLooknum());
        }

        Grid grid = new Grid();
        grid.setLeft(200);
        option.setGrid(grid);
        option.yAxis(category);
        option.series(bar);

        return option;
    }

    @Override
    public Option getEchartsLineGraphOption() {
        List<MovieVo> list = MovieVo.genMovieFactory();
        //echarts option 对象
        Option option = new Option();

        option.legend("高度(km)与气温(°C)变化关系");

        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar), Tool.restore, Tool.saveAsImage);

        option.calculable(true);
        option.tooltip().trigger(Trigger.axis).formatter("Temperature : <br/>{b}km : {c}°C");

        ValueAxis valueAxis = new ValueAxis();
        valueAxis.axisLabel().formatter("{value} °C");
        option.xAxis(valueAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.axisLine().onZero(false);
        categoryAxis.axisLabel().formatter("{value} km");
        categoryAxis.boundaryGap(false);
        categoryAxis.data(0, 10, 20, 30, 40, 50, 60, 70, 80);
        option.yAxis(categoryAxis);

        Line line = new Line();
        line.smooth(true).name("高度(km)与气温(°C)变化关系").data(15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
        option.series(line);

        return option;
    }

    @Override
    public Option getEchartPancakeGraphOption() {
        List<MovieVo> list = MovieVo.genMovieFactory();
        Option option = new Option();
        //标题
        Title title = new Title();
        title.setText("BeCat电影上映年份");
        title.setSubtext("来源腾讯视频");
        title.setX("center");
        option.setTitle(title);

        //提示框
        Tooltip tooltip = new Tooltip();
        tooltip.setTrigger(Trigger.item);
        tooltip.formatter("{a} <br/>{b} : {c} ({d}%)");
        option.setTooltip(tooltip);

        //Legend
        Legend legend = new Legend();
        List<String> legendDataList = Arrays.asList("90年代", "00年代", "10年代","其他");
        legend.setOrient(Orient.vertical);
        legend.setLeft("left");
        legend.setData(legendDataList);
        option.setLegend(legend);

        //饼状图
        Pie pie = new Pie();
        //对数据进行简单处理
        int y90 =0;
        int y00 =0;
        int y10 =0;
        int yElse =0;
        for (MovieVo movie : list) {
            if(movie.getYear().startsWith("199")){
                y90++;
            }
            else if (movie.getYear().startsWith("200")){
                y00++;
            }
            else if (movie.getYear().startsWith("201")){
                y10++;
            }
            else{
                yElse++;
            }
        }
        Map<String,String> dataMap90 = new HashMap<>(256);
        dataMap90.put("name","90年代");
        dataMap90.put("value",String.valueOf(y90));
        Map<String,String> dataMap00 = new HashMap<>(256);
        dataMap00.put("name","00年代");
        dataMap00.put("value",String.valueOf(y00));
        Map<String,String> dataMap10 = new HashMap<>(256);
        dataMap10.put("name","10年代");
        dataMap10.put("value",String.valueOf(y10));
        Map<String,String> dataMapElse = new HashMap<>(256);
        dataMapElse.put("name","其他");
        dataMapElse.put("value",String.valueOf(yElse));
        //封装pie
        pie.data(dataMap90, dataMap00, dataMap10, dataMapElse);
        pie.setName("上映年代");
        pie.setRadius("55%");
        String [] centerArray = {"50%","60%"};
        pie.setCenter(centerArray);

        option.series(pie);

        return option;
    }

    @Override
    public Option getEchartMapGraphOption() {
        Option option = new Option();
        //标题
        Title title = new Title();
        title.setText("香港18区人口密度");
        title.setSubtext("人口密度数据来自echarts");
        title.setX("center");
        option.setTitle(title);
        //提示工具
        Tooltip tooltip = new Tooltip();
        tooltip.setTrigger(Trigger.item);
        tooltip.setFormatter("{b}<br/>{c} (p / km2)");
        option.setTooltip(tooltip);
        //地图比例尺
        List<VisualMap> visualMap = new ArrayList<>();
        VisualMap map = new VisualMap();
        map.setMin(800);
        map.setMax(5000);
        Object[] obj = {"最低","最高"};
        map.setText(obj);
        map.setRealtime(false);
        map.setCalculable(true);
        map.setInRange(VisualMapType.colorAlpha);
        visualMap.add(map);
        option.setVisualMap(visualMap);
        //series数据集合
        List<Series> series = new ArrayList<>();
        com.github.abel533.echarts.series.Map mapgithub = new com.github.abel533.echarts.series.Map();
        mapgithub.setName("香港18区人口密度");
        mapgithub.setType(SeriesType.map);
        ItemStyle itemStyle = new ItemStyle();
        /*itemStyle.setNormal();
        mapgithub.setItemStyle();
        series.add();
        option.series();*/

        return option;
    }

}
