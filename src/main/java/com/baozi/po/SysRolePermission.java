package com.baozi.po;

import lombok.Data;

@Data
public class SysRolePermission {
    private int id;

    private String sysRoleId;

    private String sysPermissionId;

    public SysRolePermission(String s, String pid) {
        this.sysRoleId=s;
        this.sysPermissionId=pid;
    }
}