package com.baozi.mappers

import com.baozi.po.SOMessage
import com.baozi.vo.ResultMessage
import com.baozi.vo.UserTips


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
open  interface SOMessageMapper {
    fun deleteByPrimaryKey(id: Long?): Int

    fun insert(record: SOMessage): Int

    fun insertSelective(record: SOMessage): Int

    fun selectByPrimaryKey(id: Long?): SOMessage

    fun updateByPrimaryKeySelective(record: SOMessage): Int

    fun updateByPrimaryKeyWithBLOBs(record: SOMessage): Int

    fun updateByPrimaryKey(record: SOMessage): Int

    fun findAll(resultMap: Map<String, Any>): List<ResultMessage>

    fun findHot(resultMap: Map<String, Any>): List<ResultMessage>

    fun updateLike(map: Map<String, Any>): Int

    fun selectLikesByPrimaryKey(id: Long?): Int

    fun selectByMessageAndKey(entity: SOMessage): Long?

    fun findMessageById(id: Long?): ResultMessage

    fun selectByIdAndAuthorId(entity: SOMessage): SOMessage

    fun deleteByPids(pids: String): Int

    fun selectUserTips(resultMap: Map<String, Any>): List<UserTips>
}