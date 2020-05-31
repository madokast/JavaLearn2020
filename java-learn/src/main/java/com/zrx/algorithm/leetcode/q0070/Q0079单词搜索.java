package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0079单词搜索.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
        return false;
    }
}
