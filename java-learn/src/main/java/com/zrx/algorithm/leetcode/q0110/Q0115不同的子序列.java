package com.zrx.algorithm.leetcode.q0110;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.algorithm.leetcode.object.TreeNode;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 不同的子序列
 * <p>
 * Data
 * 2020/6/9-19:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0115不同的子序列 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0115不同的子序列.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "rabbbit", "rabbit",
                "babgbag", "bag"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                3, 5
        );
    }

    @Code(info = """
            给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。

            一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

            题目数据保证答案符合 32 位带符号整数范围。

             

            示例 1：

            输入：S = "rabbbit", T = "rabbit"
            输出：3
            解释：

            如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
            (上箭头符号 ^ 表示选取的字母)

            rabbbit
            ^^^^ ^^
            rabbbit
            ^^ ^^^^
            rabbbit
            ^^^ ^^^
            示例 2：

            输入：S = "babgbag", T = "bag"
            输出：5
            解释：

            如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。\040
            (上箭头符号 ^ 表示选取的字母)

            babgbag
            ^^ ^
            babgbag
            ^^    ^
            babgbag
            ^    ^^
            babgbag
              ^  ^^
            babgbag
                ^^^

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/distinct-subsequences
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        char tc0 = t.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (sc == tc0) {
                dp[1][i + 1] = dp[1][i] + 1;
            } else {
                dp[1][i + 1] = dp[1][i];
            }
        }

        for (int i = 1; i < t.length(); i++) {
            char tc = t.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                char sc = s.charAt(j);
                if (tc == sc) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }

        LOGGER.info("dp = {}", ToString.arrayToFormatString(dp));

        return dp[t.length()][s.length()];
    }
}
