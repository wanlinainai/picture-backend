package com.yupi.yupicturebackend.exception;

import lombok.Getter;

/**
 * @ClassName: BussinessException
 * @Author: zxh
 * @Date: 2025/4/14 00:09
 * @Description:
 */
@Getter
public class BussinessException extends RuntimeException {
    private final int code;

    public BussinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BussinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BussinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}
