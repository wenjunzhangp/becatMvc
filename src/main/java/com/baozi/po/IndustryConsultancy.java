package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class IndustryConsultancy {
    private Integer id;

    private String title;

    //1未删除  0删除   （逻辑删除）
    private Boolean display;

    private Date createtime;

    private Date publictime;

    private Date lastmodifytime;

    //1启用 0禁用
    private Integer status;

    private String major;

    private String remark;

    private Integer category;

    private String source;

    private Integer sharenumber;

    private Integer looknumber;

    private String sourceimg;

    private String description;

    private String carouselposition;

    //1热点  0非热点
    private Boolean hot;

    private String content;

}