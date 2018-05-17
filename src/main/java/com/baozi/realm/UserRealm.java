package com.baozi.realm;


import com.baozi.po.ActiveUser;
import com.baozi.po.SysPermission;
import com.baozi.po.SysUser;
import com.baozi.service.SystemService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SystemService systemService;

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // token是用户输入的用户名和密码
        // 第一步从token中取出用户名
        String userCode = (String) authenticationToken.getPrincipal();
        // 第二步：根据用户输入的userCode从数据库查询
        SysUser sysUser = null;
        try {
            sysUser = systemService.findSysUserByUserCode(userCode);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        //账号不存在
        if ( null == sysUser ){
            throw new UnknownAccountException();
        }
        //账号被限制登录
        if ( sysUser.getLocked().equals("1") ){
            throw new LockedAccountException();
        }
        // 从数据库查询到密码
        String password = sysUser.getPassword();
        //盐
        String salt = sysUser.getSalt();
        //activeUser就是用户身份信息
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserid(sysUser.getId());
        activeUser.setUsercode(sysUser.getUsercode());
        activeUser.setUsername(sysUser.getUsername());
        //根据用户id取出菜单
        List<SysPermission> menus  = null;
        try {
            //通过service取出菜单
            menus = systemService.findMenuListByUserId(sysUser.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将用户菜单 设置到activeUser
        activeUser.setMenus(menus);
        //将activeUser设置simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                activeUser, password, ByteSource.Util.bytes(salt), this.getName());
        return simpleAuthenticationInfo;
    }

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
         //从 principals获取主身份信息
        //将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
        ActiveUser activeUser =  (ActiveUser) principalCollection.getPrimaryPrincipal();
        //根据身份信息获取权限信息
        List<SysPermission> permissionList = systemService.findPermissionListByUserId(activeUser.getUserid());
        List<String> permissions = new ArrayList<String>();
        if(permissionList!=null){
            for(SysPermission sysPermission:permissionList){
                //将数据库中的权限标签 符放入集合
                permissions.add(sysPermission.getPercode());
            }
        }
        //角色信息
        Set<String> roles = systemService.findRolesListByUserId(activeUser.getUserid());
        //查到权限数据，返回授权信息(要包括 上边的permissions)
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上边查询到授权信息填充到simpleAuthorizationInfo对象中
        simpleAuthorizationInfo.addStringPermissions(permissions);
        simpleAuthorizationInfo.addRoles(roles);
        //更新主体中的subject信息
        activeUser.setRoles(roles);
        activeUser.setPermissions(permissionList);
        return simpleAuthorizationInfo;
    }

    /**
     * 清空当前用户权限信息
     */
    public void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 指定principalCollection 清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

}
