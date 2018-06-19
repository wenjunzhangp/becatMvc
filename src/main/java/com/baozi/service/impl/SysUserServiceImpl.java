package com.baozi.service.impl;

import com.baozi.mappers.SysLogMapper;
import com.baozi.mappers.SysUserMapper;
import com.baozi.mappers.UserLogMapper;
import com.baozi.po.ActiveUser;
import com.baozi.po.SysUser;
import com.baozi.po.SysUserExample;
import com.baozi.service.SysUserService;
import com.baozi.util.GenerateLogFactory;
import com.baozi.util.MD5Factory;
import com.baozi.vo.SysUserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 15:07
 * @description 用户相关的逻辑类处理
 **/
@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private UserLogMapper userLogMapper;

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int findAllUserCount() {
        SysUserExample sysUserExample=new SysUserExample();
        return sysUserMapper.countByExample(sysUserExample);
    }

    @Override
    public Date findUserLastLoginTime(int userId) {
        return sysUserMapper.findUserLastLoginTime(userId);
    }

    @Override
    public SysUser findSysUserByUserId(int userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUserInfo(SysUser sysUser,ActiveUser activeUser,Session session) {
        userLogMapper.insertSelective(GenerateLogFactory.buildUserLogCurrency(activeUser,"修改个人资料",(short) 0,activeUser.getUsername()+"修改个人资料",session.getHost()));
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int updateUserPwd(int userId, String newpwd,ActiveUser activeUser,Session session) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        String newPassWord = MD5Factory.genPassWordWithUserSalt(newpwd,sysUser.getSalt(),1);
        sysUser.setPassword(newPassWord);
        userLogMapper.insertSelective(GenerateLogFactory.buildUserLogCurrency(activeUser,"【敏感操作修改密码】",(short) 0,activeUser.getUsername()+"【敏感操作修改密码】",session.getHost()));
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public PageInfo<SysUserVo> findSysUserPage(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<SysUserVo> dataList = sysUserMapper.findSysUserPage(paramMap);
        return new PageInfo<SysUserVo>(dataList);
    }

    @Override
    public void updateSysUserLock(String usercode, String lock,ActiveUser activeUser,Session session) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("locked",lock);
        paramMap.put("usercode",usercode);
        String str = lock.equals("0")?"解锁成功":"已锁定登录";
        sysLogMapper.insertSelective(GenerateLogFactory.buildSysLogCurrency(activeUser,"用户"+activeUser.getUsername()+str,(short) 0,activeUser.getUsername()+str+activeUser.getUsercode(),session.getHost()));
        sysUserMapper.updateSysUserLock(paramMap);
    }

}
