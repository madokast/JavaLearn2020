package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 存在重复元素 III
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0220存在重复元素III implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0220存在重复元素III.class);

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
            在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。

            如果存在则返回 true，不存在返回 false。

             

            示例 1:

            输入: nums = [1,2,3,1], k = 3, t = 0
            输出: true
            示例 2:

            输入: nums = [1,0,1,1], k = 1, t = 2
            输出: true
            示例 3:

            输入: nums = [1,5,9,1,5,9], k = 2, t = 3
            输出: false

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/contains-duplicate-iii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
return false;
    }
}
