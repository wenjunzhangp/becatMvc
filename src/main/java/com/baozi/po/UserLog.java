package com.baozi.po;

import java.util.Date;

public class UserLog {
    private Integer id;

    private Integer userid;

    private Short logtype;

    private String username;

    private Integer opermodule;

    private Short opertype;

    private Date opertime;

    private String remark;

    private Integer host;

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

    public Integer getOpermodule() {
        return opermodule;
    }

    public void setOpermodule(Integer opermodule) {
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

    public Integer getHost() {
        return host;
    }

    public void setHost(Integer host) {
        this.host = host;
    }
}