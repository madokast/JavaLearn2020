package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description
 * Gateway29527
 * <p>
 * Data
 * 2020/4/22-23:02
 *
 * @author zrx
 * @version 1.0
 */

@EnableEurekaClient
@SpringBootApplication
public class Gateway29527 {
    private final static Logger LOGGER = LoggerFactory.getLogger(Gateway29527.class);

    public static void main(String[] args) {
        SpringApplication.run(Gateway29527.class, args);
    }
}
