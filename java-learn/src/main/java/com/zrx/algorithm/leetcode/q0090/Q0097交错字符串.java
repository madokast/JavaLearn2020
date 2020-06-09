package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
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
        return InputFactory.create(
                3,
                "aabcc", "dbbca", "aadbbcbcac",
                "aabcc", "dbbca", "aadbbbaccc"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, false
        );
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
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();


        int l1 = c1.length;
        int l2 = c2.length;
        int l3 = c3.length;
        if (l1 == 0) return s2.equals(s3);
        if (l2 == 0) return s1.equals(s3);
        if (l1 + l2 != l3) return false;

        boolean[][] dp = new boolean[l1 + 1][l2 + 1];

        dp[0][0] = true;

        for (int i = 0; i < l1; i++) dp[i + 1][0] = (c1[i] == c3[i]) && dp[i][0];

        for (int i = 0; i < l2; i++) dp[0][i + 1] = (c2[i] == c3[i]) && dp[0][i];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                boolean b1 = (c1[i] == c3[i + j + 1]) && dp[i][j + 1];
                boolean b2 = (c2[j] == c3[i + j + 1]) && dp[i + 1][j];
                dp[i + 1][j + 1] = b1 || b2;
            }
        }

        LOGGER.info("dp = {}", ToString.arrayToFormatString(dp));

        return dp[l1][l2];
    }
}
