package com.atguigu.springcloud.alibaba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Description
 * OrderController
 * <p>
 * Data
 * 2020/5/2-15:19
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class OrderController {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String server_url;

    @GetMapping("/echo/{string}")
    public Object echo(@PathVariable String string) {
        String forObject = restTemplate.getForObject(server_url + "/provider/echo/" + string, String.class);

        return "来自服务提供者:" + forObject;
    }
}
