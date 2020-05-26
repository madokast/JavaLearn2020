package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0050幂函数POW
 * <p>
 * Data
 * 2020/5/24-21:44
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0050幂函数POW implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0050幂函数POW.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                2.00000, 10,
                2.10000, 3,
                2.00000, -2
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                1024.0,
                9.26100,
                0.25000
        );
    }

    @Code(info = """
            实现 pow(x, n) ，即计算 x 的 n 次幂函数。

            示例 1:

            输入: 2.00000, 10
            输出: 1024.00000
            示例 2:

            输入: 2.10000, 3
            输出: 9.26100
            示例 3:

            输入: 2.00000, -2
            输出: 0.25000
            解释: 2-2 = 1/22 = 1/4 = 0.25
            说明:

            -100.0 < x < 100.0
            n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/powx-n
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == +0 || x == -0)
            return 0;
        if (x == 1)
            return 1;
        if (n == -1)
            return 1 / x;

        double v = myPow(x, n / 2);

        if (n % 2 == 0)
            return v * v;
        else {
            if (n > 0)
                return v * v * x;
            else
                return v * v / x;
        }
    }
}
