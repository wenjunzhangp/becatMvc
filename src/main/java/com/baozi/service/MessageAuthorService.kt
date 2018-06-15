package com.baozi.service

import com.baozi.po.SOMessageAuthor


/**
 * @author zhangwenjun
 * @version 1.0<br/>
 *
 */
open interface MessageAuthorService {
     fun deleteByPrimaryKey(id: Long?): Int

     fun insert(entity: SOMessageAuthor): Int

     fun insertSelective(entity: SOMessageAuthor): Int

     fun selectByPrimaryKey(id: Long?): SOMessageAuthor

     fun updateByPrimaryKeySelective(entity: SOMessageAuthor): Int

     fun updateByPrimaryKey(entity: SOMessageAuthor): Int
     fun selectByNickname(nickname: String): Long?

     fun findAll(): List<SOMessageAuthor>

     fun findByOpenId(openId: String): SOMessageAuthor?
}