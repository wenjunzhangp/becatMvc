package com.baozi.vo;

/**
 * 权限分配 查询列表Vo
 * @author 包子
 */
public class RolePermissionAllocationVo {
	//角色ID
	private int id;
	//角色Name
	private String name;
	//权限Name列转行，以,分割
	private String permissionNames;
	//权限Id列转行，以‘,’分割
	private String permissionIds;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermissionNames() {
		return permissionNames;
	}

	public void setPermissionNames(String permissionNames) {
		this.permissionNames = permissionNames;
	}

	public String getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}
}
