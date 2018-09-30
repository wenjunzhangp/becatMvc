package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class WechatIdiom {
    private Integer id;

    private String name;

    private String spell;

    private String gameimg;

    private String answer;

    private Date createtime;

}