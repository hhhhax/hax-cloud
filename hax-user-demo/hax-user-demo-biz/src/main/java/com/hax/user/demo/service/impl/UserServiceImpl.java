package com.hax.user.demo.service.impl;

import com.hax.user.demo.mapper.UserMapper;
import com.hax.user.demo.entity.User;
import com.hax.user.demo.service.UserService;
import com.hax.common.mybatis.service.impl.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by hax on 2020/07/21.
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
