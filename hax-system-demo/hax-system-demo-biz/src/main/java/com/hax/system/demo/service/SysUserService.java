package com.hax.system.demo.service;
import com.hax.common.core.vo.CommonResult;
import com.hax.system.demo.dto.SystemUserCreateDTO;
import com.hax.system.demo.entity.SysUser;
import com.hax.common.mybatis.service.Service;

import java.util.List;


/**
 * Created by hax on 2020/07/21.
 */
public interface SysUserService extends Service<SysUser> {

    CommonResult add(SystemUserCreateDTO createDTO);

    CommonResult<List<SysUser>> list();
}
