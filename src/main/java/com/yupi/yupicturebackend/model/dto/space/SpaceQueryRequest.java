package com.yupi.yupicturebackend.model.dto.space;

import com.yupi.yupicturebackend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassName: SpaceQueryRequest
 * @Author: zxh
 * @Date: 2025/4/28 23:17
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SpaceQueryRequest extends PageRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private String spaceName;

    private Integer spaceLevel;
}
