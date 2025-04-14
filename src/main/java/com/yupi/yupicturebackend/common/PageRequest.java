package com.yupi.yupicturebackend.common;

import lombok.Data;

/**
 * @ClassName: PageRequest
 * @Author: zxh
 * @Date: 2025/4/14 00:31
 * @Description:
 */
@Data
public class PageRequest {
    private int current = 1;

    private int pageSize = 10;

    private String sortField;

    private String sortOrder = "descend";
}
