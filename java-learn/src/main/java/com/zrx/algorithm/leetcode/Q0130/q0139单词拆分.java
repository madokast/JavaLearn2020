package com.zrx.algorithm.leetcode.Q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

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
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
        return false;
    }
}
