package com.baozi.service.impl

import com.baozi.mappers.SOMessageLikeMapper
import com.baozi.po.SOMessageLike
import com.baozi.service.MessageLikeService
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
 * 创建　周柏成　2017年08月20日 23:38 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0<br/>
 *
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