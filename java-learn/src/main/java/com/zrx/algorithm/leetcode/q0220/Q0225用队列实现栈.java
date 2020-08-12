package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 用队列实现栈
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0225用队列实现栈 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0225用队列实现栈.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            使用队列实现栈的下列操作：

            push(x) -- 元素 x 入栈
            pop() -- 移除栈顶元素
            top() -- 获取栈顶元素
            empty() -- 返回栈是否为空
            注意:

            你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
            你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
            你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/implement-stack-using-queues
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }

    class MyStack {

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {

        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return -1;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return -1;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return false;
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
