package com.hax.system.demo.controller;
import com.hax.system.demo.entity.SysMenu;
import com.hax.system.demo.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
* Created by hax on 2020/07/21.
*/
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

}
