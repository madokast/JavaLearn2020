package com.atguigu.springcloud.alibaba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * NacosProvider19001
 * <p>
 * Data
 * 2020/5/2-14:47
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider19001 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider19001.class, args);
    }

}