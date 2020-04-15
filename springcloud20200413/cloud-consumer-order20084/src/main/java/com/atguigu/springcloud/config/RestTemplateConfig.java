package com.atguigu.springcloud.config;

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
 * 2020/4/13-22:18
 *
 * @author zrx
 * @version 1.0
 */

@Configuration
public class RestTemplateConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(RestTemplateConfig.class);

    @Bean
    @LoadBalanced // 2020年4月15日 负载均衡 //实际上可以解析服务域名 "http://CLOUD-PAYMENT-SERVICE"
    public RestTemplate getRestTemplate() {
        LOGGER.info("RestTemplate insert");
        return new RestTemplate();
    }
}
