package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description
 * Gateway29528
 * <p>
 * Data
 * 2020/4/22-23:41
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class Gateway29528 {
    private final static Logger LOGGER = LoggerFactory.getLogger(Gateway29528.class);

    public static void main(String[] args) {
        SpringApplication.run(Gateway29528.class, args);
    }
}
