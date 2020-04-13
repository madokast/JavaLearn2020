package com.atguigu.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public RestTemplate getRestTemplate() {
        LOGGER.info("RestTemplate insert");
        return new RestTemplate();
    }
}
