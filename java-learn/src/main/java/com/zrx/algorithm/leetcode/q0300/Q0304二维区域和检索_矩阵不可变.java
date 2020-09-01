package com.zrx.algorithm.leetcode.q0300;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 二维区域和检索 - 矩阵不可变
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0304二维区域和检索_矩阵不可变 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0304二维区域和检索_矩阵不可变.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。


            上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。

            示例:

            给定 matrix = [
              [3, 0, 1, 4, 2],
              [5, 6, 3, 2, 1],
              [1, 2, 0, 1, 5],
              [4, 1, 0, 1, 7],
              [1, 0, 3, 0, 5]
            ]

            sumRegion(2, 1, 4, 3) -> 8
            sumRegion(1, 1, 2, 2) -> 11
            sumRegion(1, 2, 2, 4) -> 12
            说明:

            你可以假设矩阵不可变。
            会多次调用 sumRegion 方法。
            你可以假设 row1 ≤ row2 且 col1 ≤ col2。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }


    class NumMatrix {

        public NumMatrix(int[][] matrix) {

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return -1;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
