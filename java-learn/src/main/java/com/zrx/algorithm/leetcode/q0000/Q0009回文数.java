package com.zrx.algorithm.leetcode.q0000;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 回文数
 * <p>
 * Data
 * 2020/3/31-21:19
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0009回文数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0009回文数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1, 121, -121, 10);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(true, false, false);
    }

    @Code(info = {
            "判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。\n" +
                    "示例 1:\n" +
                    "输入: 121\n" +
                    "输出: true\n" +
                    "示例 2:\n" +
                    "输入: -121\n" +
                    "输出: false\n" +
                    "解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。\n" +
                    "示例 3:\n" +
                    "输入: 10\n" +
                    "输出: false\n" +
                    "解释: 从右向左读, 为 01 。因此它不是一个回文数。\n" +
                    "进阶:\n" +
                    "你能不将整数转为字符串来解决这个问题吗？\n"
    })
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int pre = x;

        int reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse == pre;
    }
}
