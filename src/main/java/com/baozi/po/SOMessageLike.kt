package com.baozi.po

import java.io.Serializable

class SOMessageLike : Serializable {
    /**自增ID，没什么用 */
    var id: Long? = null
    /**message id，关联用 */
    var messageId: Long? = null
    /**点赞（顶） 用户id */
    var userId: Long? = null
    /**用户赞（顶）ip地址 */
    var ip: String? = null
}