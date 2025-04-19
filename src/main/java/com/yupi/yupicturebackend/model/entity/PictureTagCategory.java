package com.yupi.yupicturebackend.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: PictureTagCategory
 * @Author: zxh
 * @Date: 2025/4/19 22:49
 * @Description:
 */
@Data
public class PictureTagCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> tagList;

    private List<String> categoryList;
}
