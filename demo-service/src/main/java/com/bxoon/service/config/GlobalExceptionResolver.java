package com.bxoon.service.config;

import com.bxoon.service.exception.ParaValidationFailException;
import com.bxoon.service.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2021/1/2 17:12
 * @description：全局Controller层异常处理类
 * @modified By：
 * @version: 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionResolver {

    /**
     * 处理所有业务异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(ParaValidationFailException.class)
    @ResponseBody
    public ResultVo handleOpdRuntimeException(ParaValidationFailException e) {
        // 不打印异常堆栈信息
        log.error(e.getMessage());
        return ResultVo.fail().setCode(e.getCode()).setMsg(e.getMessage());
    }

    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo handleException(Exception e) {
        // 打印异常堆栈信息
        log.error(e.getMessage(), e);
        return ResultVo.fail().setMsg("系统错误");
    }
}
