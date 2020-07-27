package com.hax.system.demo.controller;


import com.hax.common.core.vo.CommonResult;
import com.hax.common.security.annotations.RequiresPermissions;
import com.hax.system.demo.dto.SystemUserCreateDTO;
import com.hax.system.demo.entity.SysUser;
import com.hax.system.demo.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 管理员用户表 前端控制器
 * </p>
 *
 * @author hax
 * @date 2020-07-24
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;



    @ApiOperation(value = "创建管理员")
    @PostMapping("/create")
    @RequiresPermissions("sys:user:add")
    public CommonResult<Boolean> createAdmin(SystemUserCreateDTO createDTO) {
        SysUser sysUser = new SysUser();
        sysUser.setName(createDTO.getName());
        sysUser.setUsername(createDTO.getUsername());
        sysUser.setPassword(createDTO.getPassword());
        sysUser.setPasswordSalt("123");
        boolean save = sysUserService.add(sysUser);
        return CommonResult.success(save);
    }

    @ApiOperation(value = "管理员列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:user:list")
    public CommonResult<SysUser> list() {
        SysUser admin = sysUserService.selectByUsername("admin");
        return CommonResult.success(admin);
    }

    @ApiOperation(value = "删除管理员")
    @GetMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public CommonResult<Integer> delete() {
        int  i= sysUserService.deleteByUsername("admin");
        return CommonResult.success(i);
    }



}
