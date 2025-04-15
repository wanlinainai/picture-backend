package com.yupi.yupicturebackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserRegisterRequest
 * @Author: zxh
 * @Date: 2025/4/15 23:23
 * @Description: 用户登录请求
 */
@Data
public class UserLoginRequest implements Serializable {
    public static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;
}
