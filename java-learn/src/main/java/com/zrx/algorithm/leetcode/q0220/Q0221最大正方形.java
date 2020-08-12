package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 最大正方形
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0221最大正方形 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0221最大正方形.class);

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
            在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

            示例:

            输入:\040

            1 0 1 0 0
            1 0 1 1 1
            1 1 1 1 1
            1 0 0 1 0

            输出: 4

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/maximal-square
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maximalSquare(char[][] matrix) {
return -1;
    }
}
