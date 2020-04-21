package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * Description
 * OrderFeignMain20090
 * <p>
 * Data
 * 2020/4/21-12:19
 *
 * @author zrx
 * @version 1.0
 */

@EnableHystrix
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class OrderFeignMain20090 {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderFeignMain20090.class);

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain20090.class,args);
    }
}
