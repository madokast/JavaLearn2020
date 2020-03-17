package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Description
 * 线程工具类
 * <p>
 * Data
 * 21:37
 *
 * @author zrx
 * @version 1.0
 */

public class ThreadUtils {
    private final static Logger LOGGER = LoggerFactory.getLogger(ThreadUtils.class);

    public static void sleep(long ms){
        try {
            Thread.sleep(ms);
        }catch (InterruptedException e){
            LOGGER.error("{}休眠被打断",Thread.currentThread().getName());
            e.printStackTrace();
        }
    }

}
