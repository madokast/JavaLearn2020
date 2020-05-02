package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description
 * Payment29880
 * <p>
 * Data
 * 2020/5/1-11:14
 *
 * @author zrx
 * @version 1.0
 */


@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class Payment29880 {
    private final static Logger LOGGER = LoggerFactory.getLogger(Payment29880.class);

    public static void main(String[] args) {
        SpringApplication.run(Payment29880.class, args);
    }
}