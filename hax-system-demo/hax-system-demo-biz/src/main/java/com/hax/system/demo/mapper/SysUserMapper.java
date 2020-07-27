package com.hax.system.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hax.common.mybatis.query.QueryWrapperX;
import com.hax.system.demo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hax.system.demo.vo.SystemUserVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 管理员用户表 Mapper 接口
 * </p>
 *
 * @author hax
 * @date 2020-07-24
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    default SysUser selectByUsername(String username) {
        return selectOne(new QueryWrapperX<SysUser>().eqIfPresent(SysUser.USERNAME, username) .select(SysUser.NAME, SysUser.USERNAME, SysUser.PASSWORD));
    }






}

