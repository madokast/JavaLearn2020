package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.service.IMessageProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description
 * SendMessageController
 * <p>
 * Data
 * 2020/4/30-22:51
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class SendMessageController {
    private final static Logger LOGGER = LoggerFactory.getLogger(SendMessageController.class);

    @Resource
    private IMessageProvider messageProviderImpl;

    @GetMapping("/send/{msg}")
    public Object send(@PathVariable String msg) {
        LOGGER.info("msg = {}", msg);

        messageProviderImpl.send(msg);

        return CommonResult.success("发送消息", msg);
    }
}
