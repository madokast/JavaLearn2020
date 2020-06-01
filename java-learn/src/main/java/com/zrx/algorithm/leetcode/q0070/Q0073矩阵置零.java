package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.ManagedArray;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 矩阵置零
 * <p>
 * Data
 * 2020/5/31-13:41
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0073矩阵置零 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0073矩阵置零.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.createTwoDimensionsIntArray(1, 1, 1, null, 1, 0, 1, null, 1, 1, 1),
                ArrayFactory.createTwoDimensionsIntArray(0, 1, 2, 0, null, 3, 4, 5, 2, null, 1, 3, 1, 5)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ArrayFactory.createTwoDimensionsIntArray(1, 0, 1, null, 0, 0, 0, null, 1, 0, 1),
                ArrayFactory.createTwoDimensionsIntArray(0, 0, 0, 0, null, 0, 4, 5, 0, null, 0, 3, 1, 0)
        );
    }

    @Code(info = """
            给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

            示例 1:

            输入:
            [
              [1,1,1],
              [1,0,1],
              [1,1,1]
            ]
            输出:
            [
              [1,0,1],
              [0,0,0],
              [1,0,1]
            ]
            示例 2:

            输入:
            [
              [0,1,2,0],
              [3,4,5,2],
              [1,3,1,5]
            ]
            输出:
            [
              [0,0,0,0],
              [0,4,5,0],
              [0,3,1,0]
            ]
            进阶:

            一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
            一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
            你能想出一个常数空间的解决方案吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/set-matrix-zeroes
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[][] setZeroes(int[][] matrix) {


        int r = matrix.length;
        int c = matrix[0].length;

        boolean row1Zero = false;
        boolean col1Zero = false;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row1Zero = true;
                    } else if (j == 0) {
                        col1Zero = true;
                    } else {
                        matrix[0][j] = matrix[i][0] = 0;
                    }


                }
            }
        }



        for (int i = 1; i < r; i++) {
            if (matrix[i][0] == 0)
                setRowZero(matrix, i);
        }

        for (int i = 1; i < c; i++) {
            if (matrix[0][i] == 0)
                setColZero(matrix, i);
        }

//        if (matrix[0][0] == 0)
//            setZero(matrix, 0, 0);
//

        if(col1Zero)
            setColZero(matrix,0);

        if(row1Zero)
            setRowZero(matrix,0);

        return matrix;

    }

    public int[][] setZeroes用了额外空间(int[][] matrix) {
        List<Integer> rs = new ArrayList<>();
        List<Integer> cs = new ArrayList<>();

        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rs.add(i);
                    cs.add(j);
                }
            }
        }

        for (int i = 0; i < rs.size(); i++) {
            setZero(matrix, rs.get(i), cs.get(i));
        }

        return matrix;

    }


    private void setZero(int[][] m, int i, int j) {
        LOGGER.info("i,j = {},{}", i, j);

        int r = m.length;
        int c = m[0].length;

        for (int k = 0; k < r; k++) {
            m[k][j] = 0;
        }

        for (int k = 0; k < c; k++) {
            m[i][k] = 0;
        }
    }

    private void setRowZero(int[][] m, int row) {
        int r = m.length;
        int c = m[0].length;

        for (int i = 0; i < c; i++) {
            m[row][i] = 0;
        }
    }

    private void setColZero(int[][] m, int col) {
        int r = m.length;
        for (int i = 0; i < r; i++) {
            m[i][col] = 0;
        }
    }
}