package com.baozi.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Pet {
    private Integer id;

    private String name;

    private Double height;

    private Double width;

    private Integer category;

    private BigDecimal price;

    private String photo;

    private Date createtime;

    private Date lastmodifytime;

    private Date birthday;

    private Integer purebred;

    private Boolean gender;

    private Boolean stock;

}