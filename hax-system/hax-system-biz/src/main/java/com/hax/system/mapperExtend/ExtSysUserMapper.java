package com.hax.system.mapperExtend;

import com.hax.system.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ExtSysUserMapper {

    @Select("select " +
            "* from sys_user " +
            "where username = #{userName}" +
            "")
    SysUser getUserByUserName(@Param("userName") String userName);
}