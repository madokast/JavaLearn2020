package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.istack.internal.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
@DefaultProperties(defaultFallback = "defaultFallbackMethod")
public class PaymentController {
    private final static Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    /**
     * 正常业务
     */
    @PostMapping(value = "/create")
    @HystrixCommand
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        LOGGER.info("payment insert result={}", result);

        if (result > 0)
            return CommonResult.success("插入数据库成功" + serverFrom(), result);
        else
            return CommonResult.notFound("插入数据库失败" + serverFrom(), result);
    }


    /**
     * 暂停3秒
     */
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "getByIdFallbackForTimeout",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        LOGGER.info("进入getById");
        int timeOut = 3;
        try { TimeUnit.SECONDS.sleep(timeOut);} catch (InterruptedException ignore) {
            LOGGER.info("被打断了？");
        }
        LOGGER.info("超时{}秒结束", timeOut);

        Map<String, String> infoMap = new HashMap<>();
        infoMap.put("线程名", Thread.currentThread().getName());
        infoMap.put("服务提供者", serverFrom());
        infoMap.put("动作", "耗时" + timeOut + "秒，不插入，返回-1");

        LOGGER.info("infoMap = {}", infoMap);

        return CommonResult.notFound(infoMap.toString(), null);
    }

    public CommonResult<Payment> getByIdFallbackForTimeout(Long id) {
        LOGGER.info("进入getByIdFallbackForTimeout");
        return CommonResult.requestTimeout("请求超时", Payment.getNullPayment());
    }

    public CommonResult<Nullable> defaultFallbackMethod(){
        return CommonResult.notFound("默认兜底",null);
    }


    private String serverFrom() {
        return "-- 服务提供者的端口号是" + port + " --";
    }
}
