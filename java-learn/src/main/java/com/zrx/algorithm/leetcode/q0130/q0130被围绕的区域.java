package com.zrx.algorithm.leetcode.q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * 被围绕的区域
 * <p>
 * Data
 * 2020/6/21-17:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class q0130被围绕的区域 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(q0130被围绕的区域.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.createTwoDimensionsIntArray(
                        'X', 'x', 'X', 'x', null,
                        'X', 'O', 'O', 'x', null,
                        'X', 'x', 'O', 'x', null,
                        'X', 'O', 'X', 'x'
                ),
                ArrayFactory.createTwoDimensionsIntArray('O')
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                (Object) ArrayFactory.createTwoDimensionsIntArray(
                        'X', 'x', 'X', 'x', null,
                        'X', 'X', 'X', 'x', null,
                        'X', 'x', 'X', 'x', null,
                        'X', 'O', 'X', 'x'
                ),
                ArrayFactory.createTwoDimensionsIntArray('X')
        );
    }

    @Code(info = """
            给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

            找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

            示例:

            X X X X
            X O O X
            X X O X
            X O X X
            运行你的函数后，矩阵变为：

            X X X X
            X X X X
            X X X X
            X O X X
            解释:

            被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/surrounded-regions
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public char[][] solve(char[][] board) {
        if (board == null) return board;
        int rowLen = board.length;
        if (rowLen == 0) return board;
        int colLen = board[0].length;
        if (colLen == 0) return board;

        Deque<Integer> rowQueue = new LinkedList<>();
        Deque<Integer> colQueue = new LinkedList<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (isEdge(rowLen, colLen, i, j) && board[i][j] == 'O') {
                    rowQueue.addLast(i);
                    colQueue.addLast(j);
                }
            }
        }


        while (!rowQueue.isEmpty()) {
            LOGGER.info("colQueue = {}", colQueue);
            LOGGER.info("rowQueue = {}", rowQueue);

            Integer row = rowQueue.removeFirst();
            Integer col = colQueue.removeFirst();


            if (board[row][col] == 'O') {
                board[row][col] = '#';
                if (isLegal(rowLen, colLen, row - 1, col)) {
                    rowQueue.addLast(row - 1);
                    colQueue.addLast(col);
                }
                if (isLegal(rowLen, colLen, row + 1, col)) {
                    rowQueue.addLast(row + 1);
                    colQueue.addLast(col);
                }
                if (isLegal(rowLen, colLen, row, col - 1)) {
                    rowQueue.addLast(row);
                    colQueue.addLast(col - 1);
                }
                if (isLegal(rowLen, colLen, row, col + 1)) {
                    rowQueue.addLast(row);
                    colQueue.addLast(col + 1);
                }
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }

        return board;
    }

    private boolean isEdge(int rowLen, int colLen, int i, int j) {
        return i == 0 || j == 0 || i == rowLen - 1 || j == colLen - 1;
    }

    private boolean isLegal(int rowLen, int colLen, int i, int j) {
        return i >= 0 && i < rowLen && j >= 0 && j < colLen;
    }
}
