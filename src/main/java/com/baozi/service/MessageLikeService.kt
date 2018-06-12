package com.baozi.service

import com.baozi.po.SOMessageLike


/**
 *
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * ====
 * <p>
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2017年08月20日 23:31 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0<br/>
 *
 */
open interface MessageLikeService {
    abstract fun deleteByPrimaryKey(id: Long?): Int

    abstract fun insert(record: SOMessageLike): Int

    abstract fun insertSelective(record: SOMessageLike): Int

    abstract fun selectByPrimaryKey(id: Long?): SOMessageLike

    abstract fun updateByPrimaryKeySelective(record: SOMessageLike): Int

    abstract fun updateByPrimaryKey(record: SOMessageLike): Int
}