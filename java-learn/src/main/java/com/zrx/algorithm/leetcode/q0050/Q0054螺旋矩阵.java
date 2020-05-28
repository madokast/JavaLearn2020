package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.hibernate.validator.constraints.CodePointLength;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description
 * 螺旋矩阵
 * <p>
 * Data
 * 2020/5/26-15:56
 *
 * @author zrx
 * @version 1.0
 */
@Component
public class Q0054螺旋矩阵 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0054螺旋矩阵.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(
                        ArrayFactory.create(1, 2, 3),
                        ArrayFactory.create(4, 5, 6),
                        ArrayFactory.create(7, 8, 9)
                ), ArrayFactory.create(
                        ArrayFactory.create(1, 2, 3, 4),
                        ArrayFactory.create(5, 6, 7, 8),
                        ArrayFactory.create(9, 10, 11, 12)
                ), new int[][]{
                        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}}
                , ArrayFactory.create(
                        ArrayFactory.create(1),
                        ArrayFactory.create(2),
                        ArrayFactory.create(3),
                        ArrayFactory.create(4),
                        ArrayFactory.create(5),
                        ArrayFactory.create(6),
                        ArrayFactory.create(7),
                        ArrayFactory.create(8)
                )
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of(1, 2, 3, 6, 9, 8, 7, 4, 5),
                List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                List.of(1, 2, 3, 4, 5, 6, 7, 8)
        );
    }

    @Code(info = """
            给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

            示例 1:

            输入:
            [
             [ 1, 2, 3 ],
             [ 4, 5, 6 ],
             [ 7, 8, 9 ]
            ]
            输出: [1,2,3,6,9,8,7,4,5]
            示例 2:

            输入:
            [
              [1, 2, 3, 4],
              [5, 6, 7, 8],
              [9,10,11,12]
            ]
            输出: [1,2,3,4,8,12,11,10,9,5,6,7]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/spiral-matrix
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowNumber = matrix.length;
        if(rowNumber==0)
            return Collections.emptyList();

        int colNumber = matrix[0].length;

        int layerNumber = (Math.min(rowNumber, colNumber) + 1) / 2;

        List<Integer> ans = new ArrayList<>(rowNumber * colNumber);

        for (int i = 0; i < layerNumber; i++)
            round(i, matrix, ans);


        return ans;
    }

    private void round(int layer, int[][] m, List<Integer> answer) {
        int rowNumber = m.length;
        int colNumber = m[0].length;

        int i = layer;
        int j = layer;

        if (rowNumber / 2 == layer) {
            // 一行

            for (; j < colNumber - layer; j++) {
                //LOGGER.info("m1[{}}][{}] = {}", i, j, m[i][j]);
                answer.add(m[i][j]);
            }

        } else if (colNumber / 2 == layer) {
            // 一列

            for (; i < rowNumber - layer; i++) {
                //LOGGER.info("m1[{}}][{}] = {}", i, j, m[i][j]);
                answer.add(m[i][j]);
            }
        } else {
            for (; j < colNumber - layer; j++) {
                //LOGGER.info("m1[{}}][{}] = {}", i, j, m[i][j]);
                answer.add(m[i][j]);
            }

            for (i++, j--; i < rowNumber - layer; i++) {
                //LOGGER.info("m2[{}}][{}] = {}", i, j, m[i][j]);
                answer.add(m[i][j]);
            }

            for (j--, i--; j >= layer; j--) {
                //LOGGER.info("m3[{}}][{}] = {}", i, j, m[i][j]);
                answer.add(m[i][j]);
            }

            for (j++, i--; i > layer; i--) {
                //LOGGER.info("m4[{}}][{}] = {}", i, j, m[i][j]);
                answer.add(m[i][j]);
            }
        }


    }
}
