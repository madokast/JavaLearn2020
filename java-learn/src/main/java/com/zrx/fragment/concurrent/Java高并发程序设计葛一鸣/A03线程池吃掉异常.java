package com.zrx.fragment.concurrent.Java高并发程序设计葛一鸣;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * Description
 * A03线程池吃掉异常
 * <p>
 * Data
 * 2020/7/12-17:36
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-07-12 17:36")
public class A03线程池吃掉异常 {
    private final static Logger LOGGER = LoggerFactory.getLogger(A03线程池吃掉异常.class);

    @Invoking(createdTime = "2020-07-12 17:36")
    public void test() throws InterruptedException {
        Runnable r = () -> LOGGER.info("ans={}", 1 / 0);
        Runnable r1 = () -> LOGGER.info("ans={}", 1 / 1);

        ExecutorService cachedThreadPool = new ThreadPoolExecutor(
                0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<>()
        ) {
            @Override
            public Future<?> submit(Runnable task) {
                return super.submit(new Runnable() {

                    Exception clientTrace;
                    {
                        try {
                            throw new Exception("Client Trace");
                        } catch (Exception e) {
                            clientTrace = e;
                        }
                    }

                    @Override
                    public void run() {
                        try {
                            task.run();
                        } catch (Throwable e) {
                            clientTrace.printStackTrace();
                            e.printStackTrace();
                        }
                    }
                });
            }

//            private StackTraceElement[] getCalledTraces() {
//                return Thread.currentThread().getStackTrace();
//            }
//
//            private Runnable wrap(Runnable r, StackTraceElement[] calledTraces) {
//                return () -> {
//                    try {
//                        r.run();
//                    } catch (Throwable t) {
//                        Arrays.stream(calledTraces).forEach(System.err::println);
//                        throw t;
//                    }
//                };
//            }
        };

        cachedThreadPool.submit(r);

        cachedThreadPool.submit(r1);

        cachedThreadPool.shutdown();

        cachedThreadPool.awaitTermination(1, TimeUnit.SECONDS);
    }
}
