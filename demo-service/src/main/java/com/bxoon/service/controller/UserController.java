package com.bxoon.service.controller;

import com.bxoon.service.annotation.TestAnnotation;
import com.bxoon.service.dto.UserDto;
import com.bxoon.service.enums.ErrorEnum;
import com.bxoon.service.exception.ParaValidationFailException;
import com.bxoon.service.vo.ResultVo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2021/1/2 16:05
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("saveUser")
    public ResultVo saveUser(@RequestBody @Valid UserDto user, BindingResult bindingResult) {
        System.out.println(user);
        return ResultVo.success();
    }

    @RequestMapping("getUser")
    @TestAnnotation
    public ResultVo getUser() {
        UserDto userDto = new UserDto();
        userDto.setName("张三").setAge(12).setBirthDay(new Date()).setHeight(new BigDecimal("125.52"));
        try {
            System.out.println(10/0);
        }catch (Exception ex){
            throw new ParaValidationFailException(ErrorEnum.VALID_ERROR.getCode(),ErrorEnum.VALID_ERROR.getMessage());
        }

        return ResultVo.success().setDate(userDto);
    }

}
