package com.yupi.yupicturebackend.exception;

/**
 * @ClassName: ThrowUtils
 * @Author: zxh
 * @Date: 2025/4/14 00:13
 * @Description: 抛出异常工具类，类似于Assert
 */
public class ThrowUtils {
    public static void throwIf(boolean condition, ErrorCode errorCode, String message) {
        if (condition) {
            throw new BussinessException(errorCode, message);
        }
    }

    public static void throwIf(boolean condition, ErrorCode errorCode) {
        throwIf(condition, errorCode, null);
    }
}
