package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0066加一
 * <p>
 * Data
 * 2020/5/28-13:55
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0066加一 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0066加一.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(1, 2, 3),
                ArrayFactory.create(4, 3, 2, 1),
                ArrayFactory.create(9),
                ArrayFactory.create(9, 9)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ArrayFactory.create(1, 2, 4),
                ArrayFactory.create(4, 3, 2, 2),
                ArrayFactory.create(1, 0),
                ArrayFactory.create(1, 0, 0)
        );
    }

    @Code(info = """
            给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

            最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

            你可以假设除了整数 0 之外，这个整数不会以零开头。

            示例 1:

            输入: [1,2,3]
            输出: [1,2,4]
            解释: 输入数组表示数字 123。
            示例 2:

            输入: [4,3,2,1]
            输出: [4,3,2,2]
            解释: 输入数组表示数字 4321。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/plus-one
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[] plusOne(int[] digits) {
        int carry = 1;

        int length = digits.length;

        for (int i = length - 1; i >= 0; i--) {
            digits[i] += carry;

            if (digits[i] == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                return digits;
            }
        }

        int[] ret = new int[length + 1];
        ret[0] = 1;

        return ret;
    }
}
