package com.zrx.algorithm.leetcode.q0210;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description
 * 存在重复元素 II
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0219存在重复元素II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0219存在重复元素II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(1, 2, 3, 1), 3,
                ArrayFactory.create(1, 0, 1, 1), 1,
                ArrayFactory.create(1, 2, 3, 1, 2, 3), 2
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, true, false
        );
    }

    @Code(info = """
            给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
            使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

             

            示例 1:

            输入: nums = [1,2,3,1], k = 3
            输出: true
            示例 2:

            输入: nums = [1,0,1,1], k = 1
            输出: true
            示例 3:

            输入: nums = [1,2,3,1,2,3], k = 2
            输出: false

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/contains-duplicate-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (set.contains(cur)) return true;
            set.add(cur);

            if (set.size() > k) set.remove(nums[i - k]);
        }


        return false;
    }
}
