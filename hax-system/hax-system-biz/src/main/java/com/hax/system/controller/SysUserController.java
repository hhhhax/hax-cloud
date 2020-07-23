package com.hax.system.controller;

import com.hax.common.core.vo.CommonResult;
import com.hax.common.security.annotations.RequiresNone;
import com.hax.common.security.annotations.RequiresPermissions;
import com.hax.system.domain.user.dto.SystemUserCreateDTO;
import com.hax.system.domain.user.dto.UserLoginDTO;
import com.hax.system.domain.user.vo.UserAccessTokenVO;
import com.hax.system.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by hax on 2020/07/17.
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;


    @PostMapping("/login")
    @ApiOperation("账号密码登陆")
    @RequiresNone
    public CommonResult<UserAccessTokenVO> login(UserLoginDTO loginDTO) {
        return sysUserService.login(loginDTO);
    }


    @ApiOperation(value = "创建管理员")
    @PostMapping("/create")
    @RequiresPermissions("sys:user:add")
    public CommonResult createAdmin(SystemUserCreateDTO createDTO) {
        return sysUserService.save(createDTO);
    }

}
