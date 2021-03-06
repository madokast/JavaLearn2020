package com.atguigu.springcloud;

import com.atguigu.myrule.MyRibbonRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


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

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRibbonRule.class)
public class OrderMain20080 {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderMain20080.class);

    public static void main(String[] args) {
        SpringApplication.run(OrderMain20080.class, args);
    }

}
