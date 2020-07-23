package com.hax.system.demo.service.impl;

import com.hax.system.demo.mapper.SysMenuMapper;
import com.hax.system.demo.entity.SysMenu;
import com.hax.system.demo.service.SysMenuService;
import com.hax.common.mybatis.service.impl.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by hax on 2020/07/21.
 */
@Service
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

}
