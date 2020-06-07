package com.zrx.algorithm.leetcode.q0080;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Stack;

/**
 * Description
 * 柱状图中最大的矩形
 * <p>
 * Data
 * 2020/6/2-11:50
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0084柱状图中最大的矩形 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0084柱状图中最大的矩形.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(2, 1, 5, 6, 2, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(10);
    }

    @Code(info = """
            给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

            求在该柱状图中，能够勾勒出来的矩形的最大面积。

            以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

            图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

            示例:

            输入: [2,1,5,6,2,3]
            输出: 10

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i];

            if (stack.empty() || heights[stack.peek()] <= cur)
                stack.push(i);
            else {
                while (!stack.empty() && heights[stack.peek()] > cur) {
                    //LOGGER.info("stack = {}", stack);

                    Integer pop = stack.pop();
                    int pre = stack.empty() ? -1 : stack.peek();
                    int len = i - pre - 1;
                    int h = heights[pop] * len;
                    //LOGGER.info("pre pop*len = {},{}*{}", pre, pop, len);
                    max = Math.max(max, h);
                }

                stack.push(i);
            }
        }

        while (!stack.empty()){
            Integer pop = stack.pop();
            int pre = stack.empty() ? -1 : stack.peek();
            int len = heights.length - pre - 1;
            int h = heights[pop] * len;
            max = Math.max(max, h);
        }


        return max;
    }
}
