package com.zrx.demo.utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TimerTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(TimerTest.class);

    @Test
    public void newStateTest(){
        com.zrx.demo.utils.Timer timer1 = com.zrx.demo.utils.Timer.create("timer1");
        com.zrx.demo.utils.Timer timer2 = com.zrx.demo.utils.Timer.create("timer2");
        com.zrx.demo.utils.Timer timer3 = com.zrx.demo.utils.Timer.create("timer3");
        com.zrx.demo.utils.Timer timer4 = com.zrx.demo.utils.Timer.create("timer4");

        timer1.start();
        timer2.stop();
        timer3.reset();
        long currentDuration = timer4.getCurrentDuration();
        LOGGER.info("currentDuration = {}", currentDuration);
    }

    @Test
    public void stopTest(){
        com.zrx.demo.utils.Timer timer1 = com.zrx.demo.utils.Timer.create("timer1");
        com.zrx.demo.utils.Timer timer2 = com.zrx.demo.utils.Timer.create("timer2");
        com.zrx.demo.utils.Timer timer3 = com.zrx.demo.utils.Timer.create("timer3");
        com.zrx.demo.utils.Timer timer4 = com.zrx.demo.utils.Timer.create("timer4");


        timer1.start();
        timer2.start();
        timer3.start();
        timer4.start();

        timer1.stop();
        timer2.stop();
        timer3.stop();
        timer4.stop();

        timer1.start();
        timer2.stop();
        timer3.reset();
        long currentDuration = timer4.getCurrentDuration();
        LOGGER.info("currentDuration = {}", currentDuration);
    }

    @Test
    public void firstStartTest(){
        com.zrx.demo.utils.Timer timer1 = com.zrx.demo.utils.Timer.create("timer1");
        com.zrx.demo.utils.Timer timer2 = com.zrx.demo.utils.Timer.create("timer2");
        com.zrx.demo.utils.Timer timer3 = com.zrx.demo.utils.Timer.create("timer3");
        com.zrx.demo.utils.Timer timer4 = com.zrx.demo.utils.Timer.create("timer4");

        timer1.start();
        timer2.start();
        timer3.start();
        timer4.start();

        timer1.start();
        timer2.stop();
        timer3.reset();
        long currentDuration = timer4.getCurrentDuration();
        LOGGER.info("currentDuration = {}", currentDuration);
    }

    @Test
    public void test01(){
        //测试用计时器01创建成功
        Timer timer = Timer.create("测试用计时器01");

        //测试用计时器01开始首次计时
        timer.start();

        //测试用计时器01正在计时，不要重复调用start
        timer.start();

        //测试用计时器01正在计时，不要重复调用start
        timer.start();

        ThreadUtils.sleep(200);

        //测试用计时器01停止计时
        timer.stop();

        //请先开始计时再调用stop方法
        timer.stop();

        //请先开始计时再调用stop方法
        timer.stop();

        //timer.getCurrentDuration() = 201
        LOGGER.info("timer.getCurrentDuration() = {}", timer.getCurrentDuration());

    }

    @Test
//    @SuppressWarnings("all")
    public void test02(){
        //测试用计时器02创建成功
        Timer timer = Timer.create("测试用计时器02");

        //请先开始计时再调用stop方法
        timer.stop();

        //测试用计时器02开始首次计时
        timer.start();

        ThreadUtils.sleep(100);
        //在运行状态调用getCurrentDuration
        //timer.getCurrentDuration() = 101
        LOGGER.info("timer.getCurrentDuration() = {}", timer.getCurrentDuration());
        LOGGER.info("timer.getCurrentDuration() = {}", timer.getCurrentDuration());

        ThreadUtils.sleep(100);
        //在运行状态调用getCurrentDuration
        //timer.getCurrentDuration() = 202
        LOGGER.info("timer.getCurrentDuration() = {}", timer.getCurrentDuration());

        //测试用计时器02停止计时
        timer.stop();
        //timer.getCurrentDuration() = 202
        LOGGER.info("timer.getCurrentDuration() = {}", timer.getCurrentDuration());
        ThreadUtils.sleep(100);
        //timer.getCurrentDuration() = 202
        LOGGER.info("timer.getCurrentDuration() = {}", timer.getCurrentDuration());


        //测试用计时器02再次开始计时，duration=202
        timer.start();
        LOGGER.info("timer.getCurrentDuration() = {}", timer.getCurrentDuration());
        ThreadUtils.sleep(100);
        //在运行状态调用getCurrentDuration
        //timer.getCurrentDuration() = 304
        LOGGER.info("timer.getCurrentDuration() = {}", timer.getCurrentDuration());

        timer.stop();

        LOGGER.info("timer.getCurrentDuration() = {}", timer.getCurrentDuration());

    }
}