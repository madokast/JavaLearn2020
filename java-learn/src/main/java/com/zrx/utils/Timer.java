package com.zrx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * Description
 * 计时器
 * 状态设计模式
 * 计时器有四种状态 新建状态 停止状态 首次运行状态 再次运行状态
 * <p>
 * Data
 * 2020/3/18-13:25
 *
 * @author zrx
 * @version 1.0
 */

public class Timer {
    private final static Logger LOGGER = LoggerFactory.getLogger(Timer.class);

    private final String name;

    //计时器状态
    private State state;

    //开始时刻
    private long startTime;

    //计时时长
    private long duration;

    private Timer(String name) {
        this.name = name;
        this.state = State.NEW;
        this.duration = 0;
        LOGGER.debug("创建计时器/{}", this);
    }

    public synchronized void start() {
        switch (this.state) {
            case NEW:
                LOGGER.debug("NEW 状态下调用start/{}", name);
                this.state = State.FIRST_RUN;
                startTime = System.currentTimeMillis();
                break;
            case FIRST_RUN:
                LOGGER.debug("FIRST_RUN 状态下调用start/{}", name);
                LOGGER.warn("不要start一个已运行的计时器/{}", name);
                break;
            case STOP:
                LOGGER.debug("STOP 状态下调用start/{}", name);
                this.state = State.ONCE_AGAIN_RUN;
                startTime = System.currentTimeMillis();
                break;
            case ONCE_AGAIN_RUN:
                LOGGER.debug("ONCE_AGAIN_RUN 状态下调用start/{}", name);
                LOGGER.warn("不要start一个已运行的计时器/{}", name);
                break;
            default:
                throw new IllegalStateException("计时器状态非法/" + toString());
        }
    }

    public synchronized void stop() {
        switch (this.state) {
            case NEW:
                LOGGER.debug("NEW 状态下调用stop/{}", name);
                LOGGER.warn("请先开始运行计时器再停止/{}", name);
                break;
            case FIRST_RUN:
                LOGGER.debug("FIRST_RUN 状态下调用stop/{}", name);
                this.state = State.STOP;
                duration += System.currentTimeMillis() - startTime;
                break;
            case STOP:
                LOGGER.debug("STOP 状态下调用stop/{}", name);
                LOGGER.warn("不要停止一个已停止的计时器/{}", name);
                break;
            case ONCE_AGAIN_RUN:
                LOGGER.debug("ONCE_AGAIN_RUN 状态下调用stop/{}", name);
                this.state = State.STOP;
                duration += System.currentTimeMillis() - startTime;
                break;
            default:
                throw new IllegalStateException("计时器状态非法+" + toString());
        }
    }

    public synchronized void reset() {
        switch (this.state) {
            case NEW:
                LOGGER.debug("NEW 状态下调用reset/{}", name);
                break;
            case FIRST_RUN:
                LOGGER.debug("FIRST_RUN 状态下调用reset/{}", name);
                break;
            case STOP:
                LOGGER.debug("STOP 状态下调用reset/{}", name);
                duration = 0L;
                break;
            case ONCE_AGAIN_RUN:
                LOGGER.debug("ONCE_AGAIN_RUN 状态下调用reset/{}", name);
                duration = 0L;
                break;
            default:
                throw new IllegalStateException("计时器状态非法+" + toString());
        }
    }

    public synchronized long getCurrentDuration() {
        switch (this.state) {
            case NEW:
                LOGGER.debug("NEW 状态下调用getCurrentDuration/{}", name);
                Assert.isTrue(duration == 0L, "计时器内部数据非法");
                return 0L;
            case FIRST_RUN:
                LOGGER.debug("FIRST_RUN 状态下调用getCurrentDuration/{}", name);
                Assert.isTrue(duration == 0L, "计时器内部数据非法");
                return System.currentTimeMillis() - startTime;
            case STOP:
                LOGGER.debug("STOP 状态下调用getCurrentDuration/{}", name);
                return duration;
            case ONCE_AGAIN_RUN:
                LOGGER.debug("ONCE_AGAIN_RUN 状态下调用getCurrentDuration/{}", name);
                return duration + System.currentTimeMillis() - startTime;
            default:
                throw new IllegalStateException("计时器状态非法+" + toString());
        }
    }


    public static Timer create(String name) {
        return new Timer(name);
    }

    public static Timer create() {
        return new Timer("计时器" + "@" + Long.toHexString(System.currentTimeMillis() % 0xfff));
    }

    private enum State {
        //计时器有四种状态 新建 停止 首次运行 再次运行
        NEW, STOP, FIRST_RUN, ONCE_AGAIN_RUN
    }

    @Override
    public String toString() {
        return "Timer{" +
                "name='" + name + '\'' +
                ", state=" + state +
                ", startTime=" + startTime +
                ", duration=" + duration +
                '}';
    }
}
