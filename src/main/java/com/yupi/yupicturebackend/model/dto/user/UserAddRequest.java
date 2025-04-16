package com.yupi.yupicturebackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserAddRequest
 * @Author: zxh
 * @Date: 2025/4/16 20:45
 * @Description:
 */
@Data
public class UserAddRequest implements Serializable {
    private String userName;

    private String userAccount;

    private String userAvatar;

    private String userProfile;

    private String userRole;

    private static final long serialVersionUID = 5L;
}
