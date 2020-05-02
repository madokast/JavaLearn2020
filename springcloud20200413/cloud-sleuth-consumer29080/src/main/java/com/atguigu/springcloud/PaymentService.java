package com.atguigu.springcloud;


import com.atguigu.springcloud.config.FeignConfig;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

/**
 * Description
 * PaymentService
 * <p>
 * Data
 * 2020/4/20-21:50
 *
 * @author zrx
 * @version 1.0
 */

@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE") // 服务名字
public interface PaymentService {
    /**
     *
     * @param payment payment
     * @return i>0 表示插入成功
     */
    @PostMapping("payment/create")
    CommonResult<Integer> create(@RequestBody Payment payment);

    @GetMapping("payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id);
}
