package com.atguigu.springcloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 * MessageProviderImpl
 * <p>
 * Data
 * 2020/4/30-22:43
 *
 * @author zrx
 * @version 1.0
 */

//@Service 不需要service
@EnableBinding(Source.class) // 绑定为消息源
public class MessageProviderImpl implements IMessageProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageProviderImpl.class);

    @Resource
    private MessageChannel output;

    @Override
    public void send(String message) {
        LOGGER.info("发送消息 = {}", message);
        output.send(MessageBuilder.withPayload(message).build());
    }
}
