package com.baozi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-25 15:00
 */
@Data
@AllArgsConstructor
public class MovieVo {

    private String title;//电影名称
    private Integer looknum;//观影人数
    private String year;//生产年份

    public static List<MovieVo> genMovieFactory(){
        List<MovieVo> list = new ArrayList<MovieVo>();
        MovieVo dmkj = new MovieVo("盗梦空间",10,"1993");
        MovieVo xdldmd = new MovieVo("辛德拉的名单",20,"1993");
        MovieVo qyqx = new MovieVo("千与千寻",30,"1993");
        MovieVo dpcq = new MovieVo("斗破苍穹",40,"2005");
        MovieVo bwbj = new MovieVo("霸王别姬",50,"2008");
        MovieVo ssbe = new MovieVo("杀死比尔",60,"2003");
        MovieVo zgshbtl = new MovieVo("这个杀手不太冷",70,"2015");
        MovieVo xhkdjs = new MovieVo("肖申克的救赎",80,"2018");
        MovieVo ttnkh = new MovieVo("泰坦尼克号",90,"2018");
        MovieVo agzz = new MovieVo("阿甘正传",100,"2018");
        MovieVo nzstz = new MovieVo("哪吒三太子",110,"2018");
        MovieVo sdyjq = new MovieVo("速度与激情全集",120,"2018");
        MovieVo cllxj = new MovieVo("成龙历险记",130,"2018");
        list.add(dmkj);
        list.add(xdldmd);
        list.add(qyqx);
        list.add(dpcq);
        list.add(bwbj);
        list.add(ssbe);
        list.add(zgshbtl);
        list.add(xhkdjs);
        list.add(ttnkh);
        list.add(agzz);
        list.add(nzstz);
        list.add(sdyjq);
        list.add(cllxj);
        return list;
    }
}
