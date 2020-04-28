package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description
 * EurekaServer27020
 * <p>
 * Data
 * 2020/4/22-21:03
 *
 * @author zrx
 * @version 1.0
 */


@EnableEurekaServer
@SpringBootApplication
public class EurekaServer27020 {
    private final static Logger LOGGER = LoggerFactory.getLogger(EurekaServer27020.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer27020.class, args);
    }
}
