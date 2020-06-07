package com.zrx.algorithm.leetcode.q0000;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 * Q0003无重复字符的最长子串
 * Data
 * 2020/3/29-22:55
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0003无重复字符的最长子串 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0003无重复字符的最长子串.class);

    @Override
    public List<Input> getInputs() {
        return List.of(
                Input.create("abcabcbb"),
                Input.create("bbbbb"),
                Input.create("pwwkew")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return List.of(
                Answer.create(3),
                Answer.create(1),
                Answer.create(3)
        );
    }

    @Code(info = {
            "给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。",
            "示例 1:",
            "输入: \"abcabcbb\"",
            "输出: 3 ",
            "解释: 因为无重复字符的最长子串是 \"abc\"，所以其长度为 3。",
            "示例 2:",
            "输入: \"bbbbb\"",
            "输出: 1",
            "解释: 因为无重复字符的最长子串是 \"b\"，所以其长度为 1。",
            "示例 3:",
            "输入: \"pwwkew\"",
            "输出: 3",
            "解释: 因为无重复字符的最长子串是 \"wke\"，所以其长度为 3。",
            "     请注意，你的答案必须是 子串 的长度，\"pwke\" 是一个子序列，不是子串",
            "很明显，滑动窗口法"
    })
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 1;

        map.put(s.charAt(0), 0);

        int max = 1;
        while (j < s.length()) {
            // look j
            char c = s.charAt(j);

            Integer val = map.get(c);
            if (val != null && val >= i)
                i = val + 1;

            map.put(c, j);
            j++;

            max = Math.max(max, j - i);
        }


        return max;
    }
}
