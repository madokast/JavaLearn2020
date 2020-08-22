package com.madokast.learnspringframework.test01;

import com.madokast.learnspringframework.bean.Hello;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description
 * HelloWorld
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class HelloWorld {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    @Test
    public void hello() {

        ApplicationContext ioc = new ClassPathXmlApplicationContext("hello.xml");

        Hello hello = (Hello) ioc.getBean("hello");

        Assert.assertEquals(hello.getAge(), Integer.valueOf(10));

        Assert.assertEquals(hello.getName(), "zrx");

    }
}
