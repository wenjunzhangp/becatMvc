package com.baozi.mappers

import com.baozi.po.SOMessageLike


/**
 * @author 张文君
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