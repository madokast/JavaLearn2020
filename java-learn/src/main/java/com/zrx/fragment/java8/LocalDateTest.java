package com.zrx.fragment.java8;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Description
 * LocalDateTest
 * <p>
 * Data
 * 2020/3/28-22:40
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-03-28 22:40",info = "LocalDateTest")
public class LocalDateTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(LocalDateTest.class);

    @Invoking(createdTime = "2020-03-28 22:40",info = "LocalDateTest")
    public void test(){
        LocalDate yyyyMMdd = LocalDate.parse("20200328", DateTimeFormatter.ofPattern("yyyyMMdd"));

        LOGGER.info("yyyyMMdd = {}", yyyyMMdd);
        //2020-03-28 22:41:45.415  INFO 6824 --- [           main] com.zrx.fragment.java8.LocalDateTest              : yyyyMMdd = 2020-03-28
    }
}
