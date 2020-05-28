package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.List;

/**
 * Description
 * 螺旋矩阵 II
 * <p>
 * Data
 * 2020/5/26-16:01
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0059螺旋矩阵II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0059螺旋矩阵II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                3,
                1,
                2
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                (Object) ArrayFactory.createTwoDimensionsIntArray(1, 2, 3, null, 8, 9, 4, null, 7, 6, 5),
                ArrayFactory.createTwoDimensionsIntArray(1),
                ArrayFactory.createTwoDimensionsIntArray(1, 2, null, 4, 3)
        );
    }

    @Code(info = """
            给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

            示例:

            输入: 3
            输出:
            [
             [ 1, 2, 3 ],
             [ 8, 9, 4 ],
             [ 7, 6, 5 ]
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/spiral-matrix-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[][] generateMatrix(int n) {
        if (n <= 0)
            return new int[0][0];

        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = numberAt(n, i, j);
            }
        }
        return ret;
    }

    public int numberAt(int d, int i, int j) {
        int layer = Math.min(
                Math.min(i, j),
                Math.min(d - 1 - i, d - 1 - j)
        );

        int offset = layer * (d - layer) << 2;

        d = d - (layer << 1);

        i = i - layer;
        j = j - layer;

        if (i == 0) {
            return j + offset + 1;
        } else if (j == d - 1) {
            return i + offset + j + 1;
        } else if (i == d - 1) {
            return (i << 1) + d - j + offset;
        } else {
            return ((d - 1) << 2) - i + offset + 1;
        }
    }
}
