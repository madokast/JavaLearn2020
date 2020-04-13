package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Description
 * PaymentController
 * <p>
 * Data
 * 2020/4/13-21:13
 *
 * @author zrx
 * @version 1.0
 */


@RequestMapping("/payment")
@RestController
public class PaymentController {
    private final static Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        LOGGER.info("payment insert result={}", result);

        if (result > 0)
            return CommonResult.success("插入数据库成功", result);
        else
            return CommonResult.notFound("插入数据库失败", result);
    }


    @GetMapping("/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        Optional<Payment> optionalPayment = paymentService.getById(id);

        LOGGER.info("select payment={}", optionalPayment.orElse(null));

        return optionalPayment.
                map(payment -> CommonResult.success("查找成功", payment))
                .orElseGet(() -> CommonResult.notFound("查找失败,不存在", null));

    }

}
