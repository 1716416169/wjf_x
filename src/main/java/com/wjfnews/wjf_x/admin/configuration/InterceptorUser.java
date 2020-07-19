/*package com.wjfnews.wjf_x.admin.configuration;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class InterceptorUser implements HandlerInterceptor {

        //在这里可以拦截请求，false表示不再继续处理
        //controller以及postHandle方法，afterCompletion方法都不会执行
        //直接返回当前的response
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user==null) {
                System.out.println("请登录");
                try {
                    *//*request.getRequestDispatcher("/admin/login").forward(request,response);*//*
                    response.sendRedirect("/admin/login");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }else {
                return true;
            }
        }
}*/
