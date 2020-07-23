package com.hax.system.service.impl;

import com.hax.common.core.vo.CommonResult;
import com.hax.system.domain.user.dto.SystemUserCreateDTO;
import com.hax.system.domain.user.dto.UserLoginDTO;
import com.hax.system.domain.user.vo.UserAccessTokenVO;
import com.hax.system.entity.SysUser;
import com.hax.system.mapper.SysUserMapper;
import com.hax.system.mapperExtend.ExtSysUserMapper;
import com.hax.system.service.SysUserService;
import com.hax.common.mybatis.service.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.hax.system.enums.SystemErrorCodeEnum.*;


/**
 * Created by hax on 2020/07/17.
 */
@Service
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Autowired
    private ExtSysUserMapper extSysUserMapper;

    /**
     * 新增
     *
     * @param createDTO
     * @return
     */
    @Override
    @Transactional
    public CommonResult<Integer> save(SystemUserCreateDTO createDTO) {

        SysUser sysUser = new SysUser();
        sysUser.setName(createDTO.getName());
        sysUser.setUsername(createDTO.getUsername());
        sysUser.setPassword(createDTO.getPassword());
        sysUser.setPasswordSalt("123456");
        int i = sysUserMapper.insertSelective(sysUser);
        return CommonResult.success(i);
    }

    /**
     * 登陆产生token
     *
     * @param loginDTO
     * @return
     */
    @Override
    public CommonResult<UserAccessTokenVO> login(UserLoginDTO loginDTO) {
        SysUser sysUser = this.verifyPassword(loginDTO);
//        JwtUtils.createRefreshToken(sysUser.getId(), UserTypeEnum.ADMIN.getValue(),)
        return null;
    }

    @Override
    public SysUser getUserByUserName(String username) {
        return extSysUserMapper.getUserByUserName(username);
    }

    private SysUser verifyPassword(UserLoginDTO loginDTO) {
        SysUser user = this.getUserByUserName(loginDTO.getUsername());
        if (user != null) {
            throw new ServiceException(ADMIN_USER_NOT_EXISTED.getCode(), ADMIN_USER_NOT_EXISTED.getMessage());
        }
        if (!loginDTO.getPassword().equals(user.getPassword())) {
            throw new ServiceException(LOGIN_PASSWORD_ERROR.getCode(), LOGIN_PASSWORD_ERROR.getMessage());
        }
        return null;
    }
}
