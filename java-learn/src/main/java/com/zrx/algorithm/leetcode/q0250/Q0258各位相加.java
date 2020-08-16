package com.zrx.algorithm.leetcode.q0250;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import org.springframework.stereotype.Component;
/**
 * Description
 * 各位相加
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0258各位相加 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0258各位相加.class);

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
            给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

            示例:

            输入: 38
            输出: 2\040
            解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
            进阶:
            你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/add-digits
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int addDigits(int num) {
return -1;
    }
}
