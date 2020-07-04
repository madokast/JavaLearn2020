package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 分数到小数
 * <p>
 * Data
 * 2020/7/4-22:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0166分数到小数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0166分数到小数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create();
    }

    @Code(info = """
            给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

            如果小数部分为循环小数，则将循环的部分括在括号内。

            示例 1:

            输入: numerator = 1, denominator = 2
            输出: "0.5"
            示例 2:

            输入: numerator = 2, denominator = 1
            输出: "2"
            示例 3:

            输入: numerator = 2, denominator = 3
            输出: "0.(6)"

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fractionToDecimal(int numerator, int denominator) {
        return null;
    }
}
