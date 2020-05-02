package com.atguigu.springcloud.alibaba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description
 * NacosConsumer9091
 * <p>
 * Data
 * 2020/5/2-15:16
 *
 * @author zrx
 * @version 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConsumer9091 {
    private final static Logger LOGGER = LoggerFactory.getLogger(NacosConsumer9091.class);

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer9091.class,args);
    }
}
