package com.zrx;

import com.zrx.beam.Dog;
import com.zrx.beam.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 */

@SpringBootApplication
public class SpringbootRelearnApplication {
    public static void main(String[] args) {
        //启动
        SpringApplication.run(SpringbootRelearnApplication.class, args);
    }
}
