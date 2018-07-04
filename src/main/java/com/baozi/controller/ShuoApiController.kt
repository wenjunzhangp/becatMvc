package com.baozi.controller

import com.baozi.config.MessageManager
import com.baozi.ex.ip
import com.baozi.ex.token
import com.baozi.po.SOMessage
import com.baozi.po.SOMessageLike
import com.baozi.service.MessageAuthorService
import com.baozi.service.MessageLikeService
import com.baozi.service.MessageService
import com.baozi.statics.Constant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import org.apache.commons.lang.StringUtils
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*


@RestController
@RequestMapping(value = "message")
open class ShuoApiController @Autowired constructor(
        //评论信息
        val  messageService: MessageService,
        //评论人信息
        val  messageAuthorService: MessageAuthorService,
        //点赞
        val  messageLikeService: MessageLikeService

                                    ) {

    /**
     * 点赞，取消赞
     * @param id        messageId，被点赞的MessageID
     * @param pkey    评论页面的Key
     * @param request
     * @return
     */
    @RequestMapping(value = "like", method = arrayOf(RequestMethod.POST))
    fun like(id: Long?, pkey: String, request: HttpServletRequest): Map<String, Any>? {

        val entity = SOMessageLike()
        entity.messageId = id
        entity.userId = request.token().id
        entity.ip = request.ip()
        return messageService.updateLike(entity, pkey)

    }

    /**
     * 删除评论
     * @param entity
     * @return
     */
    @RequestMapping(value = "deleteMessage", method = arrayOf(RequestMethod.POST))
    fun deleteMessage(request: HttpServletRequest, entity: SOMessage?): Map<String, Any>? {
        var resultMap = LinkedHashMap<String,Any>()
        //entity = messageService.selectByIdAndAuthorId(entity);
        var entityx = messageService.selectByPrimaryKey(entity!!.id as Long)
        if (null == entityx) {
            resultMap.put("message", "要删除的内容不存在。")
            resultMap.put("status", 404)
            return resultMap
        }
        //判断是自己的数据，或者是站长id为1
        val uid = request.token().id!!
        if ( uid != entityx.authorId) {
            resultMap.put("message", "您不能删除这条数据。")
            resultMap.put("status", 403)
            return resultMap
        }
        val count = messageService.deleteByPids(entityx.pids!!, entityx.pkey!!)
        resultMap.put("status", 200)
        resultMap.put("count", count)
        return resultMap
    }

    /**
     * 加载评论
     * @param key
     * @return
     */
    @RequestMapping(value = "loadMessage", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun loadMessage(key: String, orderMarker: String?, request: HttpServletRequest): Map<String, Any>? {
        var resultMap = LinkedHashMap<String,Any>()
        resultMap.put("pkey", key)
        resultMap.put("orderMarker", if (StringUtils.isBlank(orderMarker)) "desc" else orderMarker!!)
        resultMap.put("userId", request.token().id!!)

        resultMap.put("token",request.token())

        val message = messageService.findMessageList(resultMap, 1, 100)

        resultMap.put("message", message)
        return resultMap
    }

    /**
     * 添加|回复 message
     * @param entity
     * @return
     */
    @RequestMapping(value = "pushMessage", method = arrayOf(RequestMethod.POST))
    fun pushMessage(request: HttpServletRequest, entity: SOMessage): Map<String, Any>? {
        var resultMap = LinkedHashMap<String,Any>()
        //各种校验
        val result = MessageManager.checkPullMessage(request, entity)
        if (result.isOk) {
            val pid = entity.parentId
            if (!Constant.ZERO.equals(pid)) {
                val pentity = messageService.selectByPrimaryKey(pid as Long )
                if (null == pentity) {
                    resultMap.put("status", 404)
                    resultMap.put("message", "评论不存在，请刷新。")
                    return resultMap
                }
            }


            messageService.insertSelective(entity)
            resultMap.put("status", 200)
            val data = messageService.findMessageById(entity.id)
            resultMap.put("data", data)//回显
            return resultMap
        }
        return result.map()
    }
}



