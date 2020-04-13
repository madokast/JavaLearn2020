package com.zrx.fragment.concurrent;

import com.zrx.Invoking;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Description
 * InterruptTest
 * <p>
 * Data
 * 2020/4/10-21:27
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-04-10 21:28",info = "InterruptTest")
public class InterruptTest {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(InterruptTest.class);

    public void test(){
        Thread thread = new Thread();

        thread.interrupt();

        Thread.interrupted();

        thread.isInterrupted();
    }
}
