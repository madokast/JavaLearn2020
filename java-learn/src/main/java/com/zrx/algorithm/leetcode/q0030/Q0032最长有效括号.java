package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 最长有效括号
 * <p>
 * Data
 * 2020/5/13-17:44
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0032最长有效括号 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0032最长有效括号.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "(()",
                ")()())",
                "()(())"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2, 4, 6);
    }

    @Code(info = """
            给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

            示例 1:

            输入: "(()"
            输出: 2
            解释: 最长有效括号子串为 "()"
            示例 2:

            输入: ")()())"
            输出: 4
            解释: 最长有效括号子串为 "()()"

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/longest-valid-parentheses
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int longestValidParentheses(String s) {
        int length = s.length();
        int[] maxValidLengthEndAt = new int[length];

        int max = 0;

        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                //maxValidLengthEndAt[i] = 0;
            } else {
                char cc = s.charAt(i - 1);
                if (cc == '(') {
                    if (i - 2 > 0) {
                        maxValidLengthEndAt[i] = maxValidLengthEndAt[i - 2] + 2;
                    } else {
                        maxValidLengthEndAt[i] = 2;
                    }
                } else {
                    int len = maxValidLengthEndAt[i - 1];

                    int index = i - len - 1;

                    if (index >= 0) {
                        if (s.charAt(index) == '(') {
                            maxValidLengthEndAt[i] = len + 2;
                            if (index > 0) {
                                maxValidLengthEndAt[i] += maxValidLengthEndAt[index - 1];
                            }
                        }
                    } else {
                        //maxValidLengthEndAt[i] = 0;
                    }
                }
            }

            max = Math.max(max, maxValidLengthEndAt[i]);
        }

        return max;
    }
}
