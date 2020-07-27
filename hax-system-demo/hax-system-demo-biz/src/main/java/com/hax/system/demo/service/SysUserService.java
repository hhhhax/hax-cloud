package com.hax.system.demo.service;

import com.hax.system.demo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理员用户表 服务类
 * </p>
 *
 * @author hax
 * @date 2020-07-24
 */

public interface SysUserService extends IService<SysUser> {

    boolean add(SysUser sysUser);

    SysUser selectByUsername(String username);

    int deleteByUsername(String admin);
}