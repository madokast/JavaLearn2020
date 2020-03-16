package com.madokast.privacy.learn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 * RabbitConfig
 * 序列化用json
 * <p>
 * Data
 * 23:26
 *
 * @author zrx
 * @version 1.0
 */

@Configuration
public class RabbitConfig {
    private final Logger LOGGER = LoggerFactory.getLogger(RabbitConfig.class);

    @Bean
    public MessageConverter messageConverter(){
        LOGGER.info("注入Jackson2JsonMessageConverter");
        return new Jackson2JsonMessageConverter();
    }
}
