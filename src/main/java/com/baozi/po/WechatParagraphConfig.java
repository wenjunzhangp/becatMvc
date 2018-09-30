package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class WechatParagraphConfig {
    private Integer id;

    private String paragraphname;

    private Integer min;

    private Integer max;

    private Date createtime;

    private Date modifytime;

}