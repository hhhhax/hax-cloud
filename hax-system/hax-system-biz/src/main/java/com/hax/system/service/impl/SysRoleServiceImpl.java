package com.hax.system.service.impl;

import com.hax.system.mapper.SysRoleMapper;
import com.hax.system.entity.SysRole;
import com.hax.system.service.SysRoleService;
import com.hax.common.mybatis.service.impl.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by hax on 2020/07/17.
 */
@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

}
