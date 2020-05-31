package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 子集
 * <p>
 * Data
 * 2020/5/31-13:51
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0078子集 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0078子集.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

            说明：解集不能包含重复的子集。

            示例:

            输入: nums = [1,2,3]
            输出:
            [
              [3],
              [1],
              [2],
              [1,2,3],
              [1,3],
              [2,3],
              [1,2],
              []
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/subsets
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> subsets(int[] nums) {
        return null;
    }
}
