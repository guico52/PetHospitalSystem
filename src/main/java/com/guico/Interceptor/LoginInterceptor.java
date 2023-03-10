package com.guico.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于登录检查的拦截器
 * @author guico
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("emp")==null){
            response.sendRedirect("/login");
            System.out.println("nest user");
            return false;
        }
        return true;
    }
}
