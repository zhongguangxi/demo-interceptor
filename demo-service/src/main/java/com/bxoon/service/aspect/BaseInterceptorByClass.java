package com.bxoon.service.aspect;

import com.bxoon.service.exception.ParaValidationFailException;
import com.bxoon.service.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2021/1/2 15:57
 * @description：公共入口拦截器,基于类
 * @modified By：
 * @version: 1.0
 */
@Aspect
@Component
@Slf4j
public class BaseInterceptorByClass {
    /**
     * Pointcut 切入点
     * 匹配cn.controller包下面的所有方法
     */
    @Pointcut("execution(public * com.bxoon.service.controller.*.*(..))")
    public void pointCut(){}

    /**
     * 环绕通知
     */
    @Around(value = "pointCut()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            BindingResult bindingResult = null;
            for(Object arg:pjp.getArgs()){
                if(arg instanceof BindingResult){
                    bindingResult = (BindingResult) arg;
                }
            }
            if(bindingResult != null){
                List<ObjectError> errors = bindingResult.getAllErrors();
                if(errors.size()>0){
                    StringBuilder msg = new StringBuilder();
                    for(ObjectError error :errors){
                        msg.append(error.getDefaultMessage());
                        msg.append("\n");
                    }
                    if (msg.length()>0){
                        msg.deleteCharAt(msg.length()-1);
                    }
                    return ResultVo.fail().setMsg(msg.toString());
                }
            }

            log.info("1、Around：方法环绕开始.....");

            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert attributes != null;
            HttpServletRequest request = attributes.getRequest();

            // 记录下请求内容
            log.info("URL : " + request.getRequestURI().substring(request.getContextPath().length()));
            log.info("HTTP_METHOD : " + request.getMethod());
            log.info("IP : " + request.getRemoteAddr());
            log.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
            log.info("ARGS : " + Arrays.toString(pjp.getArgs()));

            Object o =  pjp.proceed();
            log.info("3、Around：方法环绕结束，结果是 :" + o);
            return o;
        }catch (Throwable e) {
           throw e;
        }
    }
}
