package com.zrx.algorithm.leetcode.q0230;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Description
 * 用栈实现队列
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0232用栈实现队列 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0232用栈实现队列.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, true
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true
        );
    }

    @Code(info = """
            使用栈实现队列的下列操作：

            push(x) -- 将一个元素放入队列的尾部。
            pop() -- 从队列首部移除元素。
            peek() -- 返回队列首部的元素。
            empty() -- 返回队列是否为空。
             

            示例:

            MyQueue queue = new MyQueue();

            queue.push(1);
            queue.push(2);\040\040
            queue.peek();  // 返回 1
            queue.pop();   // 返回 1
            queue.empty(); // 返回 false
             

            说明:

            你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
            你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
            假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }

    class MyQueue {

        Deque<Integer> stack;
        Deque<Integer> help;


        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new LinkedList<>();
            help = new LinkedList<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (stack.size() != 1) help.push(stack.pop());

            Integer ret = stack.pop();

            while (!help.isEmpty()) stack.push(help.pop());


            return ret;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (stack.size() != 1) help.push(stack.pop());

            Integer ret = stack.pop();

            stack.push(ret);

            while (!help.isEmpty()) stack.push(help.pop());


            return ret;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
