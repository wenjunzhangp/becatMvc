package com.baozi.service.impl

import com.baozi.mappers.SOMessageAuthorMapper
import com.baozi.po.SOMessageAuthor
import com.baozi.service.MessageAuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * ====
 * <p>
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2017年08月20日 23:33 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0<br/>
 *
 */
@Service
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