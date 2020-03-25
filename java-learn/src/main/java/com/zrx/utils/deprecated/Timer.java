package com.zrx.utils.deprecated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * 计时器
 * 三个动作：开始计时、停止计时、复位
 * 可以计时多段时间
 * <p>
 * 当计时器处于 停止 状态时，duration 即记录的时长
 * 当计时器处于 运行 状态时 duration + (currentTime - startTime) 表示记录的时长
 * <p>
 * Data
 * 2020/3/18-12:13
 *
 * @author zrx
 * @version 1.0
 */

@Deprecated
public class Timer {
    private final static Logger LOGGER = LoggerFactory.getLogger(Timer.class);

    // 记录经过的时间
    private long duration = 0L;

    // -1L 表示没有记过时
    private long startTime;

    // 是否正在计时
    private boolean counting = false;

    // 计时器的名字
    private String name;

    private Timer() {
        this("计时器" + System.currentTimeMillis() % 100);
    }

    private Timer(String name) {
        this.name = name;
        LOGGER.info("{}创建成功", name);
    }

    public static Timer creat(String name) {
        return new Timer(name);
    }

    public static Timer creat() {
        return new Timer();
    }

    /**
     * 开始计时
     */
    public void start() {
        if (counting) {
            // 已经开始计时了
            LOGGER.warn("{}正在计时，不要重复调用start", name);
            // 无动作
        } else {
            // 当前没有计时
            counting = true;
            startTime = System.currentTimeMillis();
            if (duration == 0L) {
                LOGGER.debug("{}开始首次计时", name);
            } else {
                LOGGER.debug("{}再次开始计时，duration={}", name, duration);
            }
        }
    }

    /**
     * 停止计时
     */
    public void stop() {
        if (counting) {
            // 正在计时 停止时记录 duration
            LOGGER.debug("{}停止计时", name);
            counting = false;
            duration += System.currentTimeMillis() - startTime;
        } else {
            LOGGER.warn("请先开始计时再调用stop方法");
            // 无动作
        }
    }

    /**
     * 复位
     * 在 运行状态 和 停止状态 调用都可以
     */
    public void reset() {
        duration = 0L;
    }

    public long getCurrentDuration() {
        if (counting) {
            LOGGER.debug("在运行状态调用getCurrentDuration");
            //正在运行
            return duration + (System.currentTimeMillis() - startTime);
        } else {
            return duration;
        }
    }
}
