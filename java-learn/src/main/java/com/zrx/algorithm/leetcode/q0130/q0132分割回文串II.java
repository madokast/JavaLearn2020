package com.zrx.algorithm.leetcode.q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 分割回文串 II
 * <p>
 * Data
 * 2020/6/21-17:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class q0132分割回文串II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(q0132分割回文串II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "aab",
                "abcdcba",
                "abcdcb",
                "ccaacabacb"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                1, 0, 1, 3
        );
    }

    @Code(info = """
            给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

            返回符合要求的最少分割次数。

            示例:

            输入: "aab"
            输出: 1
            解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int minCut(String s) {
        int sLen = s.length();
        int[] dp = new int[sLen + 1];
        Arrays.fill(dp, s.length() - 1);
        dp[0] = -1;

        for (int i = 0; i < sLen; i++) {
            int maxPalindromeLengthAt = maxPalindromeLengthAt(s, i);
//            LOGGER.info("i = {}", i);
//            LOGGER.info("maxPalindromeLengthAt = {}", maxPalindromeLengthAt);
            int rightAt = i + maxPalindromeLengthAt / 2 + 1;
            int leftAt = i - maxPalindromeLengthAt / 2;
            while (rightAt > leftAt) {
                dp[rightAt] = Math.min(dp[leftAt] + 1, dp[rightAt]);
                rightAt--;
                leftAt++;
            }

//            LOGGER.info("dp[{}]=dp[{}]+1", rightAt, leftAt);
//            LOGGER.info("dp = {}", dp);


            int maxPalindromeLengthRight = maxPalindromeLengthRight(s, i);
//            LOGGER.info("i = {}", i);
//            LOGGER.info("maxPalindromeLengthRight = {}", maxPalindromeLengthRight);
            int rightR = i + maxPalindromeLengthRight / 2 + 1;
            int leftR = i - maxPalindromeLengthRight / 2 + 1;
            while (rightR>leftR){
                dp[rightR] = Math.min(dp[leftR] + 1, dp[rightR]);
                rightR--;
                leftR++;
            }

//            LOGGER.info("dp[{}]=dp[{}]+1", i + maxPalindromeLengthRight / 2 + 1, i - maxPalindromeLengthRight / 2 + 1);
//            LOGGER.info("dp = {}", dp);
        }

        LOGGER.info("dp = {}", dp);
        return dp[sLen];
    }

    private int maxPalindromeLengthAt(String s, int i) {
        int max = 1;
        int left = i - 1;
        int right = i + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            max += 2;
        }

        return max;
    }

    private int maxPalindromeLengthRight(String s, int i) {
        int max = 0;
        int left = i;
        int right = i + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            max += 2;
        }

        return max;
    }

}
