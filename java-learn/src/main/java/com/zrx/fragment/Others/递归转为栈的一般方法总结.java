package com.zrx.fragment.Others;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Description
 * 递归转为栈的一般方法总结
 * <p>
 * Data
 * 2020/6/28-13:48
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-06-28 14:38")
public class 递归转为栈的一般方法总结 {
    private final static Logger LOGGER = LoggerFactory.getLogger(递归转为栈的一般方法总结.class);

    @Invoking(createdTime = "2020-06-28 14:38")
    public void test() {
        for (int i = 0; i < 10; i++) {
            int fibonacciNoRecur = fibonacciNoRecur(i);
            int fibonacci = fibonacci(i);
            LOGGER.info("fibonacciNoRecur = {}", fibonacciNoRecur);

            Assert.isTrue(fibonacci == fibonacciNoRecur, "error");
        }
    }

    int fib(int n) {
        return n < 2 ? 1 : fib(n - 1) + fib(n - 2);
    }

    // 递归
//    int fibonacci(int n) {
//        if (n == 0 || n == 1) {
//            return 1;
//        } else {
//            return fibonacci(n - 1) + fibonacci(n - 2);
//        }
//    }

//    int fibonacci(int n) {
//        if (n == 0 || n == 1) {
//            return 1;
//        } else {
//            // 把函数调用的返回值，存入局部变量
//            int localVariable0 = fibonacci(n - 1);
//            int localVariable1 = fibonacci(n - 2);
//            return localVariable0 + localVariable1;
//        }
//    }

    int fibonacci(int n) {
        // flag 0 函数入口
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int return0 = fibonacci(n - 1);
            // flag 1 第一个函数调用结束

            // 拿到第一个函数的返回值
            int localVariable0 = return0;

            int return1 = fibonacci(n - 2);
            // flag 2 第二个函数调用结束

            // 拿到第二个函数的返回值
            int localVariable1 = return1;

            return localVariable0 + localVariable1;
        }
    }


    // 非递归
    int fibonacciNoRecur(int n) {
        // 栈
        Deque<Object[]> stack = new ArrayDeque<>(64); // 调用层数最大 64

        // 当前函数(fibonacciNoRecur)的栈帧，栈帧size=1,仅用来接受递归调用的返回值
        Object[] frameOfFibonacciNoRecur = {null};
        stack.push(frameOfFibonacciNoRecur); // 入栈

        // 函数调用第一层
        // 栈帧含义：
        // [0] 装上层函数的返回值
        // [1] flag，标记递归函数执行的位置
        // [2] 入参，只有一个，即 n
        // [3] [4] 两个局部变量
        Object[] callFrame = {null, 0, n, null, null};
        stack.push(callFrame);

        // 如果栈大于 1，表示递归没有结束
        while (stack.size() > 1) {
            // 获取当前栈帧，peek()不退栈
            Object[] frame = stack.peek();

            // 当前入参
            int arg0 = (int) frame[2];

            // 当前 flag 标志位
            int flag = (int) frame[1];


            switch (flag) {
                case 0: // flag == 0 函数入口
                    if (arg0 == 0 || arg0 == 1) {
                        // 退栈
                        stack.pop();
                        // 将返回值给调用者，即此时栈顶栈帧 0 号位置
                        stack.peek()[0] = 1;
                    } else {
                        // 函数调用，开辟栈空间
                        stack.push(new Object[]{null, 0, arg0 - 1, null, null});
                        // 修改当前栈帧的 flag=1
                        frame[1] = 1;
                    }
                    break;
                case 1: // flag == 1 第一个函数调用结束
                    // 拿到返回值，位于当前栈帧的 0 号位置
                    int return1 = (int) frame[0];
                    // 将返回值存入局部变量
                    frame[3] = return1;

                    // 第二次函数调用
                    stack.push(new Object[]{null, 0, arg0 - 2, null, null});
                    // 修改当前栈帧的 flag=2
                    frame[1] = 2;
                    break;
                case 2:
                    // 拿到返回值，位于当前栈帧的 0 号位置
                    int return2 = (int) frame[0];
                    // 将返回值存入局部变量
                    frame[4] = return2;

                    // 取出局部变量
                    int localVariable0 = (int) frame[3];
                    int localVariable1 = (int) frame[4];

                    // 退栈
                    stack.pop();
                    // 将返回值给调用者，即此时栈顶栈帧 0 号位置
                    stack.peek()[0] = localVariable0 + localVariable1;
            }
        }

        // 递归调用结束，此时栈顶即当前函数(fibonacciNoRecur)的栈帧
        frameOfFibonacciNoRecur = stack.pop();

        return (int) frameOfFibonacciNoRecur[0];
    }


    /////////////////////////////////////

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            int result = factorial(n - 1);
            return n * result;
        }
    }

    @SuppressWarnings("all")
    public int factorialNoReCur(int n) {
        Deque<Object[]> stack = new LinkedList<>(); //函数调用栈

        //本函数[factorialNoReCur]的栈帧，仅仅用来接受返回值。用于简化代码
        Object[] currentFrame = new Object[]{null};
        stack.push(currentFrame); // 入栈

        Object[] firstLayerFrame = new Object[]{null, 0, n}; //递归调用第一层，构建栈帧
        stack.push(firstLayerFrame); //入栈

        while (stack.size() > 1) {//栈尺寸 > 1 说明递归没有结束，否则栈中只剩下 currentFrame
            Object[] frame = stack.peek();// 拿到顶部栈帧，不退栈。顶部栈帧即当前函数的工作空间
            int flag = (int) frame[1];// flag标记
            int arg = (int) frame[2];// 入参，只有一个
            switch (flag) {
                case 0: // flag==0，表示从头开始执行
                    if (arg == 1) {
                        stack.pop(); //退栈
                        stack.peek()[0] = 1; //把返回值写入退栈后的栈顶中，0号位置。这样调用当前函数的人就能拿到
                    } else {
                        stack.push(new Object[]{null, 0, arg - 1}); // 函数调用，新建栈帧
                        frame[1] = 1; // 当前栈帧的 flag 改成 1，说明函数调用后从 1 位置执行
                    }
                    break;
                case 1:// flag==1，表示第一次方法调用后执行
                    int result = (int) frame[0]; // 拿到函数调用后的返回值
                    stack.pop(); // 退栈
                    stack.peek()[0] = arg * result; //把返回值写入退栈后的栈顶中
            }
        }

        int result = (int) stack.pop()[0]; // 拿到返回值，就是递归调用的结果
        return result;
    }

    @Invoking(createdTime = "2020-06-28 20:41")
    public void factorialNoReCurTest() {
        for (int i = 1; i < 8; i++) {
            int f = factorialNoReCur(i);
            LOGGER.info("f = {}", f);
        }
    }


}
