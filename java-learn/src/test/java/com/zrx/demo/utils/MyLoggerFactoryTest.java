package com.zrx.demo.utils;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MyLoggerFactoryTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyLoggerFactoryTest.class);


    @Test
    void addListenerOnBean() {
    }
}