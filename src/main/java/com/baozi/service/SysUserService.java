package com.baozi.service;

import java.util.Date;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 15:05
 * @description 用户相关的service
 **/
public interface SysUserService {

    /**
     * 查找平台用户数量
     * @return
     */
    public int findAllUserCount();

    /**
     * 根据用户ID查询用户最后登录时间
     * @param userId
     * @return
     */
    public Date findUserLastLoginTime(int userId);
}
