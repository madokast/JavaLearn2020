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

    @GetMapping("get/{id}")
//    @HystrixCommand(fallbackMethod = "getByIdFallback",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100")
//    })
    // 注释上面三行，执行兜底的异常处理
    public CommonResult<?> getById(@PathVariable("id") Long id) {
        LOGGER.info("getById id = {}", id);
        return orderService.getById(id);
    }

    public CommonResult<?> getByIdFallback(Long id) {
        LOGGER.info("getByIdFallback id = {}", id);
        return CommonResult.requestTimeout("服务超时", Payment.getNullPayment());
    }
}
