package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Description
 * OrderServiceFallbackImpl
 * 兜底异常
 * <p>
 * Data
 * 2020/4/21-17:57
 *
 * @author zrx
 * @version 1.0
 */

@Service
public class OrderServiceFallbackImpl implements OrderService {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderServiceFallbackImpl.class);

    @Override
    public CommonResult<Integer> create(Payment payment) {
        return CommonResult.error("未知异常兜底", -1, 500);
    }

    @Override
    public CommonResult<Payment> getById(Long id) {
        return CommonResult.error("未知异常兜底", Payment.getNullPayment(), 500);
    }
}
