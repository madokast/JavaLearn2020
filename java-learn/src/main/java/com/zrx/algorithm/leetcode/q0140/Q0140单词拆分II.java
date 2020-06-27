package com.zrx.algorithm.leetcode.q0140;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * 单词拆分 II
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0140单词拆分II implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0140单词拆分II.class);

    @Override
    public List<Input> getInputs() {
        //"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        //["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
        return InputFactory.create(
                2,
                "catsanddog", List.of("cat", "cats", "and", "sand", "dog"),
                "pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple"),
                "catsandog", List.of("cats", "dog", "sand", "and", "cat"),
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of("cats and dog", "cat sand dog"),
                RepeatableSet.of("pine apple pen apple", "pineapple pen apple", "pine applepen apple"),
                RepeatableSet.of(),
                RepeatableSet.of()
        );
    }

    @Code(info = """
            给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

            说明：

            分隔时可以重复使用字典中的单词。
            你可以假设字典中没有重复的单词。
            示例 1：

            输入:
            s = "catsanddog"
            wordDict = ["cat", "cats", "and", "sand", "dog"]
            输出:
            [
              "cats and dog",
              "cat sand dog"
            ]
            示例 2：

            输入:
            s = "pineapplepenapple"
            wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
            输出:
            [
              "pine apple pen apple",
              "pineapple pen apple",
              "pine applepen apple"
            ]
            解释: 注意你可以重复使用字典中的单词。
            示例 3：

            输入:
            s = "catsandog"
            wordDict = ["cats", "dog", "sand", "and", "cat"]
            输出:
            []

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/word-break-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> wordBreak动态规划(String s, List<String> wordDict) {
        int length = s.length();
        List<List<List<String>>> ansList = new ArrayList<>(length + 1);
        Set<String> dict = new HashSet<>();
        int max = 0;
        for (String word : wordDict) {
            dict.add(word);
            max = Math.max(max, word.length());
        }
        boolean[] dp = new boolean[length + 1];

        dp[0] = true;
        List<List<String>> ansForZero = new ArrayList<>();
        ansForZero.add(List.of());
        ansList.add(ansForZero);

        if (length > "pineapplepenapple".length()) {
            // 狗屁问题，需要预先看看有没有解
            for (int i = 1; i <= length; i++) {
                // 求 dp[i]
                for (int j = 0; j < i; j++) {
                    if (i - j > max) continue;
                    if (dp[j]) {
                        String second = s.substring(j, i);
                        if (dict.contains(second)) {
                            dp[i] = true;
                        }
                    }
                }
            }

            if (!dp[length]) return Collections.emptyList();
        }


        //LOGGER.info("dp = {}", dp);
        //LOGGER.info("ansList = {}", ansList);

        for (int i = 1; i <= length; i++) {
            List<List<String>> ansForI = new ArrayList<>();
            // 求 dp[i]
            for (int j = 0; j < i; j++) {
                if (i - j > max) continue;
                if (dp[j]) {
                    String second = s.substring(j, i);
                    if (dict.contains(second)) {
                        dp[i] = true;
                        List<List<String>> ansForJ = ansList.get(j);
                        for (List<String> forJ : ansForJ) {
                            List<String> forJAddSecond = new ArrayList<>(forJ.size() + 1);
                            forJAddSecond.addAll(forJ);
                            forJAddSecond.add(second);
                            ansForI.add(forJAddSecond);
                        }
                    }
                }
            }

            ansList.add(ansForI);
        }


        return ansList.get(length).stream().map(trace -> String.join(" ", trace)).collect(Collectors.toList());
    }

    public List<String> wordBreak递归超时(String s, List<String> wordDict) {
        List<List<String>> ans = new ArrayList<>();
        wordBreak(s, new HashSet<>(wordDict), ans, new LinkedList<>());

        LOGGER.info("ans = {}", ans);

        return ans.stream().map(trace -> String.join(" ", trace)).collect(Collectors.toList());
    }

    private void wordBreak(String s, Set<String> wordDict, List<List<String>> ans, Deque<String> trace) {
        int length = s.length();
        if (length == 0) {
            ans.add(new ArrayList<>(trace));
        } else {
            for (int i = 1; i <= length; i++) {
                String first = s.substring(0, i);
                String second = s.substring(i, length);
                if (wordDict.contains(first)) {
                    trace.addLast(first);
                    wordBreak(second, wordDict, ans, trace);
                    trace.removeLast();
                }
            }
        }
    }
}
