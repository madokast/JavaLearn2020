package com.zrx.algorithm.leetcode.q0020;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 有效的括号
 * <p>
 * Data
 * 2020/4/10-23:25
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0020有效的括号 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0020有效的括号.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(true, true, false, false, true);
    }

    @Code(info = {
            "给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。\n" +
                    "有效字符串需满足：\n" +
                    "左括号必须用相同类型的右括号闭合。\n" +
                    "左括号必须以正确的顺序闭合。\n" +
                    "注意空字符串可被认为是有效字符串。\n" +
                    "示例 1:\n" +
                    "输入: \"()\"\n" +
                    "输出: true\n" +
                    "示例 2:\n" +
                    "输入: \"()[]{}\"\n" +
                    "输出: true\n" +
                    "示例 3:\n" +
                    "输入: \"(]\"\n" +
                    "输出: false\n" +
                    "示例 4:\n" +
                    "输入: \"([)]\"\n" +
                    "输出: false\n" +
                    "示例 5:\n" +
                    "输入: \"{[]}\"\n" +
                    "输出: true\n"
    })
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeft(c))
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                Character pop = stack.pop();
                if (!isValid(pop, c))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isValid(char c1, char c2) {
        switch (c1) {
            case '[':
                return c2 == ']';
            case '(':
                return c2 == ')';
            case '{':
                return c2 == '}';
            default:
                return false;
        }
    }
}
