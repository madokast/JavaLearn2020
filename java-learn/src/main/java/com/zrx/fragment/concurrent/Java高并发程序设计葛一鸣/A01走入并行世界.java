package com.zrx.fragment.concurrent.Java高并发程序设计葛一鸣;

import com.zrx.Invoking;
import com.zrx.utils.ThreadUtils;
import com.zrx.utils.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description
 * Java高并发程序设计葛一鸣
 * A01走入并行世界
 * <p>
 * Data
 * 2020/5/10-17:54
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-05-10 19:40", info = "A01走入并行世界")
public class A01走入并行世界 {
    private final static Logger LOGGER = LoggerFactory.getLogger(A01走入并行世界.class);

    @Invoking(createdTime = "2020-05-10 19:41", info = "stopThread")
    public void stopThread() throws InterruptedException {
//        Thread t = new Thread(()->{
//            for(;;){
//                Thread.yield();
//                LOGGER.info("死循环");
//            }
//        });
//
//        t.start();
//
//        Thread.yield();
//
//        TimeUnit.MILLISECONDS.sleep(100);
//
//        LOGGER.info("call stop");
//
//        t.stop();
    }

    @Invoking(createdTime = "2020-05-10 20:07", info = "可中断锁")
    public void 可中断锁() {
        ReentrantLock lock = new ReentrantLock();

        try {
            lock.lockInterruptibly();
            // 临界区
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                // 释放锁
                lock.unlock();
            }
        }

        LOGGER.info("over");
    }

    @Invoking(createdTime = "2020-05-10 20:12", info = "tryLock")
    public void tryLock() {
        ReentrantLock lock = new ReentrantLock();

        try {
            if (lock.tryLock()) {
                // 临界区
            } else {
                // 没有拿到锁
            }
        } finally {
            if (lock.isHeldByCurrentThread()) {
                // 释放锁
                lock.unlock();
            }
        }
    }

    @Invoking(createdTime = "2020-05-10 20:17", info = "信号量")
    public void 信号量() {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 10; i++) {
            ThreadUtils.newThread(() -> {
                semaphore.acquireUninterruptibly();
                try {
                    int i1 = semaphore.availablePermits();
                    LOGGER.info("进入临界区，availablePermits={}", i1);
                    ThreadUtils.sleep(100);
                } finally {
                    semaphore.release();
                    LOGGER.info("离开临界区");
                }
            }, "信号量-" + i).start();
        }

        LOGGER.info("over");
    }

    @Invoking(createdTime = "2020-05-10 20:26", info = "读写锁")
    public void 读写锁() {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();

        LOGGER.info("这样使用读写锁");
    }

    @Invoking(createdTime = "2020-05-10 20:32", info = "倒计时器")
    public void 倒计时器() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            ThreadUtils.newThread(() -> {
                ThreadUtils.sleep((long) (Math.random() * 300));
                countDownLatch.countDown();
                LOGGER.info("完成检查");
            }, "倒计时器-" + i).start();
        }

        countDownLatch.await();

        LOGGER.info("火箭发射");
    }

    @Invoking(createdTime = "2020-05-10 20:44",info = "死循环")
    public void 死循环(){
//        for(;;){}
    }
}
