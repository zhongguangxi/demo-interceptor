package com.bxoon.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2021/1/2 16:07
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Accessors(chain = true)
public class UserDto {

    @NotBlank(message = "用户姓名不能为空")
    private String name;
    @Max(message = "年龄最大值为150", value = 150)
    private Integer age;
    @Past(message = "出生时间不能大于当前时间")
    private Date birthDay;
    @Max(message = "身高最高为250cm", value = 250)
    private BigDecimal height;
}
