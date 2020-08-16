package com.zrx.algorithm.leetcode.q0260;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import org.springframework.stereotype.Component;
/**
 * Description
 * 丑数
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0263丑数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0263丑数.class);

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

            编写一个程序判断给定的数是否为丑数。

            丑数就是只包含质因数 2, 3, 5 的正整数。

            示例 1:

            输入: 6
            输出: true
            解释: 6 = 2 × 3
            示例 2:

            输入: 8
            输出: true
            解释: 8 = 2 × 2 × 2
            示例 3:

            输入: 14
            输出: false\040
            解释: 14 不是丑数，因为它包含了另外一个质因数 7。
            说明：

            1 是丑数。
            输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
            """)
    public boolean isUgly(int num) {
return false;
    }
}
