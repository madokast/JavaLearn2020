package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 求众数 II
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0229求众数II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0229求众数II.class);

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
            给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

            说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。

            示例 1:

            输入: [3,2,3]
            输出: [3]
            示例 2:

            输入: [1,1,1,3,3,2,2,2]
            输出: [1,2]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/majority-element-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<Integer> majorityElement(int[] nums) {
        return null;
    }
}
