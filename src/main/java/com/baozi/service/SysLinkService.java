package com.baozi.service;

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
}
