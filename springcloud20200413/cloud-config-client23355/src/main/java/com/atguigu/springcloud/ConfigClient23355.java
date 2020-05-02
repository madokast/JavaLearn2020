package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description
 * ConfigClient23355
 * <p>
 * Data
 * 2020/4/28-18:54
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient23355 {
    private final static Logger LOGGER = LoggerFactory.getLogger(ConfigClient23355.class);

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient23355.class, args);
    }
}
