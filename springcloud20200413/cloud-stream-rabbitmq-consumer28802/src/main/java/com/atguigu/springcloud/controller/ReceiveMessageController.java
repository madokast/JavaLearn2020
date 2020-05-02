package com.atguigu.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * ReceiveMessageController
 * <p>
 * Data
 * 2020/4/30-23:18
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ReceiveMessageController.class);


    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        LOGGER.info("{}收到消息{}", serverPort, message.getPayload());
    }
}
