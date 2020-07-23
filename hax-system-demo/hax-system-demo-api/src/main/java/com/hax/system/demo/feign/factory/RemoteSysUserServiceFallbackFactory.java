package com.hax.system.demo.feign.factory;

import com.hax.common.core.enums.SystemConstants;
import com.hax.common.core.exception.GlobalException;
import com.hax.common.core.vo.CommonResult;
import com.hax.system.demo.feign.RemoteSysUserService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.hax.common.core.enums.GlobalErrorCodeConstants.FALLBACK_SERVER_ERROR;

/**
 * @Author: hax
 * @Date: 2020/7/21
 * @company: yoe
 */
@Component
@Slf4j
public class RemoteSysUserServiceFallbackFactory implements FallbackFactory<RemoteSysUserService> {
    @Override
    public RemoteSysUserService create(Throwable throwable) {
        log.error("feign 查询管理员用户列表失败:{}", throwable.getMessage());
        return from -> CommonResult.error(FALLBACK_SERVER_ERROR);
    }
}
