package com.yupi.yupicturebackend.exception;

import com.yupi.yupicturebackend.common.BaseResponse;
import com.yupi.yupicturebackend.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalExceptionHandler
 * @Author: zxh
 * @Date: 2025/4/14 00:25
 * @Description: 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * BussinessException 异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(BussinessException.class)
    public BaseResponse<?> businessExceptionHandler(BussinessException e) {
        log.error("businessExceptionHandler", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    public BaseResponse<?> exceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }
}
