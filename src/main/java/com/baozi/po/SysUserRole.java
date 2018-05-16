package com.baozi.po;

public class SysUserRole {
    private int id;

    private int sysUserId;

    private int sysRoleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    public int getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(int sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public SysUserRole(int sysUserId, int sysRoleId) {
        this.sysUserId = sysUserId;
        this.sysRoleId = sysRoleId;
    }
}