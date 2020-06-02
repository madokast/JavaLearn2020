package com.zrx.algorithm.leetcode.q0080;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0084柱状图中最大的矩形.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
        return -1;
    }
}
