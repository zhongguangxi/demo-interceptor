package com.bxoon.service.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2020/12/31 16:47
 * @description：系统拦截器
 * @modified By：
 * @version: 1.0
 */
public class SystemInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("被拦截");
        return true;
    }
}
