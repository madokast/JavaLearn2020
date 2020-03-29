package com.zrx.ichiwanspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class IchiwanSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(IchiwanSpringBootApplication.class, args);
    }
}

