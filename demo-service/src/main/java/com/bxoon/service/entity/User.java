package com.bxoon.service.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2021/1/2 16:05
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Accessors(chain = true)
public class User {
    private String name;
    private Integer age;
    private Date birthDay;
    private BigDecimal height;
}
