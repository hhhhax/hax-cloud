package com.hax.system.enums;


import com.hax.common.core.utils.ServiceExceptionUtil;

/**
 * 错误码枚举类
 *
 * system 系统，使用 1-002-000-000 段
 */
public enum SystemErrorCodeEnum implements ServiceExceptionUtil.Enumerable<SystemErrorCodeEnum> {

    // ========== OAUTH2 模块 ==========
    SYSTEM_UNKNOWN(1001001000, "未知错误"), // 预留
    // 预留 1001001001 ~ 1001001099 错误码，方便前端
    OAUTH2_ACCESS_TOKEN_NOT_FOUND(1001001001, "访问令牌不存在"),
    OAUTH2_ACCESS_TOKEN_TOKEN_EXPIRED(1001001002, "访问令牌已过期"),
    OAUTH2_ACCESS_TOKEN_INVALID(1001001003, "访问令牌已失效"),
    OAUTH2_NOT_AUTHENTICATION(1001001004, "账号未登录"),
    OAUTH2_REFRESH_TOKEN_NOT_FOUND(1001001005, "刷新令牌不存在"),
    OAUTH_REFRESH_TOKEN_EXPIRED(1001001006, "访问令牌已过期"),
    OAUTH_REFRESH_TOKEN_INVALID(1001001007, "刷新令牌已失效"),
    // 其它 1001001100 开始
    OAUTH_USER_TYPE_ERROR(1001001101, "用户类型并不正确"),

    // ========== 管理员模块 1002002000 ==========
    ADMIN_USER_HAS_EXISTED(1002002000, "当前用户已存在"),
    ADMIN_USER_NOT_EXISTED(1002002001, "当前登陆用户不存在"),
    LOGIN_PASSWORD_ERROR(1002002002, "密码错误"),


    ;


    private final int code;
    private final String message;

    SystemErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    // TODO: 2020-05-22 封装成start的时候，直接在start中定义一个统一的枚举，从中取值；
    @Override
    public int getGroup() {
        return 0;
    }


}
