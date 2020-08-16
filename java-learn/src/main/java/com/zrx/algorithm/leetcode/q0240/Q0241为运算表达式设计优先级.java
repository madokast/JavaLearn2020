package com.zrx.algorithm.leetcode.q0240;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import org.springframework.stereotype.Component;
/**
 * Description
 * 为运算表达式设计优先级
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0241为运算表达式设计优先级 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0241为运算表达式设计优先级.class);

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
            给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
            你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

            示例 1:

            输入: "2-1-1"
            输出: [0, 2]
            解释:\040
            ((2-1)-1) = 0\040
            (2-(1-1)) = 2
            示例 2:

            输入: "2*3-4*5"
            输出: [-34, -14, -10, -10, 10]
            解释:\040
            (2*(3-(4*5))) = -34\040
            ((2*3)-(4*5)) = -14\040
            ((2*(3-4))*5) = -10\040
            (2*((3-4)*5)) = -10\040
            (((2*3)-4)*5) = 10

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<Integer> diffWaysToCompute(String input) {
return null;
    }
}
