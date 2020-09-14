package com.sun.user.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.sun.user.dto.UserAddDto;
import com.sun.user.dto.UserLoginDto;
import com.sun.user.entity.User;
import com.sun.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author sunql
 * @since 2020-09-09
 */
@RestController
@RequestMapping("/user/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public R<Boolean> login(@RequestBody @Validated UserLoginDto userLoginDto){
        User user = userService.selectPasswordByName(userLoginDto);
        if ( user != null){
            //登录成功！
            return R.ok(Boolean.TRUE);
        }else {
            //登录失败！
            return R.failed("用户名或密码错误");
        }
    }

    /**
     * 用户注册
     *
     * @param userAddDto
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加用户信息", notes = "添加用户信息(注册)")
    public R<String> add(@RequestBody @Validated UserAddDto userAddDto){
        User user = new User();
        BeanUtils.copyProperties(userAddDto, user);
        userService.save(user);
        return R.ok("用户信息添加成功");
    }
}

