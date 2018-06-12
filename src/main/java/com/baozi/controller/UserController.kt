package com.baozi.controller

import com.baozi.config.MessageManager
import com.baozi.config.QQManager
import com.baozi.ex.subLogin
import com.baozi.ex.subLogout
import com.baozi.po.SOMessageAuthor
import com.baozi.service.MessageAuthorService
import com.baozi.service.MessageLikeService
import com.baozi.service.MessageService
import com.baozi.util.LogUtils
import com.baozi.util.VCache
import com.qq.connect.QQConnectException
import com.qq.connect.api.OpenID
import com.qq.connect.api.qzone.UserInfo
import com.qq.connect.oauth.Oauth
import org.apache.commons.lang.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.view.RedirectView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.collections.HashMap

/**
 *
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * ====
 * <p>
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2017年08月30日 23:38 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0<br/>
 *
 */
@Controller
@RequestMapping()
class UserController @Autowired constructor(
        //评论信息
        val  messageService: MessageService,
        //评论人信息
        val  messageAuthorService: MessageAuthorService,
        //点赞
        val  messageLikeService: MessageLikeService
        ) {

    /**
     * qq 登录后回调
     */
    @GetMapping(value = "login/qqcallback")
    @Throws(IOException::class, QQConnectException::class)
    fun qqloginback(request: HttpServletRequest, response: HttpServletResponse, state: String?, code: String?): ModelAndView? {

        /**
         * Callback url
         */
        var redirect: String? = "http://shuo.itboy.net/"


        /**获取token url */
        val redirect_url = QQManager.getAuth2URL(state, redirect, code)
        /**获取用户 token 信息  */
        //TODO  待改善
        val url = URL(redirect_url)
        val connection = url.openConnection() as HttpURLConnection
        val urlStream = connection.inputStream

        var totalString = " "
        BufferedReader(InputStreamReader(urlStream)).readLines().forEach {
            totalString += it
        }

        /**
         * 腾讯接口 code不能重用 ,当用户在刷新的时候,直接跳转到初始选择QQ界面
         */
        if (totalString.indexOf("code is reused error") != -1) {
            QQManager.qq(request, response, redirect)
            return null
        }
        connection.disconnect()

        LogUtils.logInfo("登录信息info"+totalString)

        /**获取返回值,解析返回串 */
        val prm = totalString.trim().split("&").dropLastWhile { it.isEmpty() }.toTypedArray()
        val pmMap = TreeMap<String, String>()
        for (pm in prm) {
            if (!StringUtils.isBlank(pm) && pm.indexOf("=") != -1) {
                val kv = pm.split("=").dropLastWhile { it.isEmpty() }.toTypedArray()
                if (kv.size == 2 && !StringUtils.isBlank(kv[0]) && !StringUtils.isBlank(kv[1])) {
                    pmMap.put(kv[0].trim(), kv[1].trim())
                }
            }
        }
        //授权令牌，Access_Token。
        val accessToken = pmMap["access_token"]
        //该access token的有效期，单位为秒。
        //long tokenExpireIn = new Long(pmMap.get("expires_in"));
        /**在授权自动续期步骤中，获取新的Access_Token时需要提供的参数。 */
        //String refreshToken = pmMap.get("refresh_token");

        var openId: String? = null

        try {
            val openIDObj = OpenID(accessToken)
            //openID 利用获取到的accessToken 去获取当前用的openid
            openId = openIDObj.userOpenID
        } catch (e: Exception) {

        }

        //重新跳转到登录界面.

        /**
         * 通过openid查询当前用户是否在本站登录过
         */
         var entity: SOMessageAuthor? = messageAuthorService.findByOpenId(openId!!)



        if (null == entity) {
            //# 腾讯并发限制
            VCache.setex(openId!!, "mark", 30)
            entity = SOMessageAuthor()
            var weiboUserInfo: com.qq.connect.api.weibo.UserInfo? = null
            var weiboUserInfoBean: com.qq.connect.javabeans.weibo.UserInfoBean? = null


            entity.openId = openId


            try {
                var qzoneUserInfo = UserInfo(accessToken, openId)
                var userInfoBean = qzoneUserInfo.userInfo



                weiboUserInfo = com.qq.connect.api.weibo.UserInfo(accessToken, openId)
                weiboUserInfoBean = weiboUserInfo.userInfo
                var nickname: String? = userInfoBean.nickname
                if (null == nickname) {
                    nickname = "请设置昵称"
                }
                //处理空格
                nickname = nickname.replace("([\\s])".toRegex(), "")

                /***
                 * 处理名称有特殊字符，主要是网址
                 */
                nickname = nickname.replace("(http(s)?://)?((([0-9a-zA-Z-]+)\\.)?([0-9a-zA-Z-]{1,10}\\.)([a-zA-Z]{2,8}))".toRegex(), "**")

                var email = weiboUserInfoBean!!.email
                var portrait = userInfoBean.avatar.avatarURL100
                portrait = portrait.replace("http:", "").replace("https:", "")
                var now = Date()
                //用户信息填充

                entity.createTime = now

                entity.email = (email)//email

                entity.nickname = nickname
                entity.avatarUrl = portrait
                entity.sucurity = MessageManager.getMD5(email + "#" + openId)
                //补全信息后，插入
                messageAuthorService.insert(entity)


            } catch (e: Exception) {
                LogUtils.logError("参数获取异常,暂时请忽略!!!",e )
            }finally {
                //释放
                VCache.delete(openId)
            }
        }
        //如果以前绑定过，直接登录
        request.subLogin(entity)
        return ModelAndView(RedirectView("/product.shtml"))
    }


    /**
     * 跳转到登录页面
     */
    @GetMapping(value = "login")
    fun login(request: HttpServletRequest): ModelAndView {
        var url = Oauth().getAuthorizeURL(request)
        return ModelAndView(RedirectView(url))
    }


    /**
     * 退出登录
     */
    @GetMapping(value = "logout")
    @ResponseBody
    fun logout(request: HttpServletRequest) : MutableMap<String, Any> {
        //退出
        request.subLogout()
        var result : MutableMap<String,Any> = HashMap()
        result.put("status",200)
        return result
    }
}