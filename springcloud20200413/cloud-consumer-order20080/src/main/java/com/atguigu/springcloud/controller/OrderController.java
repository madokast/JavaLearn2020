package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.netflix.loadbalancer.IRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Description
 * OrderController
 * <p>
 * Data
 * 2020/4/13-22:15
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/consumer/payment")
public class OrderController {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private RestTemplate restTemplate;

    // 写死
    //private static final String PAYMENT_URL = "http://192.168.2.13:28001/payment";

    // 服务名称
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/create")
    public CommonResult<?> create(@RequestBody Payment payment) {
        LOGGER.info("consumer create payment={}", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);

    }

    @GetMapping("get/{id}")
    public CommonResult<?> getById(@PathVariable("id") Long id) {
        LOGGER.info("consumer get by id={}", id);

        return restTemplate.getForObject(PAYMENT_URL + "/get/" + id, CommonResult.class);
    }

    @GetMapping("getForEntity/{id}")
    public CommonResult<?> getByIdForEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity =
                restTemplate.getForEntity(PAYMENT_URL + "/get/" + id, CommonResult.class);

        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        }else {
            return CommonResult.notFound("没有找到",404);
        }
    }
}
