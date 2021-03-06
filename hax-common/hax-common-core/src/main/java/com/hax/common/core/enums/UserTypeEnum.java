package com.hax.common.core.enums;

import java.util.Arrays;

/**
 * 全局用户类型枚举
 */
public enum UserTypeEnum   {

    USER(1, "用户"),
    ADMIN(2, "管理员");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(UserTypeEnum::getValue).toArray();

    /**
     * 类型
     */
    private final Integer value;
    /**
     * 类型名
     */
    private final String name;

    UserTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    public int[] array() {
        return ARRAYS;
    }

}
