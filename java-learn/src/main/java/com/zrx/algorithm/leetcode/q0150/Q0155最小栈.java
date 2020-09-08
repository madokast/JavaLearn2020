package com.zrx.algorithm.leetcode.q0150;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Description
 * Q0155最小栈
 * <p>
 * Data
 * 2020/7/2-21:59
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0155最小栈 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0155最小栈.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                true
        );
    }

    @Override
    public List<Answer> getAnswers() {
        boolean b = true;

        try {
            MinStack minStack = new MinStack();
            minStack.watch();
            minStack.push(-2);
            minStack.watch();
            minStack.push(0);
            minStack.watch();
            minStack.push(-3);
            minStack.watch();
            Assert.isTrue(minStack.getMin() == -3, "返回 -3.");
            minStack.watch();   //--> 返回 -3.
            minStack.pop();
            minStack.watch();
            Assert.isTrue(minStack.top() == 0, "返回 0.");
            minStack.watch();    // --> 返回 0.
            Assert.isTrue(minStack.getMin() == -2, "返回 -2.");
            minStack.watch(); //  --> 返回 -2.
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        }

        return AnswerFactory.create(
                b
        );
    }

    @Code(info = """
            设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

            push(x) —— 将元素 x 推入栈中。
            pop() —— 删除栈顶的元素。
            top() —— 获取栈顶元素。
            getMin() —— 检索栈中的最小元素。
             

            示例:

            输入：
            ["MinStack","push","push","push","getMin","pop","top","getMin"]
            [[],[-2],[0],[-3],[],[],[],[]]

            输出：
            [null,null,null,null,-3,null,0,-2]

            解释：
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin();   --> 返回 -3.
            minStack.pop();
            minStack.top();      --> 返回 0.
            minStack.getMin();   --> 返回 -2.
             

            提示：

            pop、top 和 getMin 操作总是在 非空栈 上调用。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/min-stack
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }


    class MinStack {

        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> minStack = new LinkedList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                minStack.push(Math.min(x, minStack.peek()));
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

        public void watch() {
            LOGGER.info("stack = {}", stack);
            LOGGER.info("minStack = {}", minStack);
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
