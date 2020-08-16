package com.zrx.algorithm.leetcode.q0270;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 整数转换英文表示
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0273整数转换英文表示 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0273整数转换英文表示.class);

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
            将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 。

            示例 1:

            输入: 123
            输出: "One Hundred Twenty Three"
            示例 2:

            输入: 12345
            输出: "Twelve Thousand Three Hundred Forty Five"
            示例 3:

            输入: 1234567
            输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
            示例 4:

            输入: 1234567891
            输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/integer-to-english-words
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String numberToWords(int num) {
        return null;
    }
}
