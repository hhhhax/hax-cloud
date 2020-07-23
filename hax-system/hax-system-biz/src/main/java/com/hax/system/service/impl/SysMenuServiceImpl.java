package com.hax.system.service.impl;

import com.hax.system.mapper.SysMenuMapper;
import com.hax.system.entity.SysMenu;
import com.hax.system.service.SysMenuService;
import com.hax.common.mybatis.service.impl.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by hax on 2020/07/17.
 */
@Service
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

}
