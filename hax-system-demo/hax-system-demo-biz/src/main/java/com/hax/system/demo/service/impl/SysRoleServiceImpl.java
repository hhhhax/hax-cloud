package com.hax.system.demo.service.impl;

import com.hax.system.demo.mapper.SysRoleMapper;
import com.hax.system.demo.entity.SysRole;
import com.hax.system.demo.service.SysRoleService;
import com.hax.common.mybatis.service.impl.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by hax on 2020/07/21.
 */
@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

}
