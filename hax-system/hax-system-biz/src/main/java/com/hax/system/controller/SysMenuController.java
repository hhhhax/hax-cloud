package com.hax.system.controller;
import com.hax.system.entity.SysMenu;
import com.hax.system.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
* Created by hax on 2020/07/17.
*/
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

}
