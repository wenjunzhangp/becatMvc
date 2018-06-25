package com.baozi.po;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class SysRole {
    private int id;

    private String name;

    private String available;

    private List<SysPermission> permissions = new LinkedList<SysPermission>();

}