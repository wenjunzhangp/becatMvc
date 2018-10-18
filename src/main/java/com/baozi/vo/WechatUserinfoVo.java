package com.baozi.vo;

import lombok.Data;

import java.util.Date;

@Data
public class WechatUserinfoVo {

    private Integer id;

    private String paragraphname;//段位名称

    private String openid;//微信用户openid

    private Integer intelligencenum;//蓝豆豆余额

}