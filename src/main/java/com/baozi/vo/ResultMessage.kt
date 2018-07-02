package com.baozi.vo

import com.baozi.po.SOMessage
import com.baozi.po.SOMessageAuthor
import java.util.*


class ResultMessage : SOMessage() {

    /**评论的作者信息，需要考关联查询 */
    var author: SOMessageAuthor? = null

    var children: List<ResultMessage> = ArrayList()

    /***获取当前token信息 */
    var token:SOMessageAuthor?=null


    /**被顶起来的message */
    var hotData: List<ResultMessage> = ArrayList()
    /**评论数据 */
    var data: List<ResultMessage> = ArrayList()

    /**是否被关注 */
    var liked: Boolean = false
    /** 用户评论数  */
    var userTips: MutableMap<Long, Int> =  LinkedHashMap()



}