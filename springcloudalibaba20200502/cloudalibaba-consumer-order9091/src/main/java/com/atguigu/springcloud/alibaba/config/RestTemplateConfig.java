package com.atguigu.springcloud.alibaba.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Description
 * RestTemplateConfig
 * <p>
 * Data
 * 2020/5/2-15:19
 *
 * @author zrx
 * @version 1.0
 */

@Configuration
public class RestTemplateConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(RestTemplateConfig.class);

    @Bean
    @LoadBalanced
    public RestTemplate get() {
        return new RestTemplate();
    }
}
