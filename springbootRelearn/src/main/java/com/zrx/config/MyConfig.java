package com.zrx.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * Description
 * 配置类
 * <p>
 * Data
 * 23:45
 *
 * @author zrx
 * @version 1.0
 */


@Configuration //这是一个配置类，替代之前的spring配置文件
public class MyConfig {

    Logger logger = LoggerFactory.getLogger(MyConfig.class);

    //以前在spring配置文件中使用<bean> 配置组件
    //默认id即方法名
    @Bean
    public Object someBean(){
//        System.out.println("someBean 初始化成功");
        logger.info("someBean 初始化成功");
        return Collections.singleton("someBean，通过配置类配置");
    }
}
