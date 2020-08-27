package com.zrx.algorithm.leetcode.q0240;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Description
 * 有效的字母异位词
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0242有效的字母异位词 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0242有效的字母异位词.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "anagram", "nagaram",
                "rat", "cat"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, false
        );
    }

    @Code(info = """
            给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

            示例 1:

            输入: s = "anagram", t = "nagaram"
            输出: true
            示例 2:

            输入: s = "rat", t = "car"
            输出: false
            说明:
            你可以假设字符串只包含小写字母。

            进阶:
            如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/valid-anagram
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            Integer time = map.get(c);
            if (time == null || time == 0) return false;
            else if (time == 1) map.remove(c);
            else map.put(c, time - 1);
        }

        return map.isEmpty();
    }
}
