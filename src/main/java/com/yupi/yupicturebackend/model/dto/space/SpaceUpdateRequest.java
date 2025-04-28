package com.yupi.yupicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: SpaceUpdateRequest
 * @Author: zxh
 * @Date: 2025/4/28 23:15
 * @Description: 空间更新请求
 */
@Data
public class SpaceUpdateRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String spaceName;

    private Integer spaceLevel;

    private Long maxSize;

    private Long maxCount;

}
