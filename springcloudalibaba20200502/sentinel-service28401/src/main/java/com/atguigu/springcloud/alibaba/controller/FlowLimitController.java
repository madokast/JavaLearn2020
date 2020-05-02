package com.atguigu.springcloud.alibaba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * FlowLimitController
 * <p>
 * Data
 * 2020/5/2-22:55
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class FlowLimitController {
    private final static Logger LOGGER = LoggerFactory.getLogger(FlowLimitController.class);

    @GetMapping("/test1")
    public Object test1() {
        return "-------test1" + Math.random();
    }

    @GetMapping("/test2")
    public Object test2() {
        return "-------test2" + Math.random();
    }
}
