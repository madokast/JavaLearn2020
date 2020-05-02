package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description
 * StreamConsumer28803
 * <p>
 * Data
 * 2020/4/30-23:30
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class StreamConsumer28803 {
    private final static Logger LOGGER = LoggerFactory.getLogger(StreamConsumer28803.class);

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer28803.class, args);
    }
}
