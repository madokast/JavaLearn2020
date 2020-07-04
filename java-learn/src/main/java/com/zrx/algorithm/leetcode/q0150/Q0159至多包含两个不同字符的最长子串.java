package com.zrx.algorithm.leetcode.q0150;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 至多包含两个不同字符的最长子串
 * <p>
 * Data
 * 2020/7/2-21:59
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0159至多包含两个不同字符的最长子串 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0159至多包含两个不同字符的最长子串.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "eceba",
                "ccaabbb",
                "a",
                "aac",
                "abaccc",
                "eceba",
                "abcabcabc"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                3, 5, 1, 3, 4, 3, 2
        );
    }

    @Code(info = """
            给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。

            示例 1:

            输入: "eceba"
            输出: 3
            解释: t 是 "ece"，长度为3。
            示例 2:

            输入: "ccaabbb"
            输出: 5
            解释: t 是 "aabbb"，长度为5。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char c1 = '\0';
        int c1Pos = 0;
        int c1PosMax = 0;
        char c2 = '\0';
        int c2Pos = 0;
        int c2PosMax = 0;

        int max = 0;

        char[] ss = s.toCharArray();
        int length = ss.length;
        for (int i = 0; i < length; i++) {
            char c = ss[i];

            if (c1 == '\0') {
                c1 = c;
                c1Pos = i;
            } else {
                if (c1 != c && c2 == '\0') {
                    c2 = c;
                    c2Pos = i;
                } else {
                    if (!(c1 == c || c2 == c)) {
                        // full
                        char pre = ss[i - 1];
                        if (pre == c1) {
                            c2 = c;
                            c2Pos = i;
                            c1Pos = c2PosMax + 1;
                        } else {
                            c1 = c;
                            c1Pos = i;
                            c2Pos = c1PosMax + 1;
                        }
                    }
                }
            }
            if (c1 == c) c1PosMax = i;
            if (c2 == c) c2PosMax = i;

            LOGGER.info("o = {}", ToString.arrayToFormatString(new Object[]{c, c1, c2, c1Pos, c2Pos, i}));
            max = Math.max(max, i - Math.min(c1Pos, c2Pos) + 1);
        }


        return max;
    }
}
