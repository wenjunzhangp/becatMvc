package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class WechatGraffiti {
    private Integer id;

    private String author;

    //微信小程序用户性别 1男性 2女性 0未知
    private Integer gender;

    private String url;

    private String month;

    private String filename;

    private Integer likenum;

    private Date createtime;

    private Date modifytime;

}