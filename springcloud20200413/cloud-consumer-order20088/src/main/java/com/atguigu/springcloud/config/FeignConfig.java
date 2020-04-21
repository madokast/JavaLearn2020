package com.atguigu.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 * FeignConfig
 * <p>
 * Data
 * 2020/4/20-22:26
 *
 * @author zrx
 * @version 1.0
 */

@Configuration
public class FeignConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(FeignConfig.class);

    /**
     * feign 日志级别
     * @return FULL 级别
     */
    @Bean
    public feign.Logger.Level level(){
        return feign.Logger.Level.FULL;
    }
}
