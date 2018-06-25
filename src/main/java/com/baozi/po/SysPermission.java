package com.baozi.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysPermission implements Serializable{
    private int id;

    private String name;

    private String type;

    private String url;

    private String percode;

    private Long parentid;

    private String parentids;

    private String sortstring;

    private String available;

}