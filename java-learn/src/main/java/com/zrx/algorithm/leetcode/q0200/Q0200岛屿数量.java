package com.zrx.algorithm.leetcode.q0200;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 岛屿数量
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0200岛屿数量 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0200岛屿数量.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

            岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

            此外，你可以假设该网格的四条边均被水包围。

             

            示例 1:

            输入:
            [
            ['1','1','1','1','0'],
            ['1','1','0','1','0'],
            ['1','1','0','0','0'],
            ['0','0','0','0','0']
            ]
            输出: 1
            示例 2:

            输入:
            [
            ['1','1','0','0','0'],
            ['1','1','0','0','0'],
            ['0','0','1','0','0'],
            ['0','0','0','1','1']
            ]
            输出: 3
            解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/number-of-islands
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int numIslands(char[][] grid) {
        return -1;
    }
}
