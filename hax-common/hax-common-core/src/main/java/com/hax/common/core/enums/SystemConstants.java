package com.hax.common.core.enums;

/**
 * Mall 全局枚举
 */
public interface SystemConstants {

    // 全局请求路径枚举类，用于定义不同用户类型的根请求路径


    // 用户类型
    /**
     * 用户类型 - 用户
     */
    @Deprecated
    Integer USER_TYPE_USER = 1;
    /**
     * 用户类型 - 管理员
     */
    @Deprecated
    Integer USER_TYPE_ADMIN = 2;

    /**
     * 内部
     */
    String FROM_IN = "Y";

    /**
     * 标志
     */
    String FROM = "from";


}
