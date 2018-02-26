package com.baozi.filter;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wenjun.zhang
 * @create 2018-02-24 10:57
 * @description 用户退出的过滤器
 **/
public class CustomLogoutFilter extends LogoutFilter {
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        //在这里执行退出系统前需要清空的数据
        Subject subject=getSubject(request,response);
        String redirectUrl=getRedirectUrl(request,response,subject);
        try {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse rep = (HttpServletResponse)response;
            Cookie[] cookies = req.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().contains("JSESSIONID")) {
                    String cookieName = cookie.getName();
                    Cookie newCookie = new Cookie(cookieName, null);
                    newCookie.setPath("/");
                    rep.addCookie(newCookie);
                }
            }
            subject.logout();
        }catch (SessionException e){
            e.printStackTrace();
        }
        issueRedirect(request,response,redirectUrl);
        return false;
    }
}
