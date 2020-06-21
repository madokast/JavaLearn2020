package com.zrx.algorithm.leetcode.Q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
        return -1;
    }

}
