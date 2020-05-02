package com.atguigu.springcloud.alibaba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description
 * SentinelService28401
 * <p>
 * Data
 * 2020/5/2-22:54
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService28401 {
    private final static Logger LOGGER = LoggerFactory.getLogger(SentinelService28401.class);

    public static void main(String[] args) {
        SpringApplication.run(SentinelService28401.class, args);
    }
}
