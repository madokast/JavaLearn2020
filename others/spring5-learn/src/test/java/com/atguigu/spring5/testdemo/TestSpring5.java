package com.atguigu.spring5.testdemo;


import com.atguigu.spring5.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description
 * TestSpring5
 * <p>
 * Data
 * 2020/7/14-21:44
 *
 * @author zrx
 * @version 1.0
 */

public class TestSpring5 {

    @Test
    public void testUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        User bean1 =(User) context.getBean("user1");

        bean1.add();
    }

}
