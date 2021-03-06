package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description
 * Payment28001
 * main entry
 * <p>
 * Data
 * 2020/4/13-20:30
 *
 * @author zrx
 * @version 1.0
 */

@EnableEurekaClient
@SpringBootApplication
public class Payment28002 {
    private final static Logger LOGGER = LoggerFactory.getLogger(Payment28002.class);

    public static void main(String[] args) {
        SpringApplication.run(Payment28002.class, args);
    }
}
