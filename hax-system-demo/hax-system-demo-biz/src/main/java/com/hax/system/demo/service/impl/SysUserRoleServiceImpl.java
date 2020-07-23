package com.hax.system.demo.service.impl;

import com.hax.system.demo.mapper.SysUserRoleMapper;
import com.hax.system.demo.entity.SysUserRole;
import com.hax.system.demo.service.SysUserRoleService;
import com.hax.common.mybatis.service.impl.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by hax on 2020/07/21.
 */
@Service
public class SysUserRoleServiceImpl extends AbstractService<SysUserRole> implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

}
