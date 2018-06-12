package com.baozi.po

import java.io.Serializable
import java.util.*


class SOMessageAuthor  : Serializable {
    /**评论人ID */
    var id: Long? = null
    /**第三方ID */
    var openId: String? = null
    /**第三方Type 备用，比如0代表腾讯，1代表微薄*/
    var openType: Int? = null
    /**头像 */
    var avatarUrl: String? = null
    /**跳转链接 */
    var url: String? = null
    /**用户nickname */
    var nickname: String? = null
    /**创建时间 */
    var createTime: Date? = null
    /**用户邮箱 */
    var email: String? = null
    /**用户安全码 */
    var sucurity: String? = null
}