package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Description
 * OrderController
 * <p>
 * Data
 * 2020/5/2-15:19
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class OrderController {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String server_url;

    @GetMapping("/echo/{string}")
    @SentinelResource(
            value = "echo",
            blockHandler = "echo_blockHandler",
            fallback = "echo_fallback"
    )
    public Object echo(@PathVariable String string) {
        if("a".equals(string))
            throw new RuntimeException("运行期异常");

        String forObject = restTemplate.getForObject(server_url + "/provider/echo/" + string, String.class);

        return "来自服务提供者:" + forObject;
    }

    public Object echo_blockHandler(String s, BlockException e){
        return s+" "+e + " from echo_blockHandler";
    }

    public Object echo_fallback(String s,Throwable e){
        return s+" "+e + " from echo_fallback";
    }
}
