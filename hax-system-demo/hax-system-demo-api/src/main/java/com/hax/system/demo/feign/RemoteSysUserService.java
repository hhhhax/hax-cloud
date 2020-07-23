package com.hax.system.demo.feign;

import cn.hutool.system.UserInfo;
import com.hax.common.core.enums.ServiceNameConstants;
import com.hax.common.core.enums.SystemConstants;
import com.hax.common.core.vo.CommonResult;
import com.hax.system.demo.entity.SysUser;
import com.hax.system.demo.feign.factory.RemoteSysUserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import sun.security.util.SecurityConstants;

import java.util.List;

/**
 * @Author: hax
 * @Date: 2020/7/21
 * @company: yoe
 */
@FeignClient(contextId = "remoteSysUserService", value = ServiceNameConstants.SYS_SERVICE,
        fallbackFactory = RemoteSysUserServiceFallbackFactory.class)
public interface RemoteSysUserService {


    /**
     * 获取列表
     * @return
     */
    @GetMapping("/sys/user/list")
    CommonResult<List<SysUser>> info(@RequestHeader(SystemConstants.FROM) String from);

}
