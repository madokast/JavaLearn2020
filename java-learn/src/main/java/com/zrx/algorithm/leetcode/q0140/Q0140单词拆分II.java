package com.zrx.algorithm.leetcode.q0140;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

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
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
    public List<String> wordBreak(String s, List<String> wordDict) {
        return null;
    }
}
