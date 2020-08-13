package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 最大正方形
 * 一看就是动态规划，比最大的长方形要简单
 * 我们用 dp(i, j)dp(i,j) 表示以 (i, j)(i,j) 为右下角，且只包含 11 的正方形的边长最大值
 * 记下这个 最优子结构
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0221最大正方形 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0221最大正方形.class);

    @Override
    public List<Input> getInputs() {
        //[["1","0","1","0"],["1","0","1","1"],["1","0","1","1"],["1","1","1","1"]]
        return InputFactory.create(
                1,
                (Object) ArrayFactory.createTwoDimensionsCharArray(
                        "1 0 1 0 0",
                        "1 0 1 1 1",
                        "1 1 1 1 1",
                        "1 0 0 1 0"
                ), ArrayFactory.createTwoDimensionsCharArray(
                        "1 0 1 1",
                        "1 0 1 1",
                        "1 0 1 1",
                        "1 1 1 1"
                ), ArrayFactory.createTwoDimensionsCharArray(
                        "0 0 0 1",
                        "1 1 0 1",
                        "1 1 1 1",
                        "0 1 1 1",
                        "0 1 1 1"
                )
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                4, 4, 9
        );
    }

    @Code(info = """
            在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

            示例:

            输入:\040

            1 0 1 0 0
            1 0 1 1 1
            1 1 1 1 1
            1 0 0 1 0

            输出: 4

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/maximal-square
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) return 0;
        int r = matrix.length;
        if (r == 0) return 0;
        int c = matrix[0].length;
        if (c == 0) return 0;

        int max = 0;

        int[][] dp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char ch = matrix[i][j];
                if (ch == '0') dp[i][j] = 0;
                else {
                    if (j == 0 || i == 0) dp[i][j] = 1;
                    else {
                        int up = dp[i - 1][j];
                        int left = dp[i][j - 1];
                        if (up == left) dp[i][j] = dp[i - 1][j - 1] >= up ? up + 1 : up;
                        else dp[i][j] = Math.min(up, left) + 1;
                    }

                    max = Math.max(max, dp[i][j]);
                }
            }

        }

        LOGGER.info("dp = {}", ToString.arrayToFormatString(dp));

        return max * max;
    }
}
