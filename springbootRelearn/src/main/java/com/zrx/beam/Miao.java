package com.zrx.beam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description
 * @value 注入
 * <p>
 * Data
 * 10:37
 *
 * @author zrx
 * @version 1.0
 */

@Component
//@PropertySource("classpath:application.properties")
public class Miao {
    @Value("${miao.name}")
    private String name;

    @Value("${miao.age}")
    private Integer age;


    @Override
    public String toString() {
        return "Miao{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
