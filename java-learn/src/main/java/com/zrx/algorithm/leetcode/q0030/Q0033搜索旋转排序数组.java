package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 搜索旋转排序数组
 * <p>
 * Data
 * 2020/5/13-17:45
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0033搜索旋转排序数组 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0033搜索旋转排序数组.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(4, 5, 6, 7, 0, 1, 2), 0,
                ArrayFactory.create(4, 5, 6, 7, 0, 1, 2), 3,
                ArrayFactory.create(1, 3), 0,
                ArrayFactory.create(1, 3), 2,
                ArrayFactory.create(5, 1, 2, 3, 4), 1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(4, -1, -1, -1, 1);
    }

    @Code(info = """
            假设按照升序排序的数组在预先未知的某个点上进行了旋转。

            ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

            搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

            你可以假设数组中不存在重复的元素。

            你的算法时间复杂度必须是 O(log n) 级别。

            示例 1:

            输入: nums = [4,5,6,7,0,1,2], target = 0
            输出: 4
            示例 2:

            输入: nums = [4,5,6,7,0,1,2], target = 3
            输出: -1

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int min, int max) {
        LOGGER.info("{},{},{},{}", ToString.apply(nums), target, min, max);

        if (min > max)
            return -1;

        if (min == max)
            return nums[max] == target ? max : -1;

        int half = (max + min) / 2;

        int start = nums[min];
        if (start == target)
            return min;

        int end = nums[max];
        if (end == target)
            return max;


        int mid = nums[half];
        if (mid == target)
            return half;

        if (end >= mid) {
            // mid - end 有序
            if (target >= mid && target <= end) {
                // 一定在其中，没有就没有
                int i = Arrays.binarySearch(nums, half, max + 1, target);
                if (i < 0 || i >= nums.length)
                    return -1;
                else
                    return nums[i] == target ? i : -1;
            }
            // start - mid 无序
            return search(nums, target, min + 1, half - 1);

        } else {
            // start - mid 有序
            if (target >= start && target <= mid) {
                int i = Arrays.binarySearch(nums, min, half + 1, target);
                if (i < 0 || i >= nums.length)
                    return -1;
                else
                    return nums[i] == target ? i : -1;
            }
            // mid - end 无序
            return search(nums, target, half + 1, max - 1);
        }
    }
}
