package com.baozi.service;

import com.baozi.po.ActiveUser;
import com.baozi.po.SysPermission;
import com.baozi.po.SysRole;
import com.baozi.po.SysUser;
import com.baozi.vo.SysPermissionVo;
import com.baozi.vo.SysRoleVo;
import com.baozi.vo.UserRoleAllocationVo;
import com.baozi.vo.UserRoleVo;
import com.github.pagehelper.PageInfo;

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
    public ActiveUser authenticat(String userCode,String password) throws Exception;

    /**
     * 登录授权的公共接口
     * @param userCode
     * @return
     * @throws Exception
     */
    public SysUser findSysUserByUserCode(String userCode);

    /**
     * 根据用户Id查询所拥有的菜单
     * @param userId
     * @return
     * @throws Exception
     */
    public List<SysPermission> findMenuListByUserId(int userId);

    /**
     * 根据用户Id查询用户所拥有的URL权限集合
     * @param userId
     * @return
     * @throws Exception
     */
    public List<SysPermission> findPermissionListByUserId(int userId);

    /**
     * 根据用户Id查询用户所拥有的角色集合
     * @param userId
     * @return
     * @throws Exception
     */
    public Set<String> findRolesListByUserId(int userId);

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
    public PageInfo<SysPermissionVo> findSysPermissionPage(Map<String, Object> paramMap);

    /**
     * 批量删除权限
     * @param idList
     * @return
     */
    public int deleteSysPermissionSingleOrBatch(List idList);

    /**
     * 新增权限
     * @param sysPermission
     * @return
     */
    public void insert(SysPermission sysPermission);

    /**
     * 分页查询角色
     * @param paramMap
     * @return
     */
    public PageInfo<SysRoleVo> findSysRolePage(Map<String, Object> paramMap);

    /**
     * 修改角色
     * @param sysRole
     * @return
     */
    public void updateSysRole(SysRole sysRole);

    /**
     * 新增角色
     * @param sysRole
     * @return
     */
    public void insert(SysRole sysRole);

    /**
     * 删除角色
     * @param id
     * @return
     */
    public boolean deleteSysRole(int id);

    /**
     * 角色分配列表
     * @param paramMap
     * @return
     */
    public PageInfo<UserRoleAllocationVo> findUserRoleAllocationPage(Map<String, Object> paramMap);

    /**
     * 根据用户id查找角色 勾选
     * @param userId
     * @return
     */
    public List<UserRoleVo> selectRoleByUserId(int userId);
}
