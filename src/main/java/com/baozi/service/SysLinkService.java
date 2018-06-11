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
    PageInfo<SysLinkVo> findSysLinkPage (Map<String,Object> paramMap);

    /**
     * 批量删除友链
     * @param idList
     * @return
     */
    int deleteSysLinkSingleOrBatch(List idList);

    /**
     * 启动或者禁用友链
     * @param id
     * @param status
     * @return
     */
    int updateSysLinkStatus(int id,int status);

    /**
     * 修改友链
     * @param sysLink
     * @return
     */
    int updateSysLink(SysLink sysLink);

    /**
     * 新增友链
     * @param sysLink
     * @return
     */
    int insert(SysLink sysLink);

    /**
     * 根据友链展示位置查询友链
     */
    List<SysLinkVo> findSysLinkByLimitAndPosition(int position);
}
