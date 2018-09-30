package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class WechatUserinfo {
    private Integer id;

    private String nickname;

    private String openid;

    private String url;

    private Integer gender;

    private Integer intelligencenum;

    private Integer paragraphid;

    private Date createtime;

    private Date modifytime;

}