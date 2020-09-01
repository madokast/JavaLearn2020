package com.zrx.algorithm.leetcode.q0300;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 累加数
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0306累加数5 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0306累加数5.class);

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
            累加数是一个字符串，组成它的数字可以形成累加序列。

            一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。

            给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。

            说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

            示例 1:

            输入: "112358"
            输出: true\040
            解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
            示例 2:

            输入: "199100199"
            输出: true\040
            解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
            进阶:
            你如何处理一个溢出的过大的整数输入?

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/additive-number
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isAdditiveNumber(String num) {
        return false;
    }
}
