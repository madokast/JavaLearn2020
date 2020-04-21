package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Description
 * PaymentService
 * <p>
 * Data
 * 2020/4/13-21:10
 *
 * @author zrx
 * @version 1.0
 */

public interface PaymentService {
    /**
     *
     * @param payment payment
     * @return i>0 表示插入成功
     */
    int create(Payment payment);

    Optional<Payment> getById(@Param("id") Long id);
}
