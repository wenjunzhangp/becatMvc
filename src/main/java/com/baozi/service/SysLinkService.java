package com.baozi.service;

import com.baozi.po.SysLink;
import com.baozi.vo.SysLinkVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface SysLinkService {

    /**
     * 分页查询友联数据
     * @param paramMap
     * @return
     */
    public PageInfo<SysLinkVo> findSysLinkPage (Map<String,Object> paramMap);

    /**
     * 批量删除友链
     * @param idList
     * @return
     */
    public int deleteSysLinkSingleOrBatch(List idList);

    /**
     * 启动或者禁用友链
     * @param id
     * @param status
     * @return
     */
    public int updateSysLinkStatus(int id,int status);

    /**
     * 修改友链
     * @param sysLink
     * @return
     */
    public int updateSysLink(SysLink sysLink);

    /**
     * 新增友链
     * @param sysLink
     * @return
     */
    public int insert(SysLink sysLink);
}
