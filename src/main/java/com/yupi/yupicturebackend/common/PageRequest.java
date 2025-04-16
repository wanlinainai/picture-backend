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
    private Long current = 1L;

    private Long pageSize = 10L;

    private String sortField;

    private String sortOrder = "descend";
}
