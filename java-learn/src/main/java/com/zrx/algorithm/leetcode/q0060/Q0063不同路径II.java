package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 不同路径 II
 * <p>
 * Data
 * 2020/5/28-13:26
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0063不同路径II implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0063不同路径II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.createTwoDimensionsIntArray(0, 0, 0, null, 0, 1, 0, null, 0, 0, 0)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2);
    }

    @Code(info = """
            一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

            机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

            现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？



            网格中的障碍物和空位置分别用 1 和 0 来表示。

            说明：m 和 n 的值均不超过 100。

            示例 1:

            输入:
            [
              [0,0,0],
              [0,1,0],
              [0,0,0]
            ]
            输出: 2
            解释:
            3x3 网格的正中间有一个障碍物。
            从左上角到右下角一共有 2 条不同的路径：
            1. 向右 -> 向右 -> 向下 -> 向下
            2. 向下 -> 向下 -> 向右 -> 向右

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/unique-paths-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;

        if (m == 0) return 0;

        int n = obstacleGrid[0].length;

        if (n == 0) return 0;

        if (obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] paths = new int[m][n];

        paths[m - 1][n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1)
                paths[m - 1][i] = 0;
            else
                paths[m - 1][i] = paths[m - 1][i + 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                    continue;
                }

                if (i + 1 < m)
                    paths[i][j] += paths[i + 1][j];
                if (j + 1 < n)
                    paths[i][j] += paths[i][j + 1];
            }
        }

        LOGGER.info("paths = {}", ToString.arrayToFormatString(paths));

        return paths[0][0];
    }
}
