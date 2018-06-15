package com.baozi.mappers

import com.baozi.po.SOMessageAuthor


/**
 * @author zhangwenjun
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