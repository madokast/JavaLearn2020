package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * Description
 * Q0072编辑距离
 * <p>
 * Data
 * 2020/5/31-13:40
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0072编辑距离 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0072编辑距离.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "horse", "ros",
                "intention", "execution"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(3, 5);
    }

    @Code(info = """
            给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

            你可以对一个单词进行如下三种操作：

            插入一个字符
            删除一个字符
            替换一个字符
             

            示例 1：

            输入：word1 = "horse", word2 = "ros"
            输出：3
            解释：
            horse -> rorse (将 'h' 替换为 'r')
            rorse -> rose (删除 'r')
            rose -> ros (删除 'e')
            示例 2：

            输入：word1 = "intention", word2 = "execution"
            输出：5
            解释：
            intention -> inention (删除 't')
            inention -> enention (将 'i' 替换为 'e')
            enention -> exention (将 'n' 替换为 'x')
            exention -> exection (将 'n' 替换为 'c')
            exection -> execution (插入 'u')

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/edit-distance
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        char c1, c2;
        for (int i = 0; i <= l1; i++) {
            if (i == 0) c1 = 0;
            else c1 = word1.charAt(i - 1);
            for (int j = 0; j <= l2; j++) {
                if (j == 0) c2 = 0;
                else c2 = word2.charAt(j - 1);

                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else
                    dp[i][j] = Math.min(
                            Math.min(
                                    dp[i - 1][j] + 1,
                                    dp[i][j - 1] + 1
                            ), dp[i - 1][j - 1] + (c1 == c2 ? 0 : 1)
                    );
            }
        }


        return dp[l1][l2];
    }
}
