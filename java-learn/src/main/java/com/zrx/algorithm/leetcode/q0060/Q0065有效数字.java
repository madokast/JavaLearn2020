package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 有效数字
 * <p>
 * Data
 * 2020/5/28-13:28
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0065有效数字 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0065有效数字.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "0"," 0.1","abc","e","."
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(true,true,false,false,false);
    }

    @Code(info = """
            验证给定的字符串是否可以解释为十进制数字。

            例如:

            "0" => true
            " 0.1 " => true
            "abc" => false
            "1 a" => false
            "2e10" => true
            " -90e3   " => true
            " 1e" => false
            "e3" => false
            " 6e-1" => true
            " 99e2.5 " => false
            "53.5e93" => true
            " --6 " => false
            "-+3" => false
            "95a54e53" => false

            说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：

            数字 0-9
            指数 - "e"
            正/负号 - "+"/"-"
            小数点 - "."
            当然，在输入中，这些字符的上下文也很重要。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/valid-number
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isNumber(String s) {
        java.util.regex.Pattern compile = java.util.regex.Pattern.compile(
                "^\\s*[+-]?(\\d+\\.?\\d*|\\d*\\.?\\d+)(e[+-]?\\d+)?\\s*$"
        );
        return compile.matcher(s).matches();
    }
}
