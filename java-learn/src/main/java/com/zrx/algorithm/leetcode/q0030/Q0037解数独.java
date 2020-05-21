package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 解数独
 * 总算把回溯系统学了一下
 * <p>
 * Data
 * 2020/5/13-17:49
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0037解数独 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0037解数独.class);

    @Override
    public List<Input> getInputs() {

        String[][] board01 = new String[][]{
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        return InputFactory.create(
                1,
                (Object) stringArrArrToCharArrArr(board01)
        );
    }

    private char[][] stringArrArrToCharArrArr(String[][] strings) {
        char[][] chars = new char[strings.length][strings[0].length];

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                chars[i][j] = strings[i][j].charAt(0);
            }
        }

        return chars;
    }

    @Override
    public List<Answer> getAnswers() {
        char[][] chars = new char[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                chars[i][j] += ('0');
            }
        }

        return AnswerFactory.create((Object) chars);
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
            """, printInputParameters = {0})
    public char[][] solveSudoku(char[][] board) {
        // 寻找下一个空位
        label:
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    solve(board, i, j);
                    break label;
                }
            }
        }

        return board;
    }

    private boolean solve(char[][] board, int nextRow, int nextCol) {

        // 寻找下下个空位
        int nextNextRow = -1;
        int nextNextCol = -1;
        boolean find = false;

        for (int i = nextCol + 1; i < 9; i++) {
            if (board[nextRow][i] == '.') {
                nextNextRow = nextRow;
                nextNextCol = i;
                find = true;
                break;
            }
        }

        if (!find) {
            flag:
            for (int i = nextRow + 1; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        nextNextRow = i;
                        nextNextCol = j;
                        find = true;
                        break flag;
                    }
                }
            }
        }

        if (find) {
            // 有下下空位，继续递归

            for (Character validChar : validCharIn(board, nextRow, nextCol)) {
                board[nextRow][nextCol] = validChar;

                if (!solve(board, nextNextRow, nextNextCol)) {
                    board[nextRow][nextCol] = '.';
                } else
                    return true;
            }

            return false;
        } else {
            // 没有下下空位了
            // 这回就找出来

            List<Character> list = validCharIn(board, nextRow, nextCol);
            if (list.isEmpty())
                return false;
            else {
                board[nextRow][nextCol] = list.get(0);
                return true;
            }
        }

    }

    private boolean[] valid = new boolean[128];

    private List<Character> validCharIn(char[][] board, int row, int col) {
        Arrays.fill(valid, true);


        int cellRow = (row / 3) * 3;
        int cellCol = (col / 3) * 3;

        for (char rows : board[row]) {
            valid[rows] = false;
        }

        for (int i = 0; i < 9; i++) {
            valid[board[i][col]] = false;
        }

        for (int i = cellRow; i < cellRow + 3; i++) {
            for (int j = cellCol; j < cellCol + 3; j++) {
                valid[board[i][j]] = false;
            }
        }

        List<Character> list = new ArrayList<>(9);

        for (char c = '1'; c <= '9'; c++) {
            if (valid[c]) {
                list.add(c);
            }
        }

        return list;
    }

    static class Step {
        int row;
        int col;
        char c;

        public Step(int row, int col, char c) {
            this.row = row;
            this.col = col;
            this.c = c;
        }

        @Override
        public String toString() {
            return "" + row + col + c;
        }
    }

    private boolean isValidAfterPut(Step step, char[][] board) {
        //LOGGER.info("step = {}", step);

        char c = step.c;
        int col = step.col;
        int row = step.row;

        int cellRow = (row / 3) * 3;
        int cellCol = (col / 3) * 3;

        for (char rows : board[row]) {
            if (c == rows)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;
        }

        for (int i = cellRow; i < cellRow + 3; i++) {
            for (int j = cellCol; j < cellCol + 3; j++) {
                if (board[i][j] == c)
                    return false;
            }
        }

        return true;
    }

    private void solveSudoku(Statue statue, List<char[][]> ans) {
        // 答案非空才计算
        if (ans.isEmpty()) {

            // 无效，快速返回
            if (!statue.isValid()) {
                return;
            }

            int[] nextBlankPoint = statue.nextBlankPoint();

            if (nextBlankPoint == null) {
                ans.add(statue.board);
                return;
            }

            int row = nextBlankPoint[0];
            int col = nextBlankPoint[1];

            // 天下一个数字
            for (char c = '1'; c <= '9'; c++) {
                Statue copyAndFill = statue.copyAndFill(row, col, c);
                solveSudoku(copyAndFill, ans);
            }
        }
    }

    static class Statue {
        char[][] board;
        Stack<Integer> rows;
        Stack<Integer> cols;
        Stack<Character> values;

        public Statue(char[][] board, Stack<Integer> rows, Stack<Integer> cols, Stack<Character> values) {
            this.board = board;
            this.rows = rows;
            this.cols = cols;
            this.values = values;
        }

        boolean isValid() {
            int[] map = new int[27];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int c = board[i][j] - '0';

                    if (c == '.' - '0') continue;

                    c = (1 << c);

                    if ((map[i] & c) > 0) return false;
                    else map[i] += c;

                    if ((map[j + 9] & c) > 0) return false;
                    else map[j + 9] += c;

                    if ((map[(i / 3) * 3 + j / 3 + 18] & c) > 0) return false;
                    else map[(i / 3) * 3 + j / 3 + 18] += c;
                }
            }

            return true;
        }

        Statue copy() {
            char[][] copy = new char[9][9];

            for (int i = 0; i < 9; i++) {
                System.arraycopy(board[i], 0, copy[i], 0, 9);
            }


            return new Statue(copy, (Stack<Integer>) rows.clone(),
                    (Stack<Integer>) cols.clone(), (Stack<Character>) values.clone());
        }

        int[] nextBlankPoint() {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.')
                        return new int[]{i, j};
                }
            }

            return null;
        }

        Statue copyAndFill(int row, int col, char value) {
            Statue copy = copy();

            copy.board[row][col] = value;

            copy.rows.push(row);
            copy.cols.push(col);
            copy.values.push(value);

            return copy;
        }

        Statue copyAndBack() {
            Statue copy = this.copy();

            Character popC = copy.values.pop();
            Integer popRow = copy.rows.pop();
            Integer popCol = copy.cols.pop();

            copy.board[popRow][popCol] = '.';

            return copy;
        }
    }
}
