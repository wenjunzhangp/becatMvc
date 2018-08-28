package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class TaobaoCoupon {
    private Integer id;

    private String goodsname;

    private String goodsremark;

    private String totalcount;

    private String buynum;

    private String onlineprice;

    private String couponprice;

    private Date createtime;

    private String url;

}