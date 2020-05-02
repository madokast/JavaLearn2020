package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.PaymentService;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Description
 * OrderFeignController
 * <p>
 * Data
 * 2020/4/20-21:58
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/consumer/payment")
public class OrderFeignController {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderFeignController.class);

    @Resource // 注入接口，自动实现
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult<?> create(@RequestBody Payment payment) {
        LOGGER.info("payment = {}", payment);
        return paymentService.create(payment);
    }

    @GetMapping("get/{id}")
    public CommonResult<?> getById(@PathVariable("id") Long id) {
        LOGGER.info("id = {}", id);
        return paymentService.getById(id);
    }
}
