package com.baozi.service.impl

import com.baozi.mappers.SOMessageLikeMapper
import com.baozi.po.SOMessageLike
import com.baozi.service.MessageLikeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author zhangwenjun
 * @version 1.0<br/>
 */
@Service
open class MessageLikeServiceImpl @Autowired constructor(val  messageLikeMapper: SOMessageLikeMapper) : MessageLikeService {
    override fun insert(record: SOMessageLike): Int
        = messageLikeMapper.insert(record)

    override fun insertSelective(record: SOMessageLike): Int
        = messageLikeMapper.insertSelective(record)

    override fun selectByPrimaryKey(id: Long?): SOMessageLike
        = messageLikeMapper.selectByPrimaryKey(id)

    override fun updateByPrimaryKeySelective(record: SOMessageLike): Int
        = messageLikeMapper.updateByPrimaryKeySelective(record)

    override fun updateByPrimaryKey(record: SOMessageLike): Int
        = messageLikeMapper.updateByPrimaryKey(record)

    override fun deleteByPrimaryKey(id: Long?): Int
        =  messageLikeMapper.deleteByPrimaryKey(id)



}