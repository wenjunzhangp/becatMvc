package com.baozi.vo;

import com.baozi.po.SysPermission;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * 权限选择
 * @author 包子
 */
public class RolePermissionVo extends SysPermission {

	/**
	 * 是否勾选
	 */
	private String marker;
	/**
	 * role Id
	 */
	private String roleId;

	public boolean isCheck(){
		return StringUtils.equals(roleId,marker);
	}
	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
