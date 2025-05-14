package com.yupi.yupicturebackend.api.imageSearch.sub;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yupi.yupicturebackend.api.imageSearch.model.ImageSearchResult;
import com.yupi.yupicturebackend.exception.BussinessException;
import com.yupi.yupicturebackend.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @ClassName: GetImageListApi
 * @Author: zxh
 * @Date: 2025/5/15 00:51
 * @Description: 获取图片列表
 */
@Slf4j
public class GetImageListApi {
    public static List<ImageSearchResult> getImageList(String imageUrl) {
        try {
            // 发起HTTP请求
            HttpResponse response = HttpUtil.createGet(imageUrl).execute();

            int statusCode = response.getStatus();
            String body = response.body();

            if (statusCode == 200) {
                // 处理JSON数据并处理
                return processResponse(body);
            } else {
                throw new BussinessException(ErrorCode.OPERATION_ERROR, "接口调用失败");
            }
        } catch (Exception e) {
            log.error("获取图片列表失败, " + e);
            throw new BussinessException(ErrorCode.OPERATION_ERROR, "获取图片列表失败");
        }
    }

    private static List<ImageSearchResult> processResponse(String responseBody) {
        // 解析响应对象
        JSONObject jsonObject = new JSONObject(responseBody);
        if (!jsonObject.containsKey("data")) {
            throw new BussinessException(ErrorCode.OPERATION_ERROR,  "未获取到图片列表");
        }
        JSONObject data = jsonObject.getJSONObject("data");
        if (!data.containsKey("list")) {
            throw new BussinessException(ErrorCode.OPERATION_ERROR, "未获取到图片列表");
        }
        JSONArray list = data.getJSONArray("list");
        return JSONUtil.toList(list, ImageSearchResult.class);
    }

}
