package com.zrx.config;

/**
 * Description
 * mybatis 的一些配置
 * <p>
 * Data
 * 23:29
 *
 * @author zrx
 * @version 1.0
 */

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //可以表中的 aaa_bbb 包装到 aaaBbb 字段上
//                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
