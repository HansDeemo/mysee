package com.njbdqn.mysee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.njbdqn.mysee.dao")
public class MyseeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyseeApplication.class, args);
    }
}
