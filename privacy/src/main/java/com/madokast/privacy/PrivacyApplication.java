package com.madokast.privacy;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Path;


@SpringBootApplication
@EnableCaching // 开启基于注解的缓存
@EnableRabbit //开启 rabbitMq
@EnableAsync // 开启 异步任务
@EnableScheduling // 开启定时任务
public class PrivacyApplication {

    public static void main(String[] args) {
        NonSpring.writeRunningInfo();
        SpringApplication.run(PrivacyApplication.class, args);
    }
}
