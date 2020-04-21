package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description
 * OrderFeignMain20088
 * <p>
 * Data
 * 2020/4/20-21:47
 *
 * @author zrx
 * @version 1.0
 */

@EnableFeignClients
//@EnableEurekaClient
@SpringBootApplication
public class OrderFeignMain20088 {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderFeignMain20088.class);

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain20088.class, args);
    }
}
