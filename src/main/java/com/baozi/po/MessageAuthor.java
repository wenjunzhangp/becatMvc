package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class MessageAuthor {
    private Long id;

    private String openId;

    private Integer openType;

    private String avatarUrl;

    private String url;

    private String nickname;

    private Date createTime;

    private String email;

    private String sucurity;

}