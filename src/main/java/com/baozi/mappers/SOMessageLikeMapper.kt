package com.baozi.mappers

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
 * 创建　周柏成　2017年09月18日 22:18 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0<br/>
 *
 */
open interface SOMessageLikeMapper {
    fun deleteByPrimaryKey(id: Long?): Int

    fun insert(record: SOMessageLike): Int

    fun insertSelective(record: SOMessageLike): Int

    fun selectByPrimaryKey(id: Long?): SOMessageLike

    fun updateByPrimaryKeySelective(record: SOMessageLike): Int

    fun updateByPrimaryKey(record: SOMessageLike): Int

    fun findByMessageIdAndUserId(entity: SOMessageLike): SOMessageLike
}