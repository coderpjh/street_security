package com.sun.user.mapper;

import com.sun.user.dto.UserLoginDto;
import com.sun.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author sunql
 * @since 2020-09-09
 */
public interface UserMapper extends BaseMapper<User> {
    User selectPasswordByName(@Param("queryDto") UserLoginDto userLoginDto);
}
