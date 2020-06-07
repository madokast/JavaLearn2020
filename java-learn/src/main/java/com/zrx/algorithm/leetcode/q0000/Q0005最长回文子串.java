package com.zrx.algorithm.leetcode.q0000;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0005最长回文子串
 * <p>
 * Data
 * 2020/3/30-0:36
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0005最长回文子串 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0005最长回文子串.class);

    @Override
    public List<Input> getInputs() {
        return List.of(
                Input.create("babad"),
                Input.create("cbbd")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return List.of(
                Answer.create("bab"),
                Answer.create("bb")
        );
    }

    @Code(info = {
            "给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。\n" +
                    "示例 1：\n" +
                    "输入: \"babad\"\n" +
                    "输出: \"bab\"\n" +
                    "注意: \"aba\" 也是一个有效答案。\n" +
                    "示例 2：\n" +
                    "输入: \"cbbd\"\n" +
                    "输出: \"bb\"\n"
    })
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int maxLen = 0;
        int maxPoint = 0;
        boolean after = false;

        for (int i = 0; i < s.length(); i++) {
            int at = longestPalindromeAt(s, i);
            int aft = longestPalindromeAfter(s, i);

            LOGGER.info("i = {}", i);

            LOGGER.info("longestPalindromeAt(s,i) = {}", longestPalindromeAt(s, i));
            LOGGER.info("longestPalindromeAfter(s,i) = {}", longestPalindromeAfter(s, i));

            if (at > aft) {
                if (at > maxLen) {
                    maxLen = Math.max(maxLen, at);
                    maxPoint = i;
                    after = false;
                }
            } else {
                if (aft > maxLen) {
                    maxLen = Math.max(maxLen, aft);
                    maxPoint = i;
                    after = true;
                }
            }
        }

        LOGGER.info("maxLen = {}", maxLen);
        LOGGER.info("maxPoint = {}", maxPoint);
        LOGGER.info("after = {}", after);

        if (after) {
            return s.substring(maxPoint - maxLen / 2 + 1, maxPoint - maxLen / 2 + 1 + maxLen);
        } else {
            return s.substring(maxPoint - maxLen / 2, maxPoint - maxLen / 2 + maxLen);
        }
    }


    private int longestPalindromeAt(String s, int index) {
        int length = 1;
        int left = index;
        int right = index;
        while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
            length += 2;
            left--;
            right++;
        }

        return length;
    }

    private int longestPalindromeAfter(String s, int index) {
        int length = 0;
        int left = index;
        int right = index + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            length += 2;
            left--;
            right++;
        }

        return length;

    }
}
