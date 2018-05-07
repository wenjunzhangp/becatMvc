package com.baozi.vo;

import com.baozi.po.SysUser;

public class UserRoleAllocationVo extends SysUser {

    //Role Name列转行，以,分割
    private String roleNames;
    //Role Id列转行，以‘,’分割
    private String roleIds;

    public String getRoleNames() {
        return roleNames;
    }
    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }
    public String getRoleIds() {
        return roleIds;
    }
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }
}
