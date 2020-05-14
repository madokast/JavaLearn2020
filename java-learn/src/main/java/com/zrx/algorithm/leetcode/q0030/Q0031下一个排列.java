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
 * 下一个排列
 * <p>
 * Data
 * 2020/5/13-17:43
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0031下一个排列 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0031下一个排列.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(1, 2, 3),
                ArrayFactory.create(3, 2, 1),
                ArrayFactory.create(1, 1, 5),
                ArrayFactory.create(1, 3, 2),
                ArrayFactory.create(2, 3, 1),
                ArrayFactory.create(1, 5, 1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ArrayFactory.create(1, 3, 2),
                ArrayFactory.create(1, 2, 3),
                ArrayFactory.create(1, 5, 1),
                ArrayFactory.create(2, 1, 3),
                ArrayFactory.create(3, 1, 2),
                ArrayFactory.create(5, 1, 1)
        );
    }


    @Code(info = """
            实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

            如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

            必须原地修改，只允许使用额外常数空间。

            以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
            1,2,3 → 1,3,2
            3,2,1 → 1,2,3
            1,1,5 → 1,5,1

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/next-permutation
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """, printInputParameters = 0)
    public int[] nextPermutation(int[] nums) {
        int length = nums.length;

        if (length == 0 || length == 1)
            return nums;

        if (nums[length - 2] < nums[length - 1]) {
            swap(nums, length - 2, length - 1);
        } else {
            int i;
            for (i = length - 1; i >= 1; i--) {
                if (nums[i] > nums[i - 1]) {
                    break;
                }
            }

            if (i == 0) {
                Arrays.sort(nums);
            } else {
                int target = nums[i - 1];
                int firstLargeThanIndex = findFirstLargeThan(target, nums, i, length);
                LOGGER.info("{}-{}-{}", ToString.apply(nums), i, firstLargeThanIndex);
                swap(nums, i - 1, firstLargeThanIndex);
                Arrays.sort(nums, i, length);
            }

        }

        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        LOGGER.info("{}-{}-{}", ToString.apply(arr), i, j);
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 找数组种，比 target 大的最小的元素的索引
     * arr 数组 在此间是反序排列的 即从大到小
     *
     * @param target         目标
     * @param arr            数组
     * @param startIncluding 数组起始
     * @param EndExcluding   数组终点
     * @return 比 target 大的最小的元素的索引
     */
    private int findFirstLargeThan(int target, int[] arr, int startIncluding, int EndExcluding) {
        int max = EndExcluding - 1;
        int min = startIncluding;


        while (max > min) {
            int index = (max + min) / 2;

            if (arr[index] > target) {
                min = index + 1;
            } else if (arr[index] < target) {
                max = index - 1;
            } else {
                max = index;
                min = index;
            }
        }

        LOGGER.info("{}-{}", max, min);

        while (arr[max] <= target)
            max--;

        return max;
    }
}
