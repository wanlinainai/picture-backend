package com.yupi.yupicturebackend.api.imageSearch.sub;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.yupi.yupicturebackend.exception.BussinessException;
import com.yupi.yupicturebackend.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GetImagePageUrlApi
 * @Author: zxh
 * @Date: 2025/5/14 23:51
 * @Description: 获取以图搜图的URL地址
 */
@Slf4j
public class GetImagePageUrlApi {
    /**
     * 获取意图搜图的页面地址
     * @param imageUrl
     * @return
     */
    public static String getImagePageUrl(String imageUrl) {
        // 准备请求参数
        HashMap<String, Object> formData = new HashMap<>();
        formData.put("image", imageUrl);
        formData.put("tn", "pc");
        formData.put("from", "pc");
        formData.put("image_source", "PC_UPLOAD_URL");
        // 获取时间戳
        long upTime = System.currentTimeMillis();
        // 请求地址
        String url = "https://graph.baidu.com/upload?uptime=" + upTime;

        try {
            HttpResponse response = HttpRequest.post(url).header("acs-token", RandomUtil.randomString(1)).form(formData).timeout(5000).execute();
            // 判断响应状态
            if (HttpStatus.HTTP_OK != response.getStatus()) {
                throw new BussinessException(ErrorCode.OPERATION_ERROR, "接口调用失败");
            }
            // 解析响应
            String responseBody = response.body();
            Map<String, Object> result = JSONUtil.toBean(responseBody, Map.class);
            if (result == null || !Integer.valueOf(0).equals(result.get("status"))) {
                throw new BussinessException(ErrorCode.OPERATION_ERROR, "接口调用失败");
            }

            Map<String, Object> data = (Map<String, Object>) result.get("data");
            String rawUrl = (String) data.get("url");
            // 需要对URL进行解码
            String searchResultUrl = URLUtil.decode(rawUrl);
            // 如果URL是空
            if (searchResultUrl == null) {
                throw new BussinessException(ErrorCode.OPERATION_ERROR, "未返回有效的地址");
            }
            return searchResultUrl;
        } catch (Exception e) {
            log.error("搜索失败, " + e);
            throw new BussinessException(ErrorCode.OPERATION_ERROR, "搜索失败");
        }
    }

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        String url = "https://www.codefather.cn/logo.png";
        String result = getImagePageUrl(url);
        System.out.println(result);
    }
}
