package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Question;
import org.hibernate.validator.constraints.CodePointLength;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
        return null;
    }
}
