package com.yupi.yupicturebackend.manager.upload;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.yupi.yupicturebackend.exception.BussinessException;
import com.yupi.yupicturebackend.exception.ErrorCode;
import com.yupi.yupicturebackend.exception.ThrowUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: UrlPictureUpload
 * @Author: zxh
 * @Date: 2025/4/22 22:11
 * @Description: 根据URL进行解析之后上传图片
 */
@Service
@Slf4j
public class UrlPictureUpload extends PictureUploadTemplate{
    @Override
    protected void validPicture(Object inputSource) {
        String fileUrl = (String) inputSource;
        ThrowUtils.throwIf(StrUtil.isBlank(fileUrl), ErrorCode.PARAMS_ERROR, "文件地址不能为空");
        // 验证URL格式
        try {
            new URL(fileUrl);
        } catch (MalformedURLException e) {
            throw new BussinessException(ErrorCode.PARAMS_ERROR, "文件地址格式错误");
        }
        // 校验URL协议
        ThrowUtils.throwIf(!(fileUrl.startsWith("http://")) && !(fileUrl.startsWith("https://")), ErrorCode.PARAMS_ERROR, "仅支持HTTP或者HTTPS协议的文件地址");

        // 发送HEAD 请求，验证文件是否存在
        HttpResponse response = null;
        try {
            response = HttpUtil.createRequest(Method.HEAD, fileUrl).execute();
            // 未正常返回
            if (response.getStatus() != HttpStatus.HTTP_OK) {
                return;
            }

            // 校验文件类型
            String contentType = response.header("Content-Type");
            if (StrUtil.isNotBlank(contentType)) {
                // 允许的图片类型
                final List<String> ALLOW_CONTENT_TYPES = Arrays.asList("image/jpeg", "image/jpg", "image/png", "image/webp");
                ThrowUtils.throwIf(!ALLOW_CONTENT_TYPES.contains(contentType.toLowerCase()), ErrorCode.PARAMS_ERROR, "文件类型错误");
            }
            // 校验文件大小
            String contentLengthStr = response.header("Content-Length");
            if (StrUtil.isNotBlank(contentLengthStr)) {
                try {
                    long contentLength = Long.parseLong(contentLengthStr);
                    // 文件限制在 2MB
                    final long TWO_MB = 2 * 1024 * 1024L;
                    ThrowUtils.throwIf(contentLength > TWO_MB, ErrorCode.PARAMS_ERROR, "文件大小不能超过2MB");
                } catch (Exception e) {
                    throw new BussinessException(ErrorCode.PARAMS_ERROR, "文件大小错误");
                }
            }
        } catch (Exception e) {
            log.error("文件处理失败：" + e.getMessage());
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    @Override
    protected String getOriginFileName(Object inputSource) {
        String fileUrl = (String) inputSource;
        return FileUtil.getName(fileUrl);
    }

    @Override
    protected void processFile(Object inputSource, File file) throws Exception {
        String fileUrl = (String) inputSource;
        // 下载文件到临时文件
        HttpUtil.downloadFile(fileUrl, file);
    }
}
