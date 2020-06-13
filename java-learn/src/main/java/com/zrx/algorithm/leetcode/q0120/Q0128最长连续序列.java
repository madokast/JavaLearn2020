package com.zrx.algorithm.leetcode.q0120;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 最长连续序列
 * <p>
 * Data
 * 2020/6/13-19:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0128最长连续序列 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0128最长连续序列.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个未排序的整数数组，找出最长连续序列的长度。

            要求算法的时间复杂度为 O(n)。

            示例:

            输入: [100, 4, 200, 1, 3, 2]
            输出: 4
            解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int longestConsecutive(int[] nums) {
        return -1;
    }
}
