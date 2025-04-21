package com.yupi.yupicturebackend.model.dto.pictureReview;

import lombok.Data;
import java.io.Serializable;

/**
 * @ClassName: PictureReviewRequest
 * @Author: zxh
 * @Date: 2025/4/21 22:27
 * @Description: 开发请求包装类
 */
@Data
public class PictureReviewRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 状态：0-待审核，1-通过，2-拒绝
     */
    private Integer reviewStatus;

    /**
     * 审核信息
     */
    private String reviewMessage;

    private static final long serialVersionUID = 1L;
}
