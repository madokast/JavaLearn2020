package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description
 * Config23344
 * <p>
 * Data
 * 2020/4/28-17:30
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootApplication
@EnableConfigServer
public class Config23344 {
    private final static Logger LOGGER = LoggerFactory.getLogger(Config23344.class);

    public static void main(String[] args) {
        SpringApplication.run(Config23344.class, args);

    }
}
