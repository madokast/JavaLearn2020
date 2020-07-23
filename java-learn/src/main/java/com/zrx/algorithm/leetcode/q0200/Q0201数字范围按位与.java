package com.zrx.algorithm.leetcode.q0200;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 数字范围按位与
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0201数字范围按位与 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0201数字范围按位与.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                5, 7,
                0, 1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                4, 0
        );
    }

    @Code(info = """
            给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

            示例 1: 

            输入: [5,7]
            输出: 4
            示例 2:

            输入: [0,1]
            输出: 0

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int rangeBitwiseAnd(int m, int n) {
        if (n == 0 || m == 0) return 0;
        if (m == n) return m;

        int oldN = n;

        // 找前缀1
        int prefix = 0;
        while (true) {
            int mi = (m & 0x80000000);
            m <<= 1;
            int ni = (n & 0x80000000);
            n <<= 1;

            if (mi == ni) {
                prefix++;
            } else {
                break;
            }

            if (n == 0 || m == 0) break;
        }

        prefix = 32 - prefix;

        oldN >>>= prefix;
        oldN <<= prefix;

        return oldN;
    }
}
