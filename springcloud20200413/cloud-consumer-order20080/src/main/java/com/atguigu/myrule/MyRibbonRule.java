package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 * MyRibbonRule
 * <p>
 * Data
 * 2020/4/20-19:33
 *
 * @author zrx
 * @version 1.0
 */

@Configuration
public class MyRibbonRule {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyRibbonRule.class);

    /**
     * 替换 算法
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule(); // 随机
    }
}
