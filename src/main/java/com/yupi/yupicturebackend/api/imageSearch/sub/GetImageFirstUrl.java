package com.yupi.yupicturebackend.api.imageSearch.sub;

import com.yupi.yupicturebackend.exception.BussinessException;
import com.yupi.yupicturebackend.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: GetImageFirstUrl
 * @Author: zxh
 * @Date: 2025/5/15 00:42
 * @Description: 获取图片列表
 */
@Slf4j
public class GetImageFirstUrl {
    public static String getImageFirstUrl(String imageUrl) {
        try {
            // 使用Jsoup来解析页面数据
            Document document = Jsoup.connect(imageUrl).timeout(5000).get();
            // 获取所有的script标签
            Elements scriptElements = document.getElementsByTag("script");

            for (Element script : scriptElements) {
                String scriptContent = script.html();
                if (scriptContent.contains("\"firstUrl\"")) {
                    // 使用正则表达式获取
                    Pattern pattern = Pattern.compile("\"firstUrl\"\\s*:\\s*\"(.*?)\"");
                    Matcher matcher = pattern.matcher(scriptContent);
                    if (matcher.find()) {
                        String firstUrl = matcher.group(1);
                        // 处理转义字符
                        firstUrl = firstUrl.replace("\\/", "/");
                        return firstUrl;
                    }
                }
            }
            throw new BussinessException(ErrorCode.OPERATION_ERROR, "未找到URL");
        } catch (Exception e) {
            log.error("获取图片列表失败, " + e);
            throw new BussinessException(ErrorCode.OPERATION_ERROR, "获取图片列表失败");
        }
    }
}
