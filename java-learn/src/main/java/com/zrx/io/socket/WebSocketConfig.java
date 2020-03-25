package com.zrx.io.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Description
 * WebSocketConfig
 * <p>
 * Data
 * 2020/3/18-23:04
 *
 * @author zrx
 * @version 1.0
 */

@Configuration
public class WebSocketConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebSocketConfig.class);

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        LOGGER.info("ServerEndpointExporter注入");
        return new ServerEndpointExporter();
    }
}
