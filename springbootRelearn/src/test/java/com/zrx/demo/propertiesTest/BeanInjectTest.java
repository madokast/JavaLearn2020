package com.zrx.demo.propertiesTest;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * Description
 * 配置类注入测试
 * <p>
 * Data
 * 23:49
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootTest
public class BeanInjectTest {
    @Autowired
    ApplicationContext ioc;

    private final Logger LOGGER = LoggerFactory.getLogger(BeanInjectTest.class);

    @Test
    public void contextLoads(){
        LOGGER.info("ioc.containsBean(\"someBean\") = " + ioc.containsBean("someBean"));
//        System.out.println("ioc.containsBean(\"someBean\") = " + ioc.containsBean("someBean"));
    }
}
