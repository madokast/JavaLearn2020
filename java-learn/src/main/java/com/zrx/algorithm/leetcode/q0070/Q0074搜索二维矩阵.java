package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 搜索二维矩阵
 * <p>
 * Data
 * 2020/5/31-13:43
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0074搜索二维矩阵 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0074搜索二维矩阵.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """

            编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

            每行中的整数从左到右按升序排列。
            每行的第一个整数大于前一行的最后一个整数。
            示例 1:

            输入:
            matrix = [
              [1,   3,  5,  7],
              [10, 11, 16, 20],
              [23, 30, 34, 50]
            ]
            target = 3
            输出: true
            示例 2:

            输入:
            matrix = [
              [1,   3,  5,  7],
              [10, 11, 16, 20],
              [23, 30, 34, 50]
            ]
            target = 13
            输出: false
            """)
    public boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }
}
