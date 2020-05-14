package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey", blockHandler = "deal_hotKey")
    public String hotKeyTest(
            @RequestParam(value = "p1", required = false) String p1,
            @RequestParam(value = "p2", required = false) String p2
            ) {
        return "----hot key " + p1 + " " + p2;
    }

    // 兜底方法
    public String deal_hotKey(String p1, String p2, BlockException e) {
        return "----deal hot key " + p1 + " " + p2 + " " + e;
    }
}
