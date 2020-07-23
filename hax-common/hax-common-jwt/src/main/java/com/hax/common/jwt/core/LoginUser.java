package com.hax.common.jwt.core;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: hax
 * @Date: 2020/5/21
 * @company: yoe
 */
@Data
@Builder
public class LoginUser {


    private String userId;

    private String userType;

    private String refreshToken;

    private String ip;

}
