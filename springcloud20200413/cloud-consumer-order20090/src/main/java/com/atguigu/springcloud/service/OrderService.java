package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * Description
 * OrderService
 * 直接复制自 payment controller 28010
 * <p>
 * Data
 * 2020/4/21-12:21
 *
 * @author zrx
 * @version 1.0
 */

@Service
@FeignClient(name = "CLOUD-PAYMENT-SERVICE", fallback = OrderServiceFallbackImpl.class)
public interface OrderService {


    @PostMapping(value = "/payment/create")
    CommonResult<Integer> create(@RequestBody Payment payment);

    /**
     * 暂停3秒
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id);

}
