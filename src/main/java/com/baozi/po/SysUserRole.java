package com.baozi.po;

import lombok.Data;

@Data
public class SysUserRole {
    private int id;

    private int sysUserId;

    private int sysRoleId;

    public SysUserRole(int sysUserId, int sysRoleId) {
        this.sysUserId = sysUserId;
        this.sysRoleId = sysRoleId;
    }
}