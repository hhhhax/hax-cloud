package com.hax.system.demo.service.impl;

import com.hax.system.demo.entity.SysUser;
import com.hax.system.demo.mapper.SysUserMapper;
import com.hax.system.demo.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 管理员用户表 服务实现类
 * </p>
 *
 * @author hax
 * @date 2020-07-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Transactional
    @Override
    public boolean add(SysUser sysUser) {
        return this.save(sysUser);
    }


    @Override
    public SysUser selectByUsername(String username) {
        SysUser sysUser = sysUserMapper.selectByUsername(username);
        return sysUser;
    }

    @Override
    public int deleteByUsername(String admin) {
        return sysUserMapper.deleteById(1);
    }
}
