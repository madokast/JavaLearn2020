package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
        return null;
    }
}
