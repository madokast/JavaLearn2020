package com.atguigu.springcloud.alibaba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description
 * NacosConfig13377
 * <p>
 * Data
 * 2020/5/2-15:59
 *
 * @author zrx
 * @version 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfig13377 {
    private final static Logger LOGGER = LoggerFactory.getLogger(NacosConfig13377.class);

    public static void main(String[] args) {
        SpringApplication.run(NacosConfig13377.class, args);
    }
}
