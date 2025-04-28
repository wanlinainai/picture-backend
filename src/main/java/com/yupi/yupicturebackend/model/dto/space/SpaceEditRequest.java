package com.yupi.yupicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: SpaceEditRequest
 * @Author: zxh
 * @Date: 2025/4/28 23:13
 * @Description: 编辑空间请求
 */
@Data
public class SpaceEditRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 空间id
     */
    private Long id;

    /**
     * 空间名称
     */
    private String spaceName;
}
