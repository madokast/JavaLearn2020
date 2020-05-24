package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0051N皇后
 * <p>
 * Data
 * 2020/5/24-21:49
 *
 * @author zrx
 * @version 1.0
 */
@Component
public class Q0051N皇后 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0051N皇后.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of(
                        List.of(".Q..",  // 解法 1
                                "...Q",
                                "Q...",
                                "..Q."),
                        List.of("..Q.",  // 解法 2
                                "Q...",
                                "...Q",
                                ".Q.."
                        )
                )
        );
    }

    @Code(info = """
            n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

            给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

            每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

            示例:

            输入: 4
            输出: [
             [".Q..",  // 解法 1
              "...Q",
              "Q...",
              "..Q."],

             ["..Q.",  // 解法 2
              "Q...",
              "...Q",
              ".Q.."]
            ]
            解释: 4 皇后问题存在两个不同的解法。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/n-queens
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<String>> solveNQueens(int n) {
        return null;
    }
}
