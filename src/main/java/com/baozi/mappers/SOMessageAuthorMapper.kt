package com.baozi.mappers

import com.baozi.po.SOMessageAuthor


/**
 *
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * ====
 * <p>
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2017年09月18日 22:17 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0<br/>
 *
 */
open interface SOMessageAuthorMapper {
    fun deleteByPrimaryKey(id: Long?): Int

    fun insert(record: SOMessageAuthor): Int

    fun insertSelective(record: SOMessageAuthor): Int

    fun selectByPrimaryKey(id: Long?): SOMessageAuthor

    fun updateByPrimaryKeySelective(record: SOMessageAuthor): Int

    fun updateByPrimaryKey(record: SOMessageAuthor): Int

    fun selectByNickname(nickname: String): Long?

    fun findAll(): List<SOMessageAuthor>

    fun findByOpenId(openId: String): SOMessageAuthor
}