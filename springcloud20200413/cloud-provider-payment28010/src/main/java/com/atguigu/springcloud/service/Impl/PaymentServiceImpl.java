package com.atguigu.springcloud.service.Impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Description
 * PaymentServiceImpl
 * <p>
 * Data
 * 2020/4/13-21:11
 *
 * @author zrx
 * @version 1.0
 */

@Service
public class PaymentServiceImpl implements PaymentService {
    private final static Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Optional<Payment> getById(Long id) {
        return Optional.ofNullable(paymentDao.getById(id));
    }
}
