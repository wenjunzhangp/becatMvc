package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class SysLog {
    private Integer id;

    private Integer userid;

    private Short logtype;

    private String username;

    private String opermodule;

    private Short opertype;

    private Date opertime;

    private String remark;

    private String host;

}