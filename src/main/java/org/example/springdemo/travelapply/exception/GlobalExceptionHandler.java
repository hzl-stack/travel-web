package org.example.springdemo.travelapply.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.example.springdemo.travelapply.result.Result;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * 自定义异常处理方法
     */
    @ExceptionHandler(TAException.class)
    @ResponseBody
    public Result error(TAException e) {
        return Result.build(e.getCode(), e.getMessage());
    }

}
