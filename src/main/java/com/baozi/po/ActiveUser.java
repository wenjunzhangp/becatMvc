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
	private int userid;//用户id（主键）
	private String usercode;// 用户账号
	private String username;// 用户名称

	private Set<String> roles;//角色
	private List<SysPermission> menus;// 菜单
	private List<SysPermission> permissions;// 权限

}
