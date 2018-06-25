package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private Integer id;

    private String title;

    private Date createtime;

    private Integer category;

    private Integer status;

    private Date publictime;

    private Date lastmodifytime;

    private Integer display;

    private String img;

    private String content;

}