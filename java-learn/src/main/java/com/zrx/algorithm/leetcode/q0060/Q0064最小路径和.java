package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 最小路径和
 * <p>
 * Data
 * 2020/5/28-13:27
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0064最小路径和 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0064最小路径和.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.createTwoDimensionsIntArray(1, 3, 1, null, 1, 5, 1, null, 4, 2, 1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(7);
    }

    @Code(info = """
            给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

            说明：每次只能向下或者向右移动一步。

            示例:

            输入:
            [
              [1,3,1],
              [1,5,1],
              [4,2,1]
            ]
            输出: 7
            解释: 因为路径 1→3→1→1→1 的总和最小。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/minimum-path-sum
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;

                int p = Integer.MAX_VALUE;

                if (i + 1 < m)
                    p = Math.min(p, grid[i + 1][j]);
                if (j + 1 < n)
                    p = Math.min(p, grid[i][j + 1]);


                grid[i][j] += p;
            }
        }

        return grid[0][0];
    }
}
