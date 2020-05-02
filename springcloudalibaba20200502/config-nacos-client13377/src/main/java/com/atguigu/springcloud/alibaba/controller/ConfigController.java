package com.atguigu.springcloud.alibaba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * ConfigController
 * <p>
 * Data
 * 2020/5/2-15:59
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RefreshScope // 支持动态刷新
public class ConfigController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public Object info() {
        return configInfo;
    }
}
