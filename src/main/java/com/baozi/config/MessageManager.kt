package com.baozi.config

import com.baozi.ex.ip
import com.baozi.ex.token
import com.baozi.po.SOMessage
import com.baozi.util.LogUtils
import com.baozi.util.VCache
import org.apache.commons.lang.StringUtils
import java.io.Serializable
import java.security.MessageDigest
import java.util.*
import javax.servlet.http.HttpServletRequest

/**
 * @author zhangwenjun
 * @version 1.0<br/>
 *
 */

class MessageManager {
    companion object {
        /**
         * 校验提交的消息
         * @param request
         * @param entity
         * @return    {null:OK,!null:直接返回}
         */
        internal val OFTEN_CHECK = "often_check:ip[%s],uid[%s]"
        internal val OFTEN_CHECK_IP = "often_check:ip[%s]"
        internal val OFTEN_CHECK_USER = "often_check:uid[%s]"

        fun checkPullMessage(request: HttpServletRequest, entity: SOMessage): APIResult<SOMessage> {
            var m = 30

            val result = APIResult<SOMessage>()
            result.setStatus(500)//先标记不合法

            val ip = request.ip()//ip地址
            //先判断频繁度
            val token = request.token()



            /**提交时间判断

            val ckey = String.format(OFTEN_CHECK, ip, token.id)
            if (null != VCache.get(ckey)) {
                VCache.setex(ckey, 1, m)//30秒一次
                return result.setMessage("过于频繁提交，" + m + "秒后才能提交。[IDP]")
            }
            VCache.setex(ckey, 1, m)//30秒一次

            val ckeyIP = String.format(OFTEN_CHECK_IP, ip)
            if (null != VCache.get(ckeyIP)) {
                VCache.setex(ckey, 1, m)//30秒一次
                return result.setMessage("过于频繁提交，" + m + "秒后才能提交。[IP]")
            }
            VCache.setex(ckeyIP, 1, m)//30秒一次

            val ckeyUser = String.format(OFTEN_CHECK_USER, token.id)
            if (null != VCache.get(ckeyUser)) {
                VCache.setex(ckey, 1, m)//30秒一次
                return result.setMessage("过于频繁提交，" + m + "秒后才能提交。。[ID]")
            }
            VCache.setex(ckeyUser, 1, m)//30秒一次
             */

            /**提交时间判断 end */


            val message = entity.message//评论内容
            //判断是否还是含有尖括号，< >
            val checkMessage = message?.replace("<br/>".toRegex(), "")?.replace("<img(\\s+)?src=\"\\/\\/source.doudoucat.com\\/faceimg\\/([0-9]{1,3}).gif\"(\\s+)?border=\"0\"(\\s+)?/>".toRegex(), "")



            if (StringUtils.contains(checkMessage, "<") || StringUtils.contains(checkMessage, ">")) {
                return result.setMessage("内容有非法字符。")
            }


            val referer = request.getHeader("Referer")//来源
            val agent = request.getHeader("User-Agent")//浏览器特性
            val key = entity.pkey//评论key

            key ?: return result.setMessage("参数不合法：key")
            message ?: return result.setMessage("参数不合法：message")
            referer ?: return result.setMessage("参数不合法：referer")
            agent ?: return result.setMessage("参数不合法：agent")


            if (message.length > 2000) {
                return result.setMessage("Message too long")
            }

            entity.referer = (referer)
            entity.agent = (agent)
            entity.ip = (ip)
            entity.authorId = token.id
            entity.createdTime = Date()
            //返回状态及对象
            return result.setMessage("ok").setStatus(200).setResult(entity)

        }


        fun deleteCacheByPKey(pkey: String) {
            //更新完毕，释放缓存，再次加载更新缓存
            //		String dkey1 = String.format(MessageServiceImpl.MESSAGE_KEY,pkey,"desc");
            //		String dkey2 = String.format(MessageServiceImpl.MESSAGE_KEY,pkey,"asc");
            //		String dkey3 = String.format(MessageServiceImpl.MESSAGE_KEY,pkey,"hot");
            //		VCache.delByKey(dkey1,dkey2,dkey3);//删除三种形式排序的Message缓存
            //		直接用这种模糊匹配的方式删除，包括排序，包括用户。
            VCache.delete("message_key:$pkey*")//
        }

        /**
         * MD5
         */
        fun getMD5(str: String): String {
            var messageDigest: MessageDigest? = null
            try {
                messageDigest = MessageDigest.getInstance("MD5")
                messageDigest!!.reset()
                messageDigest.update(str.toByteArray(charset("UTF-8")))
            } catch (e: Exception) {
                LogUtils.logError("MD5转换异常",e)
            }

            val byteArray = messageDigest!!.digest()
            val md5StrBuff = StringBuffer()
            for (i in byteArray.indices) {
                if (Integer.toHexString(0xFF and byteArray[i].toInt()).length == 1)
                    md5StrBuff.append("0").append(
                            Integer.toHexString(0xFF and byteArray[i].toInt()))
                else
                    md5StrBuff.append(Integer.toHexString(0xFF and byteArray[i].toInt()))
            }
            return md5StrBuff.toString()
        }
    }
}

class APIResult<V> : Serializable {


    /**返回状态，
     * 处理中：100
     * 成功：200，
     * 失败：500，
     * 备用成功：300，(如重复提交，重复执行等，即可返回300，表示已经提交过了)
     * 其他具体情况自定义
     */
    private var status: Int = 0
    /**
     * 返回具体执行信息
     */
    private var message = ""
    /**
     * V V根据在new APIResult<V>的时候，如果V是存储一个User对象，那么就new APIResult<User>();
     * 可以达到不用强转，直接Get即可获取。
    </User></V> */
    private var result: V? = null

    constructor(status: Int) {
        this.status = status
    }

    constructor() : super() {}

    val isOk: Boolean
        get() = this.status == 200

    constructor(status: Int, message: String) {
        this.status = status
        this.message = message
    }

    fun getStatus(): Int {
        return status
    }

    fun setStatus(status: Int): APIResult<V> {
        this.status = status
        return this
    }

    fun getMessage(): String {
        return message
    }

    fun setMessage(message: String): APIResult<V> {
        this.message = message
        return this
    }

    fun get(): V? {
        return result
    }

    fun setResult(result: V): APIResult<V> {
        this.result = result
        return this
    }

    /**
     * 把状态直接返回 Map<String></String>,Object>
     * @return
     */
    fun map(): Map<String, Any> {
        val resultMap = LinkedHashMap<String, Any>()
        resultMap.put("status", status)
        resultMap.put("message", message)
        return resultMap
    }



}
