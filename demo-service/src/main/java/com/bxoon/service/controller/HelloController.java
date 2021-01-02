package com.bxoon.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2020/12/31 16:42
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("helloWorld")
    public String helloWord() {
        return "HelloWorld";
    }
}
