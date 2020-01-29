package com.zrx.demo.logTest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description
 * 日志测试
 * <p>
 * Data
 * 11:29
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootTest
public class LogTest {
    //日志记录器
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test01(){
        logger.trace("这是trace日志");

        //日记级别
        //可以调整日志输出级别

        logger.debug("这是debug日志");

        logger.info("这是info日志");

        logger.warn("这是warn日志");

        logger.error("这是error日志");



        //默认下，只输出info级别
        //11:33:16.375 [main] DEBUG com.zrx.demo.logTest.LogTest - 这是debug日志
        //11:33:16.377 [main] INFO com.zrx.demo.logTest.LogTest - 这是info日志
        //11:33:16.377 [main] WARN com.zrx.demo.logTest.LogTest - 这是warn日志
        //11:33:16.377 [main] ERROR com.zrx.demo.logTest.LogTest - 这是error日志
    }

    //不要使用Lombok
//    @Test
//    public void test02(){
//
//    }
}
