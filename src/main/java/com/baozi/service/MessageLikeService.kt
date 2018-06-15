package com.baozi.service

import com.baozi.po.SOMessageLike


/**
 * @author zhangwenjun
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