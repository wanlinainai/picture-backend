package com.yupi.yupicturebackend.model.dto.space.analyze;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: SpaceAnalyzeRequest
 * @Author: zxh
 * @Date: 2025/5/19 23:41
 * @Description: 图片请求封装类
 */
@Data
public class SpaceAnalyzeRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 空间id
     */
    private Long spaceId;

    /**
     * 是否查询公共图库
     */
    private boolean queryPublic;

    /**
     * 全空间分析
     */
    private boolean queryAll;
}
