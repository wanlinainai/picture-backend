package com.yupi.yupicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: SearchPictureByPictureRequest
 * @Author: zxh
 * @Date: 2025/5/15 01:04
 * @Description: 以图搜图请求类
 */
@Data
public class SearchPictureByPictureRequest implements Serializable {
    private Long pictureId;

    private static final long serialVersionUID = 1L;
}
