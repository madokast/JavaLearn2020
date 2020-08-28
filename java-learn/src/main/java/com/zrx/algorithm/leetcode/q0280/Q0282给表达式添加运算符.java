package com.zrx.algorithm.leetcode.q0280;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 给表达式添加运算符
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0282给表达式添加运算符 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0282给表达式添加运算符.class);

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
            给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。

            示例 1:

            输入: num = "123", target = 6
            输出: ["1+2+3", "1*2*3"]\040
            示例 2:

            输入: num = "232", target = 8
            输出: ["2*3+2", "2+3*2"]
            示例 3:

            输入: num = "105", target = 5
            输出: ["1*0+5","10-5"]
            示例 4:

            输入: num = "00", target = 0
            输出: ["0+0", "0-0", "0*0"]
            示例 5:

            输入: num = "3456237490", target = 9191
            输出: []

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/expression-add-operators
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> addOperators(String num, int target) {
        return null;
    }
}
