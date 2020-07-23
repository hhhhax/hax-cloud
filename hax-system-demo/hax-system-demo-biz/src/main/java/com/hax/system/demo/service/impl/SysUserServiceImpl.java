package com.hax.system.demo.service.impl;

import com.hax.common.core.vo.CommonResult;
import com.hax.system.demo.dto.SystemUserCreateDTO;
import com.hax.system.demo.mapper.SysUserMapper;
import com.hax.system.demo.entity.SysUser;
import com.hax.system.demo.service.SysUserService;
import com.hax.common.mybatis.service.impl.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by hax on 2020/07/21.
 */
@Service
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 新增
     *
     * @param createDTO
     * @return
     */
    @Override
    @Transactional
    public CommonResult<Integer> add(SystemUserCreateDTO createDTO) {
        SysUser sysUser = new SysUser();
        sysUser.setName(createDTO.getName());
        sysUser.setUsername(createDTO.getUsername());
        sysUser.setPassword(createDTO.getPassword());
        sysUser.setPasswordSalt("123456");
        int i = sysUserMapper.insertSelective(sysUser);
        return CommonResult.success(i);
    }

    @Override
    public CommonResult<List<SysUser>> list() {
        return CommonResult.success(sysUserMapper.selectAll());
    }
}
