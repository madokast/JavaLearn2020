package com.zrx.algorithm.leetcode.q0210;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 数组中的第K个最大元素
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0215数组中的第K个最大元素 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0215数组中的第K个最大元素.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(3, 2, 1, 5, 6, 4), 2,
                ArrayFactory.create(3, 2, 3, 1, 2, 4, 5, 5, 6), 4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                5, 4
        );
    }

    @Code(info = """
            在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

            示例 1:

            输入: [3,2,1,5,6,4] 和 k = 2
            输出: 5
            示例 2:

            输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
            输出: 4
            说明:

            你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int findKthLargest(int[] nums, int k) {


        int length = nums.length;
        return findKthLargest(nums, 0, length - 1, length - k);
    }

    int findKthLargest(int[] nums, int leftIn, int rightIn, int index) {
        int l0 = leftIn;
        int r0 = rightIn;

        int c = nums[leftIn];
        do {
            while (leftIn < rightIn && nums[rightIn] > c) {
                rightIn--;
            }
            nums[leftIn] = nums[rightIn];

            while (leftIn < rightIn && c >= nums[leftIn]) {
                leftIn++;
            }

            nums[rightIn] = nums[leftIn];

        } while (leftIn != rightIn);


        nums[leftIn] = c;


        LOGGER.info("nums = {}", Arrays.toString(nums));
        LOGGER.info("leftIn = {}", leftIn);
        LOGGER.info("rightIn = {}", rightIn);



        if (index == leftIn) {
            return c;
        } else if (index > leftIn) {
            return findKthLargest(nums, leftIn + 1, r0, index);
        } else {
            return findKthLargest(nums, l0, leftIn - 1, index);
        }
    }
}
