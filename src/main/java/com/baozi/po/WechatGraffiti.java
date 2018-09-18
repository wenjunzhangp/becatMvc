package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class WechatGraffiti {
    private Integer id;

    private String author;

    private Integer gender;

    private String url;

    private String month;

    private String filename;

    private Integer likenum;

    private Date createtime;

    private Date modifytime;

}