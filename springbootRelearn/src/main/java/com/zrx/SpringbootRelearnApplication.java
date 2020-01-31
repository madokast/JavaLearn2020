package com.zrx;

import com.zrx.beam.Dog;
import com.zrx.beam.Person;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContextInitializer;
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

    private void springboot启动原理() {
        // run()
        //准备环境
        {
//            ApplicationContextInitializer applicationContextInitializer;
//              applicationContextInitializer.initialize();

            //监听器
//            SpringApplicationRunListener springApplicationRunListener;
//            springApplicationRunListener.contextPrepared();

            //加载主配置类定义信息

            //监听器
//            SpringApplicationRunListener springApplicationRunListener;
//            springApplicationRunListener.contextLoaded();
        }

        //刷新启动IOC容器
        {
            //扫描加载所有容器中的组件
            //包括META-INF/spring.factories 中所有的 EnableAutoConfiguration 组件
        }

//        回调容器中所有的
//        ApplicationRunner applicationRunner;
//        applicationRunner.run();

//        CommandLineRunner commandLineRunner;
//        commandLineRunner.run();
        //以上两个run 方法
    }

    private void 四个重要的回调函数(){
//        SpringApplicationRunListener springApplicationRunListener;
//        springApplicationRunListener.contextPrepared();
//
//        SpringApplicationRunListener springApplicationRunListener;
//        springApplicationRunListener.contextLoaded();
//
//        ApplicationRunner applicationRunner;
//        applicationRunner.run();
//
//        CommandLineRunner commandLineRunner;
//        commandLineRunner.run();


    }


}
