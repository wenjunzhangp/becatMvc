package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class SysLink {
    private Integer id;

    private String logo;

    private String domainname;

    private String domainurl;

    private String contact;

    private Integer show;

    private Date createtime;

    private Integer display;

    private Integer status;

}