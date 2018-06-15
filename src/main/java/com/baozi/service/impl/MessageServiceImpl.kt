package com.baozi.service.impl

import com.baozi.mappers.SOMessageLikeMapper
import com.baozi.mappers.SOMessageMapper
import com.baozi.po.SOMessage
import com.baozi.po.SOMessageAuthor
import com.baozi.po.SOMessageLike
import com.baozi.service.MessageService
import com.baozi.util.LogUtils
import com.baozi.vo.ResultMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.HashMap


/**
 * @author zhangwenjun
 * @version 1.0<br/>
 *
 */
@Service
open class MessageServiceImpl @Autowired constructor(
        val  messageMapper: SOMessageMapper,
        val  messageLikeMapper: SOMessageLikeMapper
        ) : MessageService {
    //类变量
    companion object {
        val MESSAGE_KEY = "message_key:%s:%s"
        val MESSAGE_KEY_USER = "message_key:%s:%s:uid[%s]"
        //用于控制并发，之前是缓存，直接改造成这样。
        val cacheMap: MutableMap<String, Int> =  LinkedHashMap()

    }

    override fun deleteByPrimaryKey(id: Long?): Int
        = messageMapper.deleteByPrimaryKey(id)

    override fun insert(entity: SOMessage): Int
        = messageMapper.insert(entity)
    override fun insertSelective(entity: SOMessage): Int{

        val result = messageMapper.insertSelective(entity)
        //更新父-当前id节点串
        var pids = ""
        if (1 == entity.level) {
            pids = "," + entity.id + ","
        } else {
            pids = entity.pids + entity.id + ","
        }
        entity.pids = pids
        messageMapper.updateByPrimaryKeySelective(entity)
        return result
    }

    override fun selectByPrimaryKey(id: Long): SOMessage?
        = messageMapper.selectByPrimaryKey(id)

    override fun selectByMessageAndKey(entity: SOMessage): Long?
        = messageMapper.selectByMessageAndKey(entity)

    override fun updateByPrimaryKeySelective(entity: SOMessage): Int
        = messageMapper.updateByPrimaryKeySelective(entity)

    override fun updateByPrimaryKeyWithBLOBs(entity: SOMessage): Int
        = messageMapper.updateByPrimaryKeyWithBLOBs(entity)

    override fun updateByPrimaryKey(entity: SOMessage): Int
        = messageMapper.updateByPrimaryKey(entity)

    /**
     * 加载评论列表
     * @param resultMap
     * @param pageNo
     * @param pageSize
     * @return
     */
    override fun findMessageList(resultMap: MutableMap<String, Any>, pageNo: Int?, pageSize: Int?): ResultMessage {
        //没有获取到，就从数据库再次获取
        val message = ResultMessage()

        //获取用户信息 以前shiro的 Demo
        //TODO message.token = IUserManager.userToMap(TokenManager.getToken())

        message.token = resultMap["token"] as SOMessageAuthor
        resultMap.remove("token")

        //评论数据
        val list = messageMapper.findAll(resultMap)
        if (null == list || list.size == 0) {
            return message
        }

        //热门被顶上来的数据
        val hotData = findHot(resultMap["pkey"] as String, message.token!!.id, 3)
        message.data = list
        message.hotData = hotData

        //用户评论数
        val tips = messageMapper.selectUserTips(resultMap)
        val userTips = message.userTips
        for (u in tips) {
            userTips.put(u.authorId, u.count)
        }
        message.userTips = userTips

        return message
    }

    /**
     * 获取单条评论信息，根据ID，关联查询
     * @param id
     * @return
     */
    override fun findMessageById(id: Long?): ResultMessage {
        var message = messageMapper.findMessageById(id)
        //用户评论数
        val resultMap: MutableMap<String, Any>  = HashMap ()
        resultMap.put("pkey",message.pkey)
        val tips = messageMapper.selectUserTips(resultMap)
        val userTips = message.userTips
        for (u in tips) {
            userTips.put(u.authorId, u.count)
        }
        message.userTips = userTips

       return message
    }

    override fun findHot(pkey: String,userId:Long?, page: Int?): List<ResultMessage> {
        val resultMap = HashMap<String, Any>()
        resultMap.put("pkey", pkey)
        resultMap.put("page", page!!)
        resultMap.put("userId", userId!!)
        resultMap.put("orderMarker", "hotList")
        return messageMapper.findAll(resultMap)
    }

    override fun updateLike(entity: SOMessageLike, pkey: String): Map<String, Any> {
        val resultMap = HashMap<String, Any>()

        val key = String.format(MESSAGE_KEY, entity.messageId, entity.userId)
        //采用缓存的方式防止重复提交
        val v = cacheMap.get(key)
        if (v != null) {
            resultMap.put("status", 500)
            resultMap.put("message", "您的操作太快了。")
            return resultMap
        }
        cacheMap.put(key,0)
        try {
            //先查询是否已经点赞
            val like = messageLikeMapper.findByMessageIdAndUserId(entity)
            val map: MutableMap<String, Any> = LinkedHashMap()
            map.put("id", entity.messageId!!)
            map.put("userId", entity.userId!!)
            map.put("maker", if (null != like) -1 else 1) //存在-1，不存在+1
            if (null != like) {
                messageLikeMapper.deleteByPrimaryKey(like.id)
            } else {
                messageLikeMapper.insert(entity)//添加记录
            }
            messageMapper.updateLike(map)//更新消息的关注数
            val likes = messageMapper.selectLikesByPrimaryKey(entity.messageId)
            resultMap.put("status", 200)
            resultMap.put("likes", likes)
            resultMap.put("marker", null == like)//取反显示是否已经顶过这条评论了
        } catch (e: Exception) {
            val a = arrayOf(entity.messageId, entity.userId)  as Array<Any>
            LogUtils.logError("点赞出现异常",e)
        } finally {
            cacheMap.remove(key)
        }
        return resultMap
    }

    /**
     * 根据UserId 和 Authorid 查询
     * @param entity
     * @return
     */
    override fun selectByIdAndAuthorId(entity: SOMessage): SOMessage? {
        return messageMapper.selectByIdAndAuthorId(entity)
    }

    /**
     * 根据层级删除
     * @param pids
     * @return
     */
    override fun deleteByPids(pids: String, pkey: String): Int
        = messageMapper.deleteByPids(pids)
}