package com.yupi.yupicturebackend.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

/**
 * 空间级别枚举
 */
@Getter
public enum SpaceLevelEnum {
    COMMON("普通版", 0, 100L, 100L * 1024 * 1024),
    PROFESSIONAL("专业版", 1, 1000L, 1000L * 1024 * 1024),
    FLAGSHIP("旗舰版", 2, 10000L, 10000L * 1024 * 1024);

    private final String text;

    private final int value;

    private final Long macCount;

    private final Long maxSize;

    SpaceLevelEnum(String text, int value, Long macCount, Long maxSize) {
        this.text = text;
        this.value = value;
        this.macCount = macCount;
        this.maxSize = maxSize;
    }

    /**
     * 根据value获取枚举
     */
    public static SpaceLevelEnum getEnumByValue(Integer value) {
        if (ObjUtil.isEmpty(value)) {
            return null;
        }
        for (SpaceLevelEnum spaceLevelEnum: SpaceLevelEnum.values()) {
            if (spaceLevelEnum.value == value) {
                return spaceLevelEnum;
            }
        }
        return null;
    }
}
