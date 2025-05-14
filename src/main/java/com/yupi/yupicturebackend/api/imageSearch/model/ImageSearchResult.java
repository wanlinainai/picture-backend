package com.yupi.yupicturebackend.api.imageSearch.model;

import lombok.Data;

/**
 * @ClassName: ImageSearchResult
 * @Author: zxh
 * @Date: 2025/5/14 23:36
 * @Description: 图片搜索结果类
 */
@Data
public class ImageSearchResult {
    /**
     * 缩略图地址
     */
    private String thumbUrl;

    /**
     * 来源地址
     */
    private String fromUrl;
}
