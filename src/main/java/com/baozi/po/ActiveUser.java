package com.baozi.po;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * 用户身份信息，存入session 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 * 
 * @author Thinkpad
 * 
 */
@Data
public class ActiveUser implements java.io.Serializable {
	//用户id（主键）
	private int userid;
	// 用户账号
	private String usercode;
	// 用户名称
	private String username;
	//角色
	private Set<String> roles;
	// 菜单
	private List<SysPermission> menus;
	// 权限
	private List<SysPermission> permissions;

}
