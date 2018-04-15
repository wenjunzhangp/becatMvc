package com.baozi.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserLogVo {
    private Integer id;

    private Integer userid;

    private Short logtype;

    private String username;

    private String opermodule;

    private Short opertype;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date opertime;

    private String remark;

    private String host;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Short getLogtype() {
        return logtype;
    }

    public void setLogtype(Short logtype) {
        this.logtype = logtype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getOpermodule() {
        return opermodule;
    }

    public void setOpermodule(String opermodule) {
        this.opermodule = opermodule;
    }

    public Short getOpertype() {
        return opertype;
    }

    public void setOpertype(Short opertype) {
        this.opertype = opertype;
    }

    public Date getOpertime() {
        return opertime;
    }

    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}