package com.yupi.yupicturebackend.api.aliyunai;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.yupi.yupicturebackend.api.aliyunai.model.CreateOutPaintingTaskRequest;
import com.yupi.yupicturebackend.api.aliyunai.model.CreateOutPaintingTaskResponse;
import com.yupi.yupicturebackend.api.aliyunai.model.GetOutPaintingTaskResponse;
import com.yupi.yupicturebackend.exception.BussinessException;
import com.yupi.yupicturebackend.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AliYunAiApi
 * @Author: zxh
 * @Date: 2025/5/18 23:34
 * @Description: 调用阿里云百炼的API
 */
@Slf4j
@Component
public class AliYunAiApi {
    @Value("${aliYunAi.apiKey}")
    private String apiKey;

    // 创建任务地址
    public static final String CREATE_TASK_URL = "https://dashscope.aliyuncs.com/api/v1/services/aigc/image2image/out-painting";

    // 查询任务状态
    public static final String GET_OUT_PAINTING_TASK_URL = "https://dashscope.aliyuncs.com/api/v1/tasks/%s";

    /**
     * 创建任务
     */
    public CreateOutPaintingTaskResponse createOutPaintingTask(CreateOutPaintingTaskRequest createOutPaintingTaskRequest) {
        if (createOutPaintingTaskRequest == null) {
            throw new BussinessException(ErrorCode.OPERATION_ERROR, "扩图参数为空");
        }
        // 发请求
        HttpRequest httpRequest = HttpRequest.post(CREATE_TASK_URL)
                .header("X-DashScope-Async", "enable")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(JSONUtil.toJsonStr(createOutPaintingTaskRequest));

        try(HttpResponse httpResponse = httpRequest.execute()) {
            if (!httpResponse.isOk()) {
                log.error("请求异常:{}", httpResponse.body());
                throw new BussinessException(ErrorCode.OPERATION_ERROR, "AI 扩图失败");
            }
            CreateOutPaintingTaskResponse response = JSONUtil.toBean(httpResponse.body(), CreateOutPaintingTaskResponse.class);
            String errorCode = response.getCode();
            if (StrUtil.isNotBlank(errorCode)) {
                String errorMessage = response.getMessage();
                log.error("AI 扩图失败，errorCode:{}, errorMessage:{}", errorCode, errorMessage);
                throw new BussinessException(ErrorCode.OPERATION_ERROR, "AI 扩图接口响应失败");
            }
            return response;
        } catch (Exception e) {
            log.error("请求出错，原因是:", e);
            throw new BussinessException(ErrorCode.OPERATION_ERROR, "请求出错，原因是:" + e);
        }
    }

    /**
     * 查询创建的任务
     */
    public GetOutPaintingTaskResponse getOutPaintingTaskResponse(String taskId) {
        if (StrUtil.isBlank(taskId)) {
            throw new BussinessException(ErrorCode.PARAMS_ERROR, "无任务ID");
        }
        try(HttpResponse httpResponse = HttpRequest.get(String.format(GET_OUT_PAINTING_TASK_URL, taskId))
                .header(Header.AUTHORIZATION, "Bearer" + apiKey)
                .execute()) {
            if (!httpResponse.isOk()) {
                log.error("查询创建任务失败");
                throw new BussinessException(ErrorCode.OPERATION_ERROR, "查询创建任务失败");
            }
            return JSONUtil.toBean(httpResponse.body(), GetOutPaintingTaskResponse.class);
        }
    }
}
