package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Description
 * Monitor26001
 * <p>
 * Data
 * 2020/4/22-20:01
 *
 * @author zrx
 * @version 1.0
 */

@EnableHystrixDashboard
@SpringBootApplication
public class Monitor26001 {
    private final static Logger LOGGER = LoggerFactory.getLogger(Monitor26001.class);

    public static void main(String[] args) {
        SpringApplication.run(Monitor26001.class,args);
    }
}
