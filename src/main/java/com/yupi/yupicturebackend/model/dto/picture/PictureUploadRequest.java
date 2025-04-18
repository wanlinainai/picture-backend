package com.yupi.yupicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: PictureUploadRequest
 * @Author: zxh
 * @Date: 2025/4/18 22:21
 * @Description: 文件上传请求参数
 */
@Data
public class PictureUploadRequest implements Serializable {

    private Long   id;

    private static final long serialVersionUID = 1L;
}
