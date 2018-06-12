package com.baozi.service

import com.baozi.po.SOMessage
import com.baozi.po.SOMessageLike
import com.baozi.vo.ResultMessage


/**
 *
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * ====
 * <p>
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2017年08月20日 23:31 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0<br/>
 *
 */
open interface MessageService {

    fun deleteByPrimaryKey(id: Long?): Int

    fun insert(entity: SOMessage): Int

    fun insertSelective(entity: SOMessage): Int

    fun selectByPrimaryKey(id: Long): SOMessage?

    fun selectByMessageAndKey(entity: SOMessage): Long?


    fun updateByPrimaryKeySelective(entity: SOMessage): Int

    fun updateByPrimaryKeyWithBLOBs(entity: SOMessage): Int

    fun updateByPrimaryKey(entity: SOMessage): Int
    /**
     * 加载评论列表
     * @param resultMap
     * @param pageNo
     * @param pageSize
     * @return
     */
    fun findMessageList(resultMap: MutableMap<String, Any>, pageNo: Int?, pageSize: Int?): ResultMessage

    /**
     * 获取单条评论信息，根据ID，关联查询
     * @param id
     * @return
     */
    fun findMessageById(id: Long?): ResultMessage

    fun findHot(pkey: String,userId:Long?, page: Int?): List<ResultMessage>

    fun updateLike(entity: SOMessageLike, pkey: String): Map<String, Any>
    /**
     * 根据UserId 和 Authorid 查询
     * @param entity
     * @return
     */
    fun selectByIdAndAuthorId(entity: SOMessage): SOMessage?

    /**
     * 根据层级删除
     * @param pids
     * @return
     */
    fun deleteByPids(pids: String, pkey: String): Int
}