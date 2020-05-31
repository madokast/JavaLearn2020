package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 *  最小覆盖子串
 * <p>
 * Data
 * 2020/5/31-13:45
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0076最小覆盖子串 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0076最小覆盖子串.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

            示例：

            输入: S = "ADOBECODEBANC", T = "ABC"
            输出: "BANC"
            说明：

            如果 S 中不存这样的子串，则返回空字符串 ""。
            如果 S 中存在这样的子串，我们保证它是唯一的答案。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/minimum-window-substring
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String minWindow(String s, String t) {
        return null;
    }
}
