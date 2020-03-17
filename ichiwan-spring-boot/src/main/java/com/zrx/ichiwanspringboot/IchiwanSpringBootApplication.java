package com.zrx.ichiwanspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
public class IchiwanSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(IchiwanSpringBootApplication.class, args);
    }
}

