package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 有效的数独
 * <p>
 * Data
 * 2020/5/13-17:48
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0036有效的数独 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0036有效的数独.class);

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

        String[][] board02 = new String[][]{
                {"8", "3", ".", ".", "7", ".", ".", ".", "."},
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
                stringArrArrToCharArrArr(board01),
                stringArrArrToCharArrArr(board02)

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
        return AnswerFactory.create(true, false);
    }

    @Code(info = """
            判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

            数字 1-9 在每一行只能出现一次。
            数字 1-9 在每一列只能出现一次。
            数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


            上图是一个部分填充的有效的数独。

            数独部分空格内已填入了数字，空白格用 '.' 表示。

            示例 1:

            输入:
            [
              ["5","3",".",".","7",".",".",".","."],
              ["6",".",".","1","9","5",".",".","."],
              [".","9","8",".",".",".",".","6","."],
              ["8",".",".",".","6",".",".",".","3"],
              ["4",".",".","8",".","3",".",".","1"],
              ["7",".",".",".","2",".",".",".","6"],
              [".","6",".",".",".",".","2","8","."],
              [".",".",".","4","1","9",".",".","5"],
              [".",".",".",".","8",".",".","7","9"]
            ]
            输出: true
            示例 2:

            输入:
            [
              ["8","3",".",".","7",".",".",".","."],
              ["6",".",".","1","9","5",".",".","."],
              [".","9","8",".",".",".",".","6","."],
              ["8",".",".",".","6",".",".",".","3"],
              ["4",".",".","8",".","3",".",".","1"],
              ["7",".",".",".","2",".",".",".","6"],
              [".","6",".",".",".",".","2","8","."],
              [".",".",".","4","1","9",".",".","5"],
              [".",".",".",".","8",".",".","7","9"]
            ]
            输出: false
            解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
                 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
            说明:

            一个有效的数独（部分已被填充）不一定是可解的。
            只需要根据以上规则，验证已经填入的数字是否有效即可。
            给定数独序列只包含数字 1-9 和字符 '.' 。
            给定数独永远是 9x9 形式的。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/valid-sudoku
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isValidSudoku(char[][] board) {
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

//    private static final int[] NUMS;
//
//    static {
//        NUMS = new int[9];
//        for (int i = 0; i < 9; i++) {
//            NUMS[i] = (1 << i);
//        }
//    }

    // 慢速方法
    public boolean isValidSudokuSlow(char[][] board) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        // 0-8 i
        // 9-17 j
        // 18-26 cell
        for (int i = 0; i < 27; i++) {
            map.put(i, new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];

                if (c == '.')
                    continue;

                Set<Character> rowSet = map.get(i);
                Set<Character> colSet = map.get(j + 9);
                Set<Character> cellSet = map.get((i / 3) * 3 + j / 3 + 18);

                if (rowSet.contains(c)) return false;
                else rowSet.add(c);

                if (colSet.contains(c)) return false;
                else colSet.add(c);

                if (cellSet.contains(c)) return false;
                else cellSet.add(c);
            }
        }


        return true;
    }
}
