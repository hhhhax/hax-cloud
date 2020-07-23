package com.hax.system.demo.controller;
import com.hax.system.demo.entity.SysRoleMenu;
import com.hax.system.demo.service.SysRoleMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
* Created by hax on 2020/07/21.
*/
@RestController
@RequestMapping("/sys/role/menu")
public class SysRoleMenuController {
    @Resource
    private SysRoleMenuService sysRoleMenuService;

}
