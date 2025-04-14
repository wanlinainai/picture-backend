package com.yupi.yupicturebackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: DeleteRequest
 * @Author: zxh
 * @Date: 2025/4/14 00:32
 * @Description: 通用的删除请求类
 */
@Data
public class DeleteRequest implements Serializable {

    private Long id;

    private static final long serialVersionUID = 1L;
}
