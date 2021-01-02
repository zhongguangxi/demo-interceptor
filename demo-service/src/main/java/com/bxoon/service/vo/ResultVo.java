package com.bxoon.service.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2021/1/2 16:18
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Accessors(chain = true)
public class ResultVo<T> {
    private String code;
    private String msg;
    private T date;

    public static ResultVo success(){
        return new ResultVo().setCode("0000").setMsg("成功");
    }

    public static ResultVo fail(){
        return new ResultVo().setCode("9999").setMsg("失败");
    }


}
