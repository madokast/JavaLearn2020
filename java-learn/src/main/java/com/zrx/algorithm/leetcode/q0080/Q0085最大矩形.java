package com.zrx.algorithm.leetcode.q0080;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description
 * 最大矩形
 * <p>
 * Data
 * 2020/6/2-11:51
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0085最大矩形 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0085最大矩形.class);

    @Override
    public List<Input> getInputs() {
        Character[] input0 = Stream.of("1", "0", "1", "0", "0", null,
                "1", "0", "1", "1", "1", null,
                "1", "1", "1", "1", "1", null,
                "1", "0", "0", "1", "0")
                .map(s -> {
                    if (s == null) return null;
                    else return s.charAt(0);
                })
                .collect(Collectors.toList())
                .toArray(Character[]::new);


        return InputFactory.create(
                1,
                (Object) ArrayFactory.createTwoDimensionsIntArray(input0)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(6);
    }

    @Code(info = """
            给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

            示例:

            输入:
            [
              ["1","0","1","0","0"],
              ["1","0","1","1","1"],
              ["1","1","1","1","1"],
              ["1","0","0","1","0"]
            ]
            输出: 6

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/maximal-rectangle
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        if (r == 0) return 0;

        int c = matrix[0].length;
        if (c == 0) return 0;

        int max = 0;

        int[] dp = new int[c];
        int[] dpLeft = new int[c];
        int[] dpRight = new int[c];
        int[] lefts = new int[c];
        int[] rights = new int[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char ch = matrix[i][j];
                if (ch == '0') dpRight[j] = 0;
                else {
                    int h = dp[j] + 1;
                    int right = 1;
                    int curCol = j;
                    while (++curCol < c && matrix[i][curCol] == '1' && dp[curCol] >= dp[j]) right++;
                    dpRight[j] = h;
                    rights[j] = right;
                }
            }

            for (int j = c - 1; j >= 0; j--) {
                char ch = matrix[i][j];
                if (ch == '0') dpLeft[j] = 0;
                else {
                    int h = dp[j] + 1;
                    int left = 1;
                    int curCol = j;
                    while (--curCol >= 0 && matrix[i][curCol] == '1' && dp[curCol] >= dp[j]) left++;
                    dpLeft[j] = h;
                    lefts[j] = left;
                }
            }

            for (int j = 0; j < c; j++) {
                int hL = dpLeft[j];
                int hR = dpRight[j];
                if (hL != hR) throw new RuntimeException("dpLeft[j]!=dpRight[j] at i=" + i + ", j=" + j);
                dp[j] = hL;
                max = Math.max(max, hL * (rights[j] + lefts[j] - 1));
            }

            LOGGER.info("dp = {}", dp);
            LOGGER.info("dpRight = {}", dpRight);
            LOGGER.info("dpLeft = {}", dpLeft);
            LOGGER.info("rights = {}", rights);
            LOGGER.info("lefts = {}", lefts);
            LOGGER.info("--------------");
        }


        return max;
    }
}
