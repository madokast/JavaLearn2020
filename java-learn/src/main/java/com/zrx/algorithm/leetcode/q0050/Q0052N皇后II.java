package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * Q0052N皇后II
 * <p>
 * Data
 * 2020/5/26-15:49
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0052N皇后II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0052N皇后II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2);
    }

    @Code(info = """
            n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



            上图为 8 皇后问题的一种解法。

            给定一个整数 n，返回 n 皇后不同的解决方案的数量。

            示例:

            输入: 4
            输出: 2
            解释: 4 皇后问题存在如下两个不同的解法。
            [
             [".Q..",  // 解法 1
              "...Q",
              "Q...",
              "..Q."],

             ["..Q.",  // 解法 2
              "Q...",
              "...Q",
              ".Q.."]
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/n-queens-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int totalNQueens(int n) {
        int[] number = {0};

        int[] table = new int[n];

        backSearch(0, table, number);

        return number[0];
    }

    private void backSearch(int lineNumber, int[] table,int[] number) {
        if (lineNumber == table.length)
            number[0]++;
        else {
            for (Integer valid : validLocal(table, lineNumber)) {
                table[lineNumber] = valid;
                backSearch(lineNumber + 1, table, number);
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

        return ret;
    }
}
