package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Description
 * OrderMain20080
 * <p>
 * Data
 * 2020/4/13-22:04
 *
 * @author zrx
 * @version 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class OrderMain20084 {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderMain20084.class);

    public static void main(String[] args) {
        SpringApplication.run(OrderMain20084.class, args);
    }

}
