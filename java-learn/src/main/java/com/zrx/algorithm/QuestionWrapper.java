package com.zrx.algorithm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zrx.Invoking;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description
 * Question 的包装类
 * 带上这个类的信息
 * <p>
 * Data
 * 2020/3/24-13:51
 *
 * @author zrx
 * @version 1.0
 */

public class QuestionWrapper {
    private final static Logger LOGGER = LoggerFactory.getLogger(QuestionWrapper.class);

    @JsonIgnore
    private Question question;

    private String group;

    private int number;

    private String name;

    private String[] info;

    private Queue<String> logQueue;

    public static final String LEETCODE = "leetcode";

    public static final String OTHERS = "others";

    private static final AtomicInteger autoNumber = new AtomicInteger(0);

    public static QuestionWrapper create(Question q) {
        String className = q.getClass().getName();

        if (className.contains(LEETCODE)) {
            return leetcodeQuestionWarp(q);
        } else {
            return new QuestionWrapper(q, q.getGroup(), q.getNumber(), q.getInfo()[0], q.getInfo());
        }
    }

    private static QuestionWrapper leetcodeQuestionWarp(Question q) {
        String className = q.getClass().getName();
        String[] info = q.getInfo();
        int lastIndexOfDot = className.lastIndexOf(".");

        String name = className.substring(lastIndexOfDot + 6);

        int num = Integer.parseInt(className.substring(lastIndexOfDot + 2, lastIndexOfDot + 6));

        return new QuestionWrapper(q, LEETCODE, num, name, info);
    }

    public QuestionWrapper(Question question, String group, int number, String name, String[] info) {
        this.question = question;
        this.group = group;
        this.number = number == -1 ? autoNumber.getAndIncrement() : number;
        this.name = name;
        this.info = info;
    }

    public static class QuestionWrapperNotFoundException extends Exception {
    }

    public final static String START = "__START__";
    public final static String END = "__END__";
    public boolean removing = false; // 时间过长自动移除

    public void log(String info) {
        if (logQueue == null) {
            removing = false;
            logQueue = new ConcurrentLinkedDeque<>();
            MyLoggerFactory.addListener(group + name, logQueue::offer);
        }

        logQueue.offer(info);

        if (!removing) {
            removing = true;
            new Thread(() -> {
                try {
                    Thread.sleep(30 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (MyLoggerFactory.hasListener(group + name)) {
                    LOGGER.info("时间过长[30秒]，自动移除listener和queue");
                    removeLogQueue();
                }

            }).start();


        }
    }

    public void removeLogQueue() {
        MyLoggerFactory.removeListener(group + name);
        logQueue = null;
    }

    public String poll() {
        if (logQueue == null) {
            LOGGER.warn("queue 已被移除，但是还有人想poll，说明有人没有读到END");
            return null;
        } else {
            return logQueue.poll();
        }
    }

    public void waitUntilHasNext() {
        while (logQueue.size() == 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public static class NoRunningQuestionException extends Exception {
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getLEETCODE() {
        return LEETCODE;
    }

    public static String getOTHERS() {
        return OTHERS;
    }

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "QuestionWrapper{" +
                "number=" + number +
                ", logQueue=" + logQueue +
                '}';
    }
}
