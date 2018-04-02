package com.baozi.util;

import com.baozi.po.ActiveUser;
import com.baozi.po.SysLog;
import com.baozi.po.UserLog;

import java.util.Date;

/**
 * @author wenjun.zhang
 * @create 2018-03-13 16:19
 * @description 系统日志生成工具类
 **/
public class GenerateLogFactory {

    /**
     * 系统日志生成bean
     * @param user 用户
     * @param operModule 操作模型（功能）
     * @param operType 操作类型
     * @param remark 备注
     * @param host 主机IP
     * @return
     */
    public static SysLog buildSysLogCurrency(ActiveUser user,String operModule,short operType,String remark,String host){
        SysLog sysLog = new SysLog();
        sysLog.setUserid(user.getUserid());
        sysLog.setUsername(user.getUsername());
        sysLog.setLogtype((short) 0);
        sysLog.setOpermodule(operModule);
        sysLog.setOpertype(operType);
        sysLog.setOpertime(new Date());
        sysLog.setRemark(remark);
        sysLog.setHost(host);
        return sysLog;
    }

    /**
     * 用户日志生成bean
     * @param user 用户
     * @param operModule 操作模型（功能）
     * @param operType 操作类型
     * @param remark 备注
     * @param host 主机IP
     * @return
     */
    public static UserLog buildUserLogCurrency(ActiveUser user, String operModule, short operType, String remark, String host){
        UserLog sysLog = new UserLog();
        sysLog.setUserid(user.getUserid());
        sysLog.setUsername(user.getUsername());
        sysLog.setLogtype((short) 0);
        sysLog.setOpermodule(operModule);
        sysLog.setOpertype(operType);
        sysLog.setOpertime(new Date());
        sysLog.setRemark(remark);
        sysLog.setHost(host);
        return sysLog;
    }
}
