package com.zrx.fragment.Others;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * Description
 * 递归转为栈的一般方法
 * <p>
 * Data
 * 2020/6/28-11:31
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-06-28 11:31")
public class 递归转为栈的一般方法 {
    private final static Logger LOGGER = LoggerFactory.getLogger(递归转为栈的一般方法.class);

    public void hello() {
        LOGGER.info("hello");
    }


    @Invoking(createdTime = "2020-06-28 11:32")
    public void repeatStack手动() {
        int times;
        // Deque<Object[]> 这是一个栈
        // Object[] 栈帧
        Deque<Object[]> stack = new ArrayDeque<>(32);

        stack.push(new Object[]{2});

        times = (int) stack.peek()[0]; // 2

        // times > 0
        LOGGER.info("repeat"); // 执行前段

        stack.push(new Object[]{times - 1}); // 1

        times = (int) stack.peek()[0]; // 1

        // times > 0
        LOGGER.info("repeat"); // 执行前段

        stack.push(new Object[]{times - 1}); // 0

        // times > 0 不成立 ，直接退栈
        stack.pop();

        // 执行后短
        ;

        // 退栈
        stack.pop();

        // 执行后短
        ;

        // 退栈
        stack.pop();
    }


    public void repeatStackAuto失败() {
        class Frame {
            Object[] args;
            Consumer<Object[]> procedure;
            Object ret = null;

            public Frame(Consumer<Object[]> procedure, Object[] args) {
                this.procedure = procedure;
                this.args = args;
            }
        }
        int times = 2;

        Deque<Frame> stack = new ArrayDeque<>(32);

        stack.push(new Frame(
                args -> {
                    if ((Integer) args[0] > 0) {
                        LOGGER.info("repeat");
                    }
                },
                new Object[]{times}
        ));
    }

    @Invoking(createdTime = "2020-06-28 12:51")
    public void repeatStackAuto() {
        Deque<Integer> stack = new ArrayDeque<>(32);
        Deque<Integer> programCounters = new ArrayDeque<>(32);

        final int times = 2;

        stack.push(times);
        programCounters.push(0);

        while (!stack.isEmpty()) {
            int stackPeek = stack.peek();
            int pcPop = programCounters.pop();

            if (pcPop == 0) {
                if (stackPeek > 0) {
                    LOGGER.info("repeat-" + stackPeek);
                    stack.push(stackPeek - 1);
                    programCounters.push(1);
                    programCounters.push(0);
                } else {
                    stack.pop();
                }
            } else if (pcPop == 1) {
                stack.pop();
            }
        }
    }

    @Invoking(createdTime = "2020-06-28 12:53")
    public void repeat2() {
        repeat2(3);
        //2020-06-28 12:53:58.062  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if before-3
        //2020-06-28 12:53:58.062  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if before-2
        //2020-06-28 12:53:58.062  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if before-1
        //2020-06-28 12:53:58.062  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : out if = 0
        //2020-06-28 12:53:58.062  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if after-1
        //2020-06-28 12:53:58.062  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : out if = 1
        //2020-06-28 12:53:58.062  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if after-2
        //2020-06-28 12:53:58.062  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : out if = 2
        //2020-06-28 12:53:58.062  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if after-3
        //2020-06-28 12:53:58.062  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : out if = 3
    }

    @Invoking(createdTime = "2020-06-28 12:57")
    public void repeat2Stack() {
        final int times = 3;

        Deque<Integer> stack = new ArrayDeque<>(32);
        Deque<Integer> programCounters = new ArrayDeque<>(32);

        stack.push(times);
        programCounters.push(0);

        while (!stack.isEmpty()) {
            Integer t = stack.peek();
            Integer pc = programCounters.pop();

            if (pc == 0) {
                if (t > 0) {
                    LOGGER.info("in if before-" + t);
                    stack.push(t - 1);
                    programCounters.push(1);
                    programCounters.push(0);
                    continue;
                } else {
                    LOGGER.info("out if = {}", t);
                    stack.pop();
                }
            } else if (pc == 1) {
                LOGGER.info("in if after-" + t);
                LOGGER.info("out if = {}", t);
                stack.pop();
            }
        }

        //2020-06-28 12:57:54.873  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if before-3
        //2020-06-28 12:57:54.873  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if before-2
        //2020-06-28 12:57:54.873  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if before-1
        //2020-06-28 12:57:54.873  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : out if = 0
        //2020-06-28 12:57:54.873  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if after-1
        //2020-06-28 12:57:54.873  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : out if = 1
        //2020-06-28 12:57:54.873  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if after-2
        //2020-06-28 12:57:54.873  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : out if = 2
        //2020-06-28 12:57:54.873  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : in if after-3
        //2020-06-28 12:57:54.873  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : out if = 3
    }

    /**
     * 无返回值递归
     *
     * @param times 入参
     */
    private void repeat(int times) {
        if (times > 0) {
            LOGGER.info("repeat-" + times);
            repeat(times - 1);
        }
    }

    private void repeat2(int times) {
        if (times > 0) {
            LOGGER.info("in if before-" + times);
            repeat2(times - 1);
            LOGGER.info("in if after-" + times);
        }

        LOGGER.info("out if = {}", times);
    }

    @Invoking(createdTime = "2020-06-28 13:01")
    public void factorial() {
        int factorial = factorial(3);
        LOGGER.info("factorial = {}", factorial);
        //2020-06-28 13:02:36.038  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : enter
        //2020-06-28 13:02:36.039  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : else 3
        //2020-06-28 13:02:36.039  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : enter
        //2020-06-28 13:02:36.039  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : else 2
        //2020-06-28 13:02:36.039  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : enter
        //2020-06-28 13:02:36.039  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n==1
        //2020-06-28 13:02:36.039  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : factorial = 6
    }


    @Invoking(createdTime = "2020-06-28 13:14")
    public void factorialStack() {
        Deque<Object[]> stack = new ArrayDeque<>(32);
        Deque<Integer> pc = new ArrayDeque<>(32);

        Object[] args0 = new Object[]{null};
        Object[] args1 = new Object[]{null, 3};
        stack.push(args0);
        stack.push(args1);
        pc.push(0);

        while (stack.size() >= 2) {
            Integer n = (Integer) stack.peek()[1];
            Integer counter = pc.pop();

            switch (counter) {
                case 0:
                    LOGGER.info("enter");
                    if (n == 1) {
                        LOGGER.info("n==1");
                        stack.pop();
                        stack.peek()[0] = 1;
                    } else {
                        LOGGER.info("else {}", n);
                        stack.push(new Object[]{null, n - 1});
                        pc.push(1);
                        pc.push(0);
                    }
                    break;
                case 1:
                    int sub = (int) stack.peek()[0];
                    int ret = n * sub;
                    stack.pop();
                    stack.peek()[0] = ret;
            }
        }

        int factorial = (int) args0[0];
        LOGGER.info("factorial = {}", factorial);

        //2020-06-28 13:14:12.290  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : enter
        //2020-06-28 13:14:12.290  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : else 3
        //2020-06-28 13:14:12.290  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : enter
        //2020-06-28 13:14:12.290  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : else 2
        //2020-06-28 13:14:12.290  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : enter
        //2020-06-28 13:14:12.290  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n==1
        //2020-06-28 13:14:12.292  INFO 3776 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : factorial = 6
    }

    // 有返回值的递归
    private int factorial(int n) {
        LOGGER.info("enter");
        if (n == 1) {
            LOGGER.info("n==1");
            return 1;
        } else {
            LOGGER.info("else {}", n);
            int sub = factorial(n - 1);
            return n * sub;
        }
    }


    @Invoking(createdTime = "2020-06-28 13:20")
    public void fibonacci() {
        int fibonacci = fibonacci(5);
        LOGGER.info("fibonacci = {}", fibonacci);
        //2020-06-28 13:30:56.797  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n == 1 || n == 2 ret = 1
        //2020-06-28 13:30:56.797  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n1 = 1
        //2020-06-28 13:30:56.797  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n == 1 || n == 2 ret = 1
        //2020-06-28 13:30:56.797  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n2 = 1
        //2020-06-28 13:30:56.797  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : ret = 2
        //2020-06-28 13:30:56.797  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n1 = 2
        //2020-06-28 13:30:56.797  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n == 1 || n == 2 ret = 1
        //2020-06-28 13:30:56.797  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n2 = 1
        //2020-06-28 13:30:56.798  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : ret = 3
        //2020-06-28 13:30:56.798  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n1 = 3
        //2020-06-28 13:30:56.798  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n == 1 || n == 2 ret = 1
        //2020-06-28 13:30:56.798  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n1 = 1
        //2020-06-28 13:30:56.798  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n == 1 || n == 2 ret = 1
        //2020-06-28 13:30:56.798  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n2 = 1
        //2020-06-28 13:30:56.798  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : ret = 2
        //2020-06-28 13:30:56.798  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : n2 = 2
        //2020-06-28 13:30:56.798  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : ret = 5
        //2020-06-28 13:30:56.798  INFO 3668 --- [       latest-0] com.zrx.fragment.Others.递归转为栈的一般方法       : fibonacci = 5
    }


    @Invoking(createdTime = "2020-06-28 13:43")
    public void fibonacciStack() {
        Deque<Object[]> stack = new ArrayDeque<>(32);

        // 本方法，用于接受返回值
        Object[] self = new Object[]{null, null};
        stack.push(self);

        // 调用的第一层
        // [0] 程序计数器
        // [1] 返回值
        // [2] 入参
        // [3][4] 两个局部变量 n1 n2
        Object[] call = new Object[]{0, null, 5, null, null};
        stack.push(call);

        while (stack.size() >= 2) {
            Object[] peek = stack.peek();
            int counter = (int) peek[0];
            int n = (int) peek[2];

            int n1;
            int n2;
            switch (counter) {
                case 0:
                    if (n == 1 || n == 2) {
                        LOGGER.info("n == 1 || n == 2 ret = {}", 1);
                        stack.pop();
                        stack.peek()[1] = 1;
                    } else {
                        stack.peek()[0] = 1; // pc ——> 1
                        stack.push(new Object[]{0, null, n - 1, null, null});
                    }
                    break;
                case 1:
                    n1 = (int) peek[1]; // 返回值
                    LOGGER.info("n1 = {}", n1);
                    peek[3] = n1;
                    stack.peek()[0] = 2;
                    stack.push(new Object[]{0, null, n - 2, null, null});
                    break;
                case 2:
                    n2 = (int) peek[1];
                    LOGGER.info("n2 = {}", n2);
                    peek[4] = n2;
                    n1 = (int) peek[3];
                    stack.pop();
                    int ret = n1 + n2;
                    LOGGER.info("ret = {}", ret);
                    stack.peek()[1] = ret; // 返回
            }
        }


        int fibonacci = (int) self[1];
        LOGGER.info("fibonacci = {}", fibonacci);
    }

    // 分支递归
    private int fibonacci(int n) {
        if (n == 1 || n == 2) {
            LOGGER.info("n == 1 || n == 2 ret = {}", 1);
            return 1;
        } else {
            int n1 = fibonacci(n - 1);
            LOGGER.info("n1 = {}", n1);
            int n2 = fibonacci(n - 2);
            LOGGER.info("n2 = {}", n2);
            int ret = n1 + n2;
            LOGGER.info("ret = {}", ret);
            return ret;

            // 以上即
            //return factorial(n - 1) + factorial(n - 2);
        }
    }

    private static class Procedure {
        public Object[] context; // 上下文

        public Runnable runnable;
    }

}


