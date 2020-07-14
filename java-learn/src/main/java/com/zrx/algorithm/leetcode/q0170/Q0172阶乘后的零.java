package com.zrx.algorithm.leetcode.q0170;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 阶乘后的零
 * <p>
 * Data
 * 2020/7/6-9:22
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0172阶乘后的零 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0172阶乘后的零.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                3,
                5
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                0, 1
        );
    }

    @Code(info = """
            给定一个整数 n，返回 n! 结果尾数中零的数量。

            示例 1:

            输入: 3
            输出: 0
            解释: 3! = 6, 尾数中没有零。
            示例 2:

            输入: 5
            输出: 1
            解释: 5! = 120, 尾数中有 1 个零.
            说明: 你算法的时间复杂度应为 O(log n) 。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int trailingZeroes(int n) {
        int ans = 0;

        while (n >= 5) {
            n = n / 5;
            ans += n;
        }

        return ans;
    }
}
