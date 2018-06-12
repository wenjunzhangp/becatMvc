package com.baozi.interceptor

import com.baozi.ex.isLogin
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletResponse
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.view.RedirectView
import javax.servlet.http.HttpServletRequest


/**
 * @author wenjun.zhang
 * @create 2018-06-12 16:39
 * @description 登录拦截器
 **/

open class LoginInterceptor: HandlerInterceptor {

    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any?): Boolean {
        println(">>>LoginInterceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前）")
        return true//只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any?,
                            modelAndView: ModelAndView?) {
        if(!request.isLogin()){
             modelAndView?.view = RedirectView("/login.shtml")
        }
        println(">>>LoginInterceptor>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）")
    }

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any?, ex: Exception?) {
        println(">>>LoginInterceptor>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）")
    }
}