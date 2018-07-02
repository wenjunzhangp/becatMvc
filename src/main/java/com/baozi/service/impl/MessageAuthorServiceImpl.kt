package com.baozi.service.impl

import com.baozi.mappers.SOMessageAuthorMapper
import com.baozi.po.SOMessageAuthor
import com.baozi.service.MessageAuthorService
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author zhangwenjun
 * @version 1.0<br/>
 *
 */
open class MessageAuthorServiceImpl   @Autowired constructor(val  messageAuthorMapper: SOMessageAuthorMapper) : MessageAuthorService {
    override fun findByOpenId(openId: String): SOMessageAuthor? {
        return messageAuthorMapper.findByOpenId(openId)
    }

    override fun deleteByPrimaryKey(id: Long?): Int  = messageAuthorMapper.deleteByPrimaryKey(id)


    override fun insert(entity: SOMessageAuthor): Int = messageAuthorMapper.insert(entity)

    override fun insertSelective(entity: SOMessageAuthor): Int = messageAuthorMapper.insertSelective(entity)

    override fun selectByPrimaryKey(id: Long?): SOMessageAuthor  = messageAuthorMapper.selectByPrimaryKey(id)

    override fun updateByPrimaryKeySelective(entity: SOMessageAuthor): Int = messageAuthorMapper.updateByPrimaryKeySelective(entity)
    override fun updateByPrimaryKey(entity: SOMessageAuthor): Int  = messageAuthorMapper.updateByPrimaryKey(entity)

    override fun selectByNickname(nickname: String): Long?  = messageAuthorMapper.selectByNickname(nickname)

    override fun findAll(): List<SOMessageAuthor> = messageAuthorMapper.findAll()
}