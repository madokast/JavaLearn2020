package com.zrx.algorithm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

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

    private static final String LEETCODE = "leetcode";

    private static final String OTHERS = "others";

    public static QuestionWrapper create(Question q) {
        String className = q.getClass().getName();

        if (className.contains(LEETCODE)) {
            return leetcodeQuestionWarp(q);
        } else {
            return new QuestionWrapper(q, OTHERS, -1, className, q.getClass().getAnnotation(Question.Code.class).info());
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
        this.number = number;
        this.name = name;
        this.info = info;
    }

    public static class QuestionWrapperNotFoundException extends Exception{}

    public final static String START = "__START__";
    public final static String END = "__END__";

    public void log(String info){
        if(logQueue==null){
            logQueue = new ConcurrentLinkedDeque<>();
            MyLoggerFactory.addListener(group+name,logQueue::offer);
        }

        logQueue.offer(info);
    }

    public void romeLogQueue(){
        MyLoggerFactory.removeListener(group+name);
        logQueue = null;
    }

    public String poll(){
        return logQueue.poll();
    }

    public void waitUntilHasNext(){
        while (logQueue.size()==0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public static class NoRunningQuestionException extends Exception{}

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
}
