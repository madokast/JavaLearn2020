package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description
 * StreamProvider28801
 * <p>
 * Data
 * 2020/4/30-22:39
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class StreamProvider28801 {
    private final static Logger LOGGER = LoggerFactory.getLogger(StreamProvider28801.class);

    public static void main(String[] args) {
        SpringApplication.run(StreamProvider28801.class, args);
    }
}
