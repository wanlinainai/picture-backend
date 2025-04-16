package com.yupi.yupicturebackend.model.dto.user;

import com.yupi.yupicturebackend.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserQueryRequest
 * @Author: zxh
 * @Date: 2025/4/16 20:48
 * @Description:
 */
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    private Long id;

    private String userName;

    private String userAccount;

    private String userProfile;

    private String userRole;

    private static final long serialVersionUID = 1L;
}
