package com.baozi.mappers

import com.baozi.po.SoMessage
import com.baozi.vo.ResultMessage
import com.baozi.vo.UserTips


/**
 * @author zhangwenjun
 * @version 1.0<br/>
 *
 */
open  interface SOMessageMapper {
    fun deleteByPrimaryKey(id: Long?): Int

    fun insert(record: SoMessage): Int

    fun insertSelective(record: SoMessage): Int

    fun selectByPrimaryKey(id: Long?): SoMessage

    fun updateByPrimaryKeySelective(record: SoMessage): Int

    fun updateByPrimaryKeyWithBLOBs(record: SoMessage): Int

    fun updateByPrimaryKey(record: SoMessage): Int

    fun findAll(resultMap: Map<String, Any>): List<ResultMessage>

    fun findHot(resultMap: Map<String, Any>): List<ResultMessage>

    fun updateLike(map: Map<String, Any>): Int

    fun selectLikesByPrimaryKey(id: Long?): Int

    fun selectByMessageAndKey(entity: SoMessage): Long?

    fun findMessageById(id: Long?): ResultMessage

    fun selectByIdAndAuthorId(entity: SoMessage): SoMessage

    fun deleteByPids(pids: String): Int

    fun selectUserTips(resultMap: Map<String, Any>): List<UserTips>
}