package com.hax.system.demo.service.impl;

import com.hax.system.demo.mapper.SysRoleMenuMapper;
import com.hax.system.demo.entity.SysRoleMenu;
import com.hax.system.demo.service.SysRoleMenuService;
import com.hax.common.mybatis.service.impl.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by hax on 2020/07/21.
 */
@Service
public class SysRoleMenuServiceImpl extends AbstractService<SysRoleMenu> implements SysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

}
