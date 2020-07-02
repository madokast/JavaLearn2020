package com.zrx.algorithm.leetcode.q0150;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
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
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
        return -1;
    }
}
