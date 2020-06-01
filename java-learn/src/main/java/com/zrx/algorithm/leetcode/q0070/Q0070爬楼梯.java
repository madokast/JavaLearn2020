package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 爬楼梯
 * <p>
 * Data
 * 2020/5/31-13:39
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0070爬楼梯 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0070爬楼梯.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                2,
                3, 4, 5, 6
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2, 3, 5, 8, 13);
    }

    @Code(info = """
            假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

            每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

            注意：给定 n 是一个正整数。

            示例 1：

            输入： 2
            输出： 2
            解释： 有两种方法可以爬到楼顶。
            1.  1 阶 + 1 阶
            2.  2 阶
            示例 2：

            输入： 3
            输出： 3
            解释： 有三种方法可以爬到楼顶。
            1.  1 阶 + 1 阶 + 1 阶
            2.  1 阶 + 2 阶
            3.  2 阶 + 1 阶

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/climbing-stairs
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;

        int c0 = 1;
        int c1 = 1;

        for (int i = 1; i < n; i++) {
            int t = c0 + c1;
            c0 = c1;
            c1 = t;
        }


        return c1;
    }
}
