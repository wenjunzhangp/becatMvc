package com.baozi.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    private Integer id;

    private String usercode;

    private String realname;

    private String username;

    private String password;

    private String hobby;

    private String myself;

    private String birthday;

    private Integer gender;

    private String phone;

    private String salt;

    private String locked;

    private String email;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastLoginTime;

    private String sourceimg;

}