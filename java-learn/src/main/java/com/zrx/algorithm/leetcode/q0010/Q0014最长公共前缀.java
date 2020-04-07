package com.zrx.algorithm.leetcode.q0010;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * Description
 * 最长公共前缀
 * <p>
 * Data
 * 2020/4/5-12:24
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0014最长公共前缀 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0014最长公共前缀.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) new String[]{"flower", "flow", "flight"},
                (Object) new String[]{"dog", "racecar", "car"}
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create("fl", "");
    }

    @Code(info = {
            "编写一个函数来查找字符串数组中的最长公共前缀。\n" +
                    "如果不存在公共前缀，返回空字符串 \"\"。\n" +
                    "示例 1:\n" +
                    "输入: [\"flower\",\"flow\",\"flight\"]\n" +
                    "输出: \"fl\"\n" +
                    "示例 2:\n" +
                    "输入: [\"dog\",\"racecar\",\"car\"]\n" +
                    "输出: \"\"\n" +
                    "解释: 输入不存在公共前缀。\n" +
                    "说明:\n" +
                    "所有输入只包含小写字母 a-z 。\n",
            "执行用时 :1 ms, 在所有 Java 提交中击败了80.40%的用户"
    })
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int longest = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            longest = Math.min(longest, strs[i].length());
        }

        StringBuilder sb = new StringBuilder(longest);

        for (int i = 0; i < longest; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i))
                    return sb.toString();
            }

            sb.append(c);
        }


        return sb.toString();
    }
}
