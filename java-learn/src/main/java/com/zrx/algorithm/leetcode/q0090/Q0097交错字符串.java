package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 交错字符串
 * <p>
 * Data
 * 2020/6/6-16:36
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0097交错字符串 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0097交错字符串.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。

            示例 1:

            输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
            输出: true
            示例 2:

            输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
            输出: false

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/interleaving-string
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isInterleave(String s1, String s2, String s3) {
        return false;
    }
}
