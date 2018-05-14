package com.baozi.vo;

import com.baozi.po.SysRole;
import com.baozi.util.StringUtil;

import java.io.Serializable;

public class UserRoleVo extends SysRole {
	/**
	 * 用户ID (用String， 考虑多个ID，现在只有一个ID)
	 */
	private String userId;
	/**
	 * 是否勾选
	 */
	private String marker;

	public boolean isCheck(){
		return StringUtil.equals(userId,marker);
	}
	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
