package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 * OrderController
 * <p>
 * Data
 * 2020/4/21-12:24
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/consumer/payment")
public class OrderController {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Resource // 注入接口，自动实现
    private OrderService orderService;

    @PostMapping("/create")
    public CommonResult<?> create(@RequestBody Payment payment) {
        LOGGER.info("payment = {}", payment);
        return orderService.create(payment);
    }


    // 服务熔断
    @GetMapping("get/{id}")
    @HystrixCommand(fallbackMethod = "getByIdFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开始熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 失败率达到多少后跳闸
    })
    public CommonResult<?> getById(@PathVariable("id") Long id) {
        LOGGER.info("getById id = {}", id);

        if (id < 0)
            throw new RuntimeException("id[" + id + "]不能为负数");

        return orderService.getById(id);
    }

    public CommonResult<?> getByIdFallback(Long id) {
        return CommonResult.badRequest("id[" + id + "]不能为负数", null);
    }
}
