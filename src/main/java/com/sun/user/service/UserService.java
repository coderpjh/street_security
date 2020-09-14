package com.sun.user.service;

import com.sun.user.dto.UserAddDto;
import com.sun.user.dto.UserLoginDto;
import com.sun.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author sunql
 * @since 2020-09-09
 */
public interface UserService extends IService<User> {
    User selectPasswordByName(UserLoginDto userLoginDto);
}
