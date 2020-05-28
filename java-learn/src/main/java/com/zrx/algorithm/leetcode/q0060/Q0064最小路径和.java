package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 最小路径和
 * <p>
 * Data
 * 2020/5/28-13:27
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0064最小路径和 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0064最小路径和.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

            说明：每次只能向下或者向右移动一步。

            示例:

            输入:
            [
              [1,3,1],
              [1,5,1],
              [4,2,1]
            ]
            输出: 7
            解释: 因为路径 1→3→1→1→1 的总和最小。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/minimum-path-sum
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int minPathSum(int[][] grid) {
        return 0;
    }
}
