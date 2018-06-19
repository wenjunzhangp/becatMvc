package com.baozi.service;

import com.baozi.po.ActiveUser;
import com.baozi.po.SysPermission;
import com.baozi.po.SysRole;
import com.baozi.po.SysUser;
import com.baozi.vo.*;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.session.Session;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 老笼包
 * @create 2017-06-16 10:44
 * @description 用户认证授权服务
 **/
public interface SystemService {

    /**
     * 根据用户账号密码做认证
     * @param userCode 账号
     * @param password 密码
     * @return 用户信息实体类
     */
    ActiveUser authenticat(String userCode,String password) throws Exception;

    /**
     * 登录授权的公共接口
     * @param userCode
     * @return
     * @throws Exception
     */
    SysUser findSysUserByUserCode(String userCode);

    /**
     * 根据用户Id查询所拥有的菜单
     * @param userId
     * @return
     * @throws Exception
     */
    List<SysPermission> findMenuListByUserId(int userId);

    /**
     * 根据用户Id查询用户所拥有的URL权限集合
     * @param userId
     * @return
     * @throws Exception
     */
    List<SysPermission> findPermissionListByUserId(int userId);

    /**
     * 根据用户Id查询用户所拥有的角色集合
     * @param userId
     * @return
     * @throws Exception
     */
    Set<String> findRolesListByUserId(int userId);

    /**
     * 根据用户ID查询所属权限
     * @param userId
     * @return
     */
    List<SysRole> findNowAllPermission(int userId);

    /**
     * 分页查询权限
     * @param paramMap
     * @return
     */
    PageInfo<SysPermissionVo> findSysPermissionPage(Map<String, Object> paramMap);

    /**
     * 批量删除权限
     * @param idList
     * @return
     */
    int deleteSysPermissionSingleOrBatch(List idList,ActiveUser activeUser, Session session);

    /**
     * 新增权限
     * @param sysPermission
     * @return
     */
    void insert(SysPermission sysPermission,ActiveUser activeUser, Session session);

    /**
     * 分页查询角色
     * @param paramMap
     * @return
     */
    PageInfo<SysRoleVo> findSysRolePage(Map<String, Object> paramMap);

    /**
     * 修改角色
     * @param sysRole
     * @return
     */
    void updateSysRole(SysRole sysRole,ActiveUser activeUser, Session session);

    /**
     * 新增角色
     * @param sysRole
     * @return
     */
    void insert(SysRole sysRole,ActiveUser activeUser, Session session);

    /**
     * 删除角色
     * @param id
     * @return
     */
    boolean deleteSysRole(int id,ActiveUser activeUser, Session session);

    /**
     * 角色分配列表
     * @param paramMap
     * @return
     */
    PageInfo<UserRoleAllocationVo> findUserRoleAllocationPage(Map<String, Object> paramMap);

    /**
     * 根据用户id查找角色 勾选
     * @param userId
     * @return
     */
    List<UserRoleVo> selectRoleByUserId(int userId);

    /**
     * 根据用户id  为用户赋予新角色
     * @param userId
     * @param ids
     */
    void addRoleToUser(int userId, String ids,ActiveUser activeUser,Session session);

    /**
     * 权限分配列表
     * @param paramMap
     * @return
     */
    PageInfo<RolePermissionAllocationVo> findRolePermissionAllocationPage(Map<String, Object> paramMap);

    /**
     * 根据角色id查找权限 勾选
     * @param permissionId
     * @return
     */
    List<RolePermissionVo> selectPermissionById(int permissionId);

    /**
     * 根据角色id  为角色赋予新权限
     * @param roleId
     * @param ids
     */
    void addPermissionToRole(int roleId, String ids,ActiveUser activeUser,Session session);
}
