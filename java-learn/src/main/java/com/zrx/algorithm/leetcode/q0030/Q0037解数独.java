package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 解数独
 * <p>
 * Data
 * 2020/5/13-17:49
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0037解数独 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0037解数独.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            编写一个程序，通过已填充的空格来解决数独问题。

            一个数独的解法需遵循如下规则：

            数字 1-9 在每一行只能出现一次。
            数字 1-9 在每一列只能出现一次。
            数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
            空白格用 '.' 表示。



            一个数独。



            答案被标成红色。

            Note:

            给定的数独序列只包含数字 1-9 和字符 '.' 。
            你可以假设给定的数独只有唯一解。
            给定数独永远是 9x9 形式的。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/sudoku-solver
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public void solveSudoku(char[][] board) {
        // todo
    }
}
