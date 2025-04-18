package com.yupi.yupicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: PictureUpdateRequest
 * @Author: zxh
 * @Date: 2025/4/19 00:04
 * @Description: 图片更新请求，admin使用
 */
@Data
public class PictureUpdateRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String introduction;

    private String category;

    private List<String> tags;
}
