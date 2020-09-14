package com.sun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.sun.user.mapper", "com.sun.professor.mapper"})
public class StreetSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreetSecurityApplication.class, args);
    }

}
