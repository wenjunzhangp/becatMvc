package com.baozi.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WechatIdiom implements Serializable {
    private Integer id;

    private String name;

    private String spell;

    private String gameimg;

    private String answer;

    private Date createtime;

    private String content;

    private String derivation;

    private String samples;

}