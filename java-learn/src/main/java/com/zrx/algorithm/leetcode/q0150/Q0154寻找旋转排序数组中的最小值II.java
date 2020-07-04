package com.zrx.algorithm.leetcode.q0150;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 寻找旋转排序数组中的最小值 II
 * <p>
 * Data
 * 2020/7/2-21:59
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0154寻找旋转排序数组中的最小值II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0154寻找旋转排序数组中的最小值II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(1, 3, 5),
                ArrayFactory.create(2, 2, 2, 0, 1),
                ArrayFactory.create(10, 1, 10, 10, 10),
                AnswerFactory.create(1, 3, 3, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                1, 0, 1, 1
        );
    }

    @Code(info = """
            假设按照升序排序的数组在预先未知的某个点上进行了旋转。

            ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

            请找出其中最小的元素。

            注意数组中可能存在重复的元素。

            示例 1：

            输入: [1,3,5]
            输出: 1
            示例 2：

            输入: [2,2,2,0,1]
            输出: 0
            说明：

            这道题是 寻找旋转排序数组中的最小值 的延伸题目。
            允许重复会影响算法的时间复杂度吗？会如何影响，为什么？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int startIn, int endIn) {
        if (startIn == endIn) return nums[startIn];

        int mid = (startIn + endIn) / 2;

        int s = nums[startIn];
        int m = nums[mid];
        int m1 = nums[mid + 1];
        int e = nums[endIn];

        if (startIn == mid || m > s) {
            // part1 ordered
            if (endIn == mid + 1 || e > m1) {
                // part2 ordered
                return Math.min(s, m1);
            } else {
                // part2 unordered
                return Math.min(s, findMin(nums, mid + 1, endIn));
            }
        } else {
            if (endIn == mid + 1 || e > m1) {
                // part2 ordered
                return Math.min(m1, findMin(nums, startIn, mid));
            } else {
                // part2 unordered
                return Math.min(findMin(nums, mid + 1, endIn), findMin(nums, startIn, mid));
            }
        }
    }
}
