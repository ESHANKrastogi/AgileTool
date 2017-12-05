package com.opensource.jiangbiao.agileTool.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Jiang Biao
 * @date 11/12/2017 11:02 PM
 */

public class SessionInterceptor implements HandlerInterceptor{

    /*在执行Controller的任务之前判断是否有Session信息
      如果有Session信息就往下执行，去调用Controller。
      如果没有Session就跳转到登录页面
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null){
            return true;
        }
        String url = "/login";
        request.getRequestDispatcher(url).forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
