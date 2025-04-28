package com.yupi.yupicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: SpaceAddRequest
 * @Author: zxh
 * @Date: 2025/4/28 23:11
 * @Description: 创建空间请求
 */
@Data
public class SpaceAddRequest implements Serializable {
    /**
     * 空间名称
     */
    private String spaceName;

    /**
     * 空间级别:0 - 普通版， 1 - 专业版， 2 - 旗舰版
     */
    private Integer spaceLevel;

    private static final long serialVersionUID = 1L;
}
