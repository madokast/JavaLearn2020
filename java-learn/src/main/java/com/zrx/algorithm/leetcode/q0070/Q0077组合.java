package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 组合
 * <p>
 * Data
 * 2020/5/31-13:49
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0077组合 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0077组合.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

            示例:

            输入: n = 4, k = 2
            输出:
            [
              [2,4],
              [3,4],
              [2,3],
              [1,2],
              [1,3],
              [1,4],
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/combinations
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> combine(int n, int k) {
        return null;
    }
}
