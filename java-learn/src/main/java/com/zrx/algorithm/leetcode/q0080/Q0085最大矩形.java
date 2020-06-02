package com.zrx.algorithm.leetcode.q0080;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 最大矩形
 * <p>
 * Data
 * 2020/6/2-11:51
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0085最大矩形 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0085最大矩形.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

            示例:

            输入:
            [
              ["1","0","1","0","0"],
              ["1","0","1","1","1"],
              ["1","1","1","1","1"],
              ["1","0","0","1","0"]
            ]
            输出: 6

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/maximal-rectangle
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maximalRectangle(char[][] matrix) {
        return -1;
    }
}
