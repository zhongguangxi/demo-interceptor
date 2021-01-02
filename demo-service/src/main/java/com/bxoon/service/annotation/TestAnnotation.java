package com.bxoon.service.annotation;

import java.lang.annotation.*;

/**
 * @description：测试注解
 * @author zhongguangxi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface TestAnnotation {

}
