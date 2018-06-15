package com.baozi.ex

import com.baozi.po.SOMessageAuthor
import com.baozi.util.LogUtils
import javax.servlet.http.HttpServletRequest

/**
 * @author 张文君
 * @version 1.0<br/>
 * qq互联登录扩展方法
 */
class RequstEx {}


/**
 * 几个拓展方法
 */
fun HttpServletRequest.token(): SOMessageAuthor {
    return this.getSession().getAttribute("token") as SOMessageAuthor
}
//判断是否登录
fun HttpServletRequest.isLogin(): Boolean {
    return this.getSession().getAttribute("token") != null
}
//提交登录
fun HttpServletRequest.subLogin(token: SOMessageAuthor){
    this.getSession().setAttribute("token",token)
}
//退出登录
fun HttpServletRequest.subLogout(){
    if(this.isLogin()){
        this.getSession().removeAttribute("token")
    }
}
fun HttpServletRequest.ip(): String? {
    var ip: String? = "IP获取异常。"
    try {
        ip = this.getHeader("x-forwarded-for")
        if (ip == null || ip!!.length == 0 || "unknown".equals(ip!!, ignoreCase = true)) {
            ip = this.getHeader("Proxy-Client-IP")
        }
        if (ip == null || ip!!.length == 0 || "unknown".equals(ip!!, ignoreCase = true)) {
            ip = this.getHeader("WL-Proxy-Client-IP")
        }
        if (ip == null || ip!!.length == 0 || "unknown".equals(ip!!, ignoreCase = true)) {
            ip = this.getRemoteAddr()
        }
    } catch (e: Exception) {
        LogUtils.logError("IP获取异常",e)
    }
    return ip
}