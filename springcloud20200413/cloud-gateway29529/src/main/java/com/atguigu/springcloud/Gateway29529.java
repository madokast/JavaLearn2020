package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description
 * Gateway29529
 * 动态路由
 * <p>
 * Data
 * 2020/4/27-23:15
 *
 * @author zrx
 * @version 1.0
 */

@EnableEurekaClient
@SpringBootApplication
public class Gateway29529 {
    private final static Logger LOGGER = LoggerFactory.getLogger(Gateway29529.class);

    public static void main(String[] args) {
        SpringApplication.run(Gateway29529.class, args);


    }
}
