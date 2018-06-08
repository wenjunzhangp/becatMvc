package com.baozi.mappers;

import com.baozi.po.SysPermission;

import java.util.List;
import java.util.Set;


/**
 * 
 * <p>Title: SysPermissionMapperCustom</p>
 * <p>Description: 权限mapper</p>
 * <p>Company: www.itcast.com</p> 
 * @author	张文君
 * @date	2015-3-23下午2:55:28
 * @version 1.0
 */
public interface SysPermissionMapperCustom {
	
	//根据用户id查询菜单
	List<SysPermission> findMenuListByUserId(int userid);

	//根据用户id查询权限url
	List<SysPermission> findPermissionListByUserId(int userid);

	//根据用户Id查询用户所拥有的角色集合
	Set<String> findRolesListByUserId(int userid);

}
