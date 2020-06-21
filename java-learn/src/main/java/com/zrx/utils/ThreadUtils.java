package com.zrx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private final static Logger LOGGER = MyLoggerFactory.getLogger(ThreadUtils.class);

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            LOGGER.error("{}休眠被打断", Thread.currentThread().getName());
            e.printStackTrace();
        }
    }

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("_, _ -> new")
    public static Thread newThread(Runnable r, String name) {
        return new Thread(r, name);
    }

    private static int timedRunNumber = 0;

    public static void timedRun(Runnable r, long time, TimeUnit timeUnit) {
        newThread(() -> {
            Thread t = newThread(r, "timedRun-worker-" + timedRunNumber);
            t.start();

            try {
                timeUnit.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (t.isAlive()) {
                    LOGGER.info("运行超时，强制结束线程{}", t.getName());
                    for (StackTraceElement stackTraceElement : t.getStackTrace()) {
                        LOGGER.info("{}", stackTraceElement);
                    }
                    t.stop();
                }
            }


        }, "timedRun-helper-" + (++timedRunNumber)).start();
    }


}
