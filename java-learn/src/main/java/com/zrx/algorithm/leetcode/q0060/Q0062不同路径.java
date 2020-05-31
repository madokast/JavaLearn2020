package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 不同路径
 * <p>
 * Data
 * 2020/5/28-13:25
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0062不同路径 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0062不同路径.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                3, 2,
                7, 3
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(3, 28);
    }

    @Code(info = """
            一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

            机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

            问总共有多少条不同的路径？



            例如，上图是一个7 x 3 的网格。有多少可能的路径？

             

            示例 1:

            输入: m = 3, n = 2
            输出: 3
            解释:
            从左上角开始，总共有 3 条路径可以到达右下角。
            1. 向右 -> 向右 -> 向下
            2. 向右 -> 向下 -> 向右
            3. 向下 -> 向右 -> 向右
            示例 2:

            输入: m = 7, n = 3
            输出: 28

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/unique-paths
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int uniquePaths(int m, int n) {
        if(m==0||n==0)
            return 0;
        if(m==1||n==1)
            return 1;

        int[][] paths = new int[m][n];

        for (int i = n - 1; i >= 0; i--) {
            paths[m - 1][i] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 <m) {
                    paths[i][j] += paths[i + 1][j];
                }

                if (j + 1 <n) {
                    paths[i][j] += paths[i][j + 1];
                }
            }
        }

        LOGGER.info("paths = {}", ToString.arrayToFormatString(paths));


        return paths[0][0];
    }
}
