package com.baozi.po;

public class SysRolePermission {
    private int id;

    private String sysRoleId;

    private String sysPermissionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id ;
    }

    public String getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId == null ? null : sysRoleId.trim();
    }

    public String getSysPermissionId() {
        return sysPermissionId;
    }

    public void setSysPermissionId(String sysPermissionId) {
        this.sysPermissionId = sysPermissionId == null ? null : sysPermissionId.trim();
    }
}