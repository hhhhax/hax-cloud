package com.hax.common.security.admin.context;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Admin Security 上下文
 */
@Data
@Accessors(chain = true)
public class AdminSecurityContext {

    /**
     * 管理员编号
     */
    private Integer adminId;

}
