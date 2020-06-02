package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * 单词搜索
 * <p>
 * Data
 * 2020/5/31-13:51
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0079单词搜索 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0079单词搜索.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                (Object) ArrayFactory.createTwoDimensionsIntArray(
                        'A', 'B', 'C', 'E', null,
                        'S', 'F', 'C', 'S', null,
                        'A', 'D', 'E', 'E'
                ), "ABCCED",
                (Object) ArrayFactory.createTwoDimensionsIntArray(
                        'A', 'B', 'C', 'E', null,
                        'S', 'F', 'C', 'S', null,
                        'A', 'D', 'E', 'E'
                ), "SEE",
                (Object) ArrayFactory.createTwoDimensionsIntArray(
                        'A', 'B', 'C', 'E', null,
                        'S', 'F', 'C', 'S', null,
                        'A', 'D', 'E', 'E'
                ), "ABCB",
                ArrayFactory.createTwoDimensionsIntArray('a', 'b'), "ba"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(true, true, false, true);
    }

    @Code(info = """
            给定一个二维网格和一个单词，找出该单词是否存在于网格中。

            单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
            同一个单元格内的字母不允许被重复使用。

             

            示例:

            board =
            [
              ['A','B','C','E'],
              ['S','F','C','S'],
              ['A','D','E','E']
            ]

            给定 word = "ABCCED", 返回 true
            给定 word = "SEE", 返回 true
            给定 word = "ABCB", 返回 false
             

            提示：

            board 和 word 中只包含大写和小写英文字母。
            1 <= board.length <= 200
            1 <= board[i].length <= 200
            1 <= word.length <= 10^3

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/word-search
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean exist(char[][] board, String word) {
        Deque<Integer> pi = new LinkedList<>();
        Deque<Integer> pj = new LinkedList<>();


        return back(board, word, pi, pj);
    }

    private boolean back(char[][] board, String word, Deque<Integer> pi, Deque<Integer> pj) {
        log(board, pi, pj);


        int r = board.length;
        int c = board[0].length;

        int ps = pi.size();
        if (ps == word.length())
            return true;
        else {
            List<Integer> is = new ArrayList<>();
            List<Integer> js = new ArrayList<>();

            char ch = word.charAt(ps);
            if (pi.isEmpty()) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (board[i][j] == ch) {
                            is.add(i);
                            js.add(j);
                        }
                    }
                }
            } else {
                Integer i = pi.peek();
                Integer j = pj.peek();

                // i-1 j
                if (i - 1 >= 0 && board[i - 1][j] == ch && (!contain(pi, pj, i - 1, j))) {
                    is.add(i - 1);
                    js.add(j);
                }
                // i+1 j
                if (i + 1 < r && board[i + 1][j] == ch && (!contain(pi, pj, i + 1, j))) {
                    is.add(i + 1);
                    js.add(j);
                }
                // i j-1
                if (j - 1 >= 0 && board[i][j - 1] == ch && (!contain(pi, pj, i, j - 1))) {
                    is.add(i);
                    js.add(j - 1);
                }
                // i j+1
                if (j + 1 < c && board[i][j + 1] == ch && (!contain(pi, pj, i, j + 1))) {
                    is.add(i);
                    js.add(j + 1);
                }
            }

            LOGGER.info("js,is = {},{}", is, js);

            for (int k = 0; k < js.size(); k++) {
                Integer i = is.get(k);
                Integer j = js.get(k);

                pi.push(i);
                pj.push(j);

                boolean b = back(board, word, pi, pj);
                if (b) return true;

                pi.pop();
                pj.pop();
            }

            return false;
        }
    }

    private boolean contain(Deque<Integer> pi, Deque<Integer> pj, int i, int j) {
        LOGGER.info("contain");
        for (int ii = 0; ii < pi.size(); ii++) {
            Integer pii = ((List<Integer>) pi).get(ii);
            if (pii == i) {
                Integer pjj = ((List<Integer>) pj).get(ii);
                if (pjj == j)
                    return true;
            }
        }

        return false;
    }

    private void log(char[][] chs, Deque<Integer> pi, Deque<Integer> pj) {
        StringBuilder sb = new StringBuilder(pi.size());

        List<Integer> ppi = new ArrayList<>(pi);
        List<Integer> ppj = new ArrayList<>(pj);

        for (int k = 0; k < pi.size(); k++) {
            Integer i = ppi.get(k);
            Integer j = ppj.get(k);

            sb.append(chs[i][j]);
        }

        LOGGER.info("path = {}", sb.reverse().toString());
    }
}
