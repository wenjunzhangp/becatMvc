package com.baozi.service.impl;

import com.baozi.exception.CustomException;
import com.baozi.mappers.SysPermissionMapper;
import com.baozi.mappers.SysPermissionMapperCustom;
import com.baozi.mappers.SysRoleMapper;
import com.baozi.mappers.SysUserMapper;
import com.baozi.po.*;
import com.baozi.service.SystemService;
import com.baozi.util.MD5;
import com.baozi.vo.SysPermissionVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 老笼包
 * @create 2017-06-16 10:49
 * @description 一句话说明此类的作用
 **/
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPermissionMapperCustom sysPermissionMapperCustom;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public ActiveUser authenticat(String userCode, String password) throws Exception {
        SysUser user=this.findSysUserByUserCode(userCode);
        if(user==null){
            throw new CustomException("账号不存在");
        }
        //数据库的密码
        String pwd_db=user.getPassword();
        //将用户输入的密码加密进行比对
        String pwd_user=new MD5().getMD5ofStr(password);
        if(!pwd_db.equalsIgnoreCase(pwd_user)){
            throw new CustomException("账号或者密码错误");
        }
        //认证通过，可以将用户信息返回
        ActiveUser activeUser=new ActiveUser();
        activeUser.setUserid(user.getId());
        activeUser.setUsername(user.getUsername());
        activeUser.setUsercode(user.getUsercode());
        return activeUser;
    }

    @Override
    public SysUser findSysUserByUserCode(String userCode){
        SysUserExample sysUserExample=new SysUserExample();
        SysUserExample.Criteria criteria= sysUserExample.createCriteria();
        criteria.andUsercodeEqualTo(userCode);
        List<SysUser> user=sysUserMapper.selectByExample(sysUserExample);
        if(user.size()>0&&user!=null){
            return user.get(0);
        }
        return null;
    }

    @Override
    public List<SysPermission> findMenuListByUserId(int userId){
        return sysPermissionMapperCustom.findMenuListByUserId(userId);
    }

    @Override
    public List<SysPermission> findPermissionListByUserId(int userId){
        return sysPermissionMapperCustom.findPermissionListByUserId(userId);
    }

    @Override
    public Set<String> findRolesListByUserId(int userId) {
        return sysPermissionMapperCustom.findRolesListByUserId(userId);
    }

    @Override
    public List<SysRole> findNowAllPermission(int userId) {
        return sysRoleMapper.findNowAllPermission(userId);
    }

    @Override
    public PageInfo<SysPermissionVo> findSysPermissionPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<SysPermissionVo> dataList = sysPermissionMapper.findSysPermissionPage(paramMap);
        return new PageInfo<SysPermissionVo>(dataList);
    }

    @Override
    public int deleteSysPermissionSingleOrBatch(List idList) {
        return sysPermissionMapper.deleteSysPermissionSingleOrBatch(idList);
    }

    @Override
    public int updateSysPermission(SysPermission sysPermission) {
        return sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
    }

    @Override
    public int insert(SysPermission sysPermission) {
        return sysPermissionMapper.insertSelective(sysPermission);
    }

}
