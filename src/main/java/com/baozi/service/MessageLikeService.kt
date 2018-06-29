package com.baozi.service

import com.baozi.po.SOMessageLike


/**
 * @author zhangwenjun
 * @version 1.0<br/>
 *
 */
open interface MessageLikeService {
    open abstract fun deleteByPrimaryKey(id: Long?): Int

    open abstract fun insert(record: SOMessageLike): Int

    open abstract fun insertSelective(record: SOMessageLike): Int

    open abstract fun selectByPrimaryKey(id: Long?): SOMessageLike

    open abstract fun updateByPrimaryKeySelective(record: SOMessageLike): Int

    open abstract fun updateByPrimaryKey(record: SOMessageLike): Int
}