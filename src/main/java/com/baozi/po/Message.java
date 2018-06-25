package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private Long id;

    private Date createdTime;

    private Long parentId;

    private Integer likes;

    private String agent;

    private String ip;

    private String iplocation;

    private Long authorId;

    private String pkey;

    private String referer;

    private String pids;

    private Integer level;

    private String message;

}