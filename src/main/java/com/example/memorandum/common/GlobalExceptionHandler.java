package com.example.memorandum.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * 统一处理程序中出现的异常，返回统一的错误格式
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有未捕获的Exception异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        // 打印异常信息，方便调试
        e.printStackTrace();
        return Result.error("服务器内部错误：" + e.getMessage());
    }
}
