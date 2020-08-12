package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 基本计算器 II
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0227基本计算器II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0227基本计算器II.class);

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
            实现一个基本的计算器来计算一个简单的字符串表达式的值。

            字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

            示例 1:

            输入: "3+2*2"
            输出: 7
            示例 2:

            输入: " 3/2 "
            输出: 1
            示例 3:

            输入: " 3+5 / 2 "
            输出: 5
            说明：

            你可以假设所给定的表达式都是有效的。
            请不要使用内置的库函数 eval。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/basic-calculator-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int calculate(String s) {
return -1;
    }
}
