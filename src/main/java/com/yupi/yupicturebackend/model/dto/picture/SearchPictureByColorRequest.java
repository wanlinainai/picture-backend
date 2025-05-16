package com.yupi.yupicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: SearchPictureByColorRequest
 * @Author: zxh
 * @Date: 2025/5/17 00:29
 * @Description: 按照颜色查询图片
 */
@Data
public class SearchPictureByColorRequest implements Serializable {
    private String picColor;

    private Long spaceId;

    private static final long serialVersionUID = 1L;
}
