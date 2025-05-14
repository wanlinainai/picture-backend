package com.yupi.yupicturebackend.api.imageSearch;

import com.yupi.yupicturebackend.api.imageSearch.model.ImageSearchResult;
import com.yupi.yupicturebackend.api.imageSearch.sub.GetImageFirstUrl;
import com.yupi.yupicturebackend.api.imageSearch.sub.GetImageListApi;
import com.yupi.yupicturebackend.api.imageSearch.sub.GetImagePageUrlApi;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @ClassName: ImageSearchApiFacade
 * @Author: zxh
 * @Date: 2025/5/15 00:59
 * @Description: 门面模式
 */
@Slf4j
public class ImageSearchApiFacade {

    /**
     * 搜索图片
     * @return
     */
    public static List<ImageSearchResult> searchImage(String imageUrl) {
        String imagePageUrl = GetImagePageUrlApi.getImagePageUrl(imageUrl);
        String imageFirstUrl = GetImageFirstUrl.getImageFirstUrl(imagePageUrl);
        List<ImageSearchResult> imageList = GetImageListApi.getImageList(imageFirstUrl);
        return imageList;
    }

    public static void main(String[] args) {
        // 测试
        String imageUrl = "https://www.codefather.cn/logo.png";
        List<ImageSearchResult> resultList = searchImage(imageUrl);
        System.out.println(resultList);
    }
}
