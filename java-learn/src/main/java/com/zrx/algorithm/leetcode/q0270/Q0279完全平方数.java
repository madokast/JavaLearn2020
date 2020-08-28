package com.zrx.algorithm.leetcode.q0270;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 完全平方数
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0279完全平方数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0279完全平方数.class);

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
            给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

            示例 1:

            输入: n = 12
            输出: 3\040
            解释: 12 = 4 + 4 + 4.
            示例 2:

            输入: n = 13
            输出: 2
            解释: 13 = 4 + 9.

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/perfect-squares
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int numSquares(int n) {
return -1;
    }
}
