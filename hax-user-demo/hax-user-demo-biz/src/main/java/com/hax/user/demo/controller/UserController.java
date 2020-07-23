package com.hax.user.demo.controller;
import com.hax.common.core.enums.SystemConstants;
import com.hax.common.core.utils.RequestHolder;
import com.hax.common.core.vo.CommonResult;
import com.hax.common.security.annotations.RequiresPermissions;
import com.hax.system.demo.entity.SysUser;
import com.hax.system.demo.feign.RemoteSysUserService;
import com.hax.user.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.SecurityConstants;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* Created by hax on 2020/07/21.
*/
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Resource
    private UserService userService;

    private final RemoteSysUserService remoteSysUserService;




    @ApiOperation(value = "管理员列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:user:list")
    public CommonResult<List<SysUser>> list() {
        CommonResult<List<SysUser>> info = remoteSysUserService.info(SystemConstants.FROM_IN);
        return info;
    }
}
