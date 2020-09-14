package com.sun.user.service.impl;

import com.sun.user.dto.UserAddDto;
import com.sun.user.dto.UserLoginDto;
import com.sun.user.entity.User;
import com.sun.user.mapper.UserMapper;
import com.sun.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author sunql
 * @since 2020-09-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public User selectPasswordByName(UserLoginDto userLoginDto) {
        return baseMapper.selectPasswordByName(userLoginDto);
    }
}
