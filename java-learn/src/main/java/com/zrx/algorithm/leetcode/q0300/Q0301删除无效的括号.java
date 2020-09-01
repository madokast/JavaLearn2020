package com.zrx.algorithm.leetcode.q0300;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 删除无效的括号
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0301删除无效的括号 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0301删除无效的括号.class);

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
            删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

            说明: 输入可能包含了除 ( 和 ) 以外的字符。

            示例 1:

            输入: "()())()"
            输出: ["()()()", "(())()"]
            示例 2:

            输入: "(a)())()"
            输出: ["(a)()()", "(a())()"]
            示例 3:

            输入: ")("
            输出: [""]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> removeInvalidParentheses(String s) {
return null;
    }
}
