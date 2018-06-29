package com.baozi.service

import com.baozi.po.SOMessageAuthor


/**
 * @author zhangwenjun
 * @version 1.0<br/>
 *
 */
open interface MessageAuthorService {
     open fun deleteByPrimaryKey(id: Long?): Int

     open fun insert(entity: SOMessageAuthor): Int

     open fun insertSelective(entity: SOMessageAuthor): Int

     open fun selectByPrimaryKey(id: Long?): SOMessageAuthor

     open fun updateByPrimaryKeySelective(entity: SOMessageAuthor): Int

     open fun updateByPrimaryKey(entity: SOMessageAuthor): Int
     open fun selectByNickname(nickname: String): Long?

     open fun findAll(): List<SOMessageAuthor>

     open fun findByOpenId(openId: String): SOMessageAuthor?
}