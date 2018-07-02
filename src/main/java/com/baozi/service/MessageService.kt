package com.baozi.service

import com.baozi.po.SOMessage
import com.baozi.po.SOMessageLike
import com.baozi.vo.ResultMessage


/**
 * @author zhangwenjun
 * @version 1.0<br/>
 *
 */
open interface MessageService {

    open fun deleteByPrimaryKey(id: Long?): Int

    open fun insert(entity: SOMessage): Int

    open fun insertSelective(entity: SOMessage): Int

    open fun selectByPrimaryKey(id: Long): SOMessage?

    open fun selectByMessageAndKey(entity: SOMessage): Long?


    open fun updateByPrimaryKeySelective(entity: SOMessage): Int

    open fun updateByPrimaryKeyWithBLOBs(entity: SOMessage): Int

    open fun updateByPrimaryKey(entity: SOMessage): Int
    /**
     * 加载评论列表
     * @param resultMap
     * @param pageNo
     * @param pageSize
     * @return
     */
    open fun findMessageList(resultMap: MutableMap<String, Any>, pageNo: Int?, pageSize: Int?): ResultMessage

    /**
     * 获取单条评论信息，根据ID，关联查询
     * @param id
     * @return
     */
    open fun findMessageById(id: Long?): ResultMessage

    open fun findHot(pkey: String,userId:Long?, page: Int?): List<ResultMessage>

    open fun updateLike(entity: SOMessageLike, pkey: String): Map<String, Any>
    /**
     * 根据UserId 和 Authorid 查询
     * @param entity
     * @return
     */
    open fun selectByIdAndAuthorId(entity: SOMessage): SOMessage?

    /**
     * 根据层级删除
     * @param pids
     * @return
     */
    open fun deleteByPids(pids: String, pkey: String): Int
}