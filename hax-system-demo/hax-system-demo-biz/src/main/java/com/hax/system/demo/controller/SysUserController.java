package com.hax.system.demo.controller;

import com.hax.common.core.vo.CommonResult;
import com.hax.common.security.annotations.Inner;
import com.hax.common.security.annotations.RequiresPermissions;
import com.hax.system.demo.dto.SystemUserCreateDTO;
import com.hax.system.demo.entity.SysUser;
import com.hax.system.demo.feign.RemoteSysUserService;
import com.hax.system.demo.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hax on 2020/07/21.
 */
@RestController
@RequestMapping("/sys/user")
@RequiredArgsConstructor
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    private final RemoteSysUserService remoteSysUserService;


    @ApiOperation(value = "创建管理员")
    @PostMapping("/create")
    @RequiresPermissions("sys:user:add")
    public CommonResult createAdmin(SystemUserCreateDTO createDTO) {
        return sysUserService.add(createDTO);
    }




    @ApiOperation(value = "管理员列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:user:list")
    @Inner
    public CommonResult<List<SysUser>> list() {
        CommonResult<List<SysUser>> list = sysUserService.list();
        return list;
    }


}
