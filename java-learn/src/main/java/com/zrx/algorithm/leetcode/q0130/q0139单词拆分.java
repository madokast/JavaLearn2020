package com.zrx.algorithm.leetcode.q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description
 * 单词拆分
 * <p>
 * Data
 * 2020/6/21-17:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class q0139单词拆分 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(q0139单词拆分.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "leetcode", List.of("leet", "code"),
                "applepenapple", List.of("apple", "pen"),
                "catsandog", List.of("cats", "dog", "sand", "and", "cat"),
                "aa", List.of("a")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, true, false, true
        );
    }

    @Code(info = """
            给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

            说明：

            拆分时可以重复使用字典中的单词。
            你可以假设字典中没有重复的单词。
            示例 1：

            输入: s = "leetcode", wordDict = ["leet", "code"]
            输出: true
            解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
            示例 2：

            输入: s = "applepenapple", wordDict = ["apple", "pen"]
            输出: true
            解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
                 注意你可以重复使用字典中的单词。
            示例 3：

            输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
            输出: false

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/word-break
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>();
        int wordLenMax = 0;
        for (String d : wordDict) {
            //if (wordBreak(d, new ArrayList<>(dictSet))) continue;

            dictSet.add(d);
            wordLenMax = Math.max(wordLenMax, d.length());
        }

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j > wordLenMax) break;
                if (dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }

    public boolean wordBreak还是超时(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>();
        int wordLenMax = 0;
        for (String d : wordDict) {
            if (wordBreak还是超时(d, new ArrayList<>(dictSet))) continue;

            dictSet.add(d);
            wordLenMax = Math.max(wordLenMax, d.length());
        }

        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                if (j - i > wordLenMax) break;
                if (i == j) dp[i][j] = true;
                else dp[i][j] = dictSet.contains(s.substring(i, j));
            }
        }

        LOGGER.info("dp = {}", ToString.arrayToFormatString(dp));

        return wordBreak(0, len, dp);
    }

    private boolean wordBreak(int start, int len, boolean[][] dp) {
        for (int i = start + 1; i <= len; i++) {
            //String begin = s.substring(0, i);
            //String end = s.substring(i);

            //LOGGER.info("begin = {}", begin);
            if (dp[start][i]) {
                if (i == len || wordBreak(i, len, dp)) return true;
            }
        }

        return false;
    }


    public boolean wordBreak超时(String s, List<String> wordDict) {
        // 很明显的动态规划
        int len = s.length();

        for (int i = 1; i <= len; i++) {
            String begin = s.substring(0, i);
            String end = s.substring(i);

            LOGGER.info("begin = {}", begin);
            if (wordDict.contains(begin)) {
                if (end.length() == 0 || wordBreak超时(end, wordDict)) return true;
            }
        }

        return false;
    }
}
