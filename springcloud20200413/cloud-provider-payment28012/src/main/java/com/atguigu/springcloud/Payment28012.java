package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * Description
 * Payment28001
 * main entry
 * <p>
 * Data
 * 2020/4/13-20:30
 *
 * @author zrx
 * @version 1.0
 */

@EnableHystrix
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class Payment28012 {
    private final static Logger LOGGER = LoggerFactory.getLogger(Payment28012.class);

    public static void main(String[] args) {
        SpringApplication.run(Payment28012.class, args);
    }


    /**
     * 为了 hystrix dashboard 服务监控本服务而配置
     *
     * @return servlet
     */
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> forHystrixMonitor() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);

        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");

        return registrationBean;
    }
}
