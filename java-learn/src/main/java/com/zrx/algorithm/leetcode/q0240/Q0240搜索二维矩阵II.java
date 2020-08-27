package com.zrx.algorithm.leetcode.q0240;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Description
 * 搜索二维矩阵 II
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0240搜索二维矩阵II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0240搜索二维矩阵II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.createTwoDimensionsIntArray(
                        1, 4, 7, 11, 15, null,
                        2, 5, 8, 12, 19, null,
                        3, 6, 9, 16, 22, null,
                        10, 13, 14, 17, 24, null,
                        18, 21, 23, 26, 30
                ), 5,
                ArrayFactory.createTwoDimensionsIntArray(
                        1, 4, 7, 11, 15, null,
                        2, 5, 8, 12, 19, null,
                        3, 6, 9, 16, 22, null,
                        10, 13, 14, 17, 24, null,
                        18, 21, 23, 26, 30
                ), 20
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, false
        );
    }

    @Code(info = """
            编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

            每行的元素从左到右升序排列。
            每列的元素从上到下升序排列。
            示例:

            现有矩阵 matrix 如下：

            [
              [1,   4,  7, 11, 15],
              [2,   5,  8, 12, 19],
              [3,   6,  9, 16, 22],
              [10, 13, 14, 17, 24],
              [18, 21, 23, 26, 30]
            ]
            给定 target = 5，返回 true。

            给定 target = 20，返回 false。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;

        int cols = matrix[0].length;
        if (cols == 0) return false;

        int i = rows - 1;
        int j = 0;

        while (i >= 0 && j < cols) {
            int val = matrix[i][j];
            if (val > target) {
                i--;
            } else if (val < target) {
                j++;
            } else {
                return true;
            }
        }

        return false;
    }
}
