//package com.bxoon.service.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
// * @author ：GuangxiZhong
// * @date ：Created in 2021/1/2 16:23
// * @description：公共入口拦截器,基于注解
// * @modified By：
// * @version: 1.0
// */
//@Aspect
//@Component
//@Slf4j
//public class BaseInterceptorByAnnotations {
//
//    @Pointcut("@annotation(com.bxoon.service.annotation.TestAnnotation)")
//    public void pointCut() {
//    }
//
//    @Around(value = "pointCut()")
//    public Object arround(ProceedingJoinPoint pjp) {
//        try {
//            log.info("1、BaseInterceptorByAnnotations Around：方法环绕开始.....");
//
//            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            assert attributes != null;
//            HttpServletRequest request = attributes.getRequest();
//
//            // 记录下请求内容
//            log.info("BaseInterceptorByAnnotations URL : " + request.getRequestURI().substring(request.getContextPath().length()));
//            log.info("BaseInterceptorByAnnotations HTTP_METHOD : " + request.getMethod());
//            log.info("BaseInterceptorByAnnotations IP : " + request.getRemoteAddr());
//            log.info("BaseInterceptorByAnnotations CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
//            log.info("BaseInterceptorByAnnotations ARGS : " + Arrays.toString(pjp.getArgs()));
//
//            Object o =  pjp.proceed();
//            log.info("3、BaseInterceptorByAnnotations Around：方法环绕结束，结果是 :" + o);
//            return o;
//        } catch (Throwable e) {
//            log.error(pjp.getSignature() + " 出现异常： ", e);
//            return "异常";
//        }
//    }
//}
