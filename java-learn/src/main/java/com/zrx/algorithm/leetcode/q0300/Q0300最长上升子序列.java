package com.zrx.algorithm.leetcode.q0300;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 最长上升子序列
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0300最长上升子序列 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0300最长上升子序列.class);

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
            给定一个无序的整数数组，找到其中最长上升子序列的长度。

            示例:

            输入: [10,9,2,5,3,7,101,18]
            输出: 4\040
            解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
            说明:

            可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
            你算法的时间复杂度应该为 O(n2) 。
            进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int lengthOfLIS(int[] nums) {
        return -1;
    }
}
