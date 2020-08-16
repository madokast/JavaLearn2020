package com.zrx.algorithm.leetcode.q0230;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 2的幂
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0231二的幂 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0231二的幂.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, 1, 16, 111
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, true, false
        );
    }

    @Code(info = """
            给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

            示例 1:

            输入: 1
            输出: true
            解释: 20 = 1
            示例 2:

            输入: 16
            输出: true
            解释: 24 = 16
            示例 3:

            输入: 218
            输出: false

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/power-of-two
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        else if (n == Integer.MIN_VALUE) return false;
        else return (n & (-n)) == n;

    }
}
