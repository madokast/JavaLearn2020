package com.zrx.fragment.concurrent.Java高并发程序设计葛一鸣;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Description
 * A02LockSupport
 * <p>
 * Data
 * 2020/7/12-17:14
 *
 * @author zrx
 * @version 1.0
 */

@SuppressWarnings("all")
@Invoking(createdTime = "2020-07-12 17:14")
public class A02LockSupport {
    private final static Logger LOGGER = LoggerFactory.getLogger(A02LockSupport.class);

    @Invoking(createdTime = "2020-07-12 17:14")
    public void resumeAndSuspend() throws InterruptedException {
        Thread t = new Thread(()->{
            while (true){}
        });

        t.start();
        TimeUnit.MILLISECONDS.sleep(100);

        LOGGER.info("t.getState() = {}", t.getState());

        t.suspend();
        TimeUnit.MILLISECONDS.sleep(100);

        LOGGER.info("t.getState() = {}", t.getState());

        t.stop();
        TimeUnit.MILLISECONDS.sleep(100);

        LOGGER.info("t.getState() = {}", t.getState());

        //2020-07-12 17:17:33.703  INFO 6416 --- [       latest-0] c.z.f.c.Java高并发程序设计葛一鸣.A02LockSupport    : t.getState() = RUNNABLE
        //2020-07-12 17:17:33.803  INFO 6416 --- [       latest-0] c.z.f.c.Java高并发程序设计葛一鸣.A02LockSupport    : t.getState() = RUNNABLE
        //2020-07-12 17:17:33.904  INFO 6416 --- [       latest-0] c.z.f.c.Java高并发程序设计葛一鸣.A02LockSupport    : t.getState() = TERMINATED
    }

    @Invoking(createdTime = "2020-07-12 17:19")
    public void parkAndUnpart() throws InterruptedException {
        Thread t = new Thread(()->{
            LOGGER.info("before park");
            LockSupport.park();
            LockSupport.park();
            LOGGER.info("after park");
        });

        t.start();
        TimeUnit.MILLISECONDS.sleep(100);

        LOGGER.info("t.getState() = {}", t.getState());

        LockSupport.unpark(t);
        TimeUnit.MILLISECONDS.sleep(100);

        LOGGER.info("t.getState() = {}", t.getState());

    }
}
