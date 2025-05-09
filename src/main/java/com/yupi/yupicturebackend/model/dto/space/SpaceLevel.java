package com.yupi.yupicturebackend.model.dto.space;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName: SpaceLevel
 * @Author: zxh
 * @Date: 2025/5/9 23:09
 * @Description: 空间级别
 */
@Data
@AllArgsConstructor
public class SpaceLevel {
    private int value;

    private String text;

    private long maxCount;

    private long maxSize;
}
