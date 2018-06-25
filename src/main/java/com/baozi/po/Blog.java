package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private Integer id;

    private String title;

    private String author;

    private Integer fabulous;

    private Integer looknum;

    private Integer category;

    private Integer sharenum;

    private String abstractremark;

    private Boolean stick;

    private Integer display;

    private Integer status;

    private Date createtime;

    private Date lastmodifytime;

    private String source;

    private Integer type;

    private String content;

}