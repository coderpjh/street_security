package com.sun;

import com.sun.user.entity.User;
import com.sun.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StreetSecurityApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
        // 查询全部用户
    }


    @Test
    void add(){
        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");
        userMapper.insert(user);
        System.out.println(user);
    }


}
