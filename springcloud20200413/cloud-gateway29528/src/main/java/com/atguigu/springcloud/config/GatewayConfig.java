package com.atguigu.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 * GatewayConfig
 * <p>
 * Data
 * 2020/4/22-23:43
 *
 * @author zrx
 * @version 1.0
 */

@Configuration
public class GatewayConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(GatewayConfig.class);

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        //https://news.sogou.com/ent
        //https://news.sogou.com/business
        return builder.routes()
                .route("ent", r -> r.path("/ent").uri("https://news.sogou.com/ent"))
                .route("business", r -> r.path("business").uri("https://news.sogou.com/business"))
                .build();
    }
}
