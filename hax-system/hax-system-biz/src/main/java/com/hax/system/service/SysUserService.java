package com.hax.system.service;
import com.hax.common.core.vo.CommonResult;
import com.hax.system.domain.user.dto.SystemUserCreateDTO;
import com.hax.system.domain.user.dto.UserLoginDTO;
import com.hax.system.domain.user.vo.UserAccessTokenVO;
import com.hax.system.entity.SysUser;
import com.hax.common.mybatis.service.Service;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


/**
 * Created by hax on 2020/07/17.
 */
public interface SysUserService extends Service<SysUser> {

    CommonResult<Integer> save(SystemUserCreateDTO createDTO);

    CommonResult<UserAccessTokenVO> login(UserLoginDTO loginDTO);

    SysUser getUserByUserName(String username);
}
