package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description
 * EurekaServer27002
 * <p>
 * Data
 * 2020/4/15-9:09
 *
 * @author zrx
 * @version 1.0
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer27002 {
    private final static Logger LOGGER = LoggerFactory.getLogger(EurekaServer27002.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer27002.class, args);
    }
}
