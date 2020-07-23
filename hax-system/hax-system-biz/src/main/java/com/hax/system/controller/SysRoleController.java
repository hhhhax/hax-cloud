package com.hax.system.controller;
import com.hax.system.entity.SysRole;
import com.hax.system.service.SysRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
* Created by hax on 2020/07/17.
*/
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

}
