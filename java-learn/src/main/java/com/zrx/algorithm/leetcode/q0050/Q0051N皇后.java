package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
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
        linesInit(n);
        List<List<String>> answer = new ArrayList<>();

        int[] table = new int[n];

        backSearch(0, table, answer);

        return answer;
    }

    private void backSearch(int lineNumber, int[] table, List<List<String>> answer) {
        if (lineNumber == table.length)
            answer.add(convert(table));
        else {
            for (Integer valid : validLocal(table, lineNumber)) {
                table[lineNumber] = valid;
                backSearch(lineNumber + 1, table, answer);
            }
        }
    }

    private List<Integer> validLocal(int[] table, int lineNumber) {
        List<Integer> ret = new LinkedList<>();
        int n = table.length;
        for (int i = 0; i < n; i++) {
            ret.add(i);
        }

        for (int i = 0; i < lineNumber; i++) {
            int t = table[i];
            int k = lineNumber - i;
            ret.remove((Integer) t);
            if (t + k < n)
                ret.remove((Integer) (t + k));
            if (t - k >= 0)
                ret.remove((Integer) (t - k));
        }

        LOGGER.info("lineNumber = {}, ret = {}, table = {}",lineNumber, ret, ToString.arrayToFormatString(table));

        return ret;
    }

    private List<String> convert(int[] table) {
        List<String> ret = new ArrayList<>(table.length);
        for (int t : table) {
            ret.add(lines[t]);
        }

        return ret;
    }

    String[] lines = null;

    private void linesInit(int n) {
        lines = new String[n];

        StringBuilder sb = new StringBuilder(".".repeat(n));
        for (int i = 0; i < n; i++) {
            sb.setCharAt(i, 'Q');
            lines[i] = sb.toString();
            sb.setCharAt(i, '.');
        }
    }
}
