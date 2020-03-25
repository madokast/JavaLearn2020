package com.zrx.utils;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MyLoggerFactoryTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyLoggerFactoryTest.class);


    @Test
    void addListenerOnBean() {
    }
}