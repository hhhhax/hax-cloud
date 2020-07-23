package com.hax.system.demo.controller;
import com.hax.system.demo.entity.SysUserRole;
import com.hax.system.demo.service.SysUserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
* Created by hax on 2020/07/21.
*/
@RestController
@RequestMapping("/sys/user/role")
public class SysUserRoleController {
    @Resource
    private SysUserRoleService sysUserRoleService;

}
