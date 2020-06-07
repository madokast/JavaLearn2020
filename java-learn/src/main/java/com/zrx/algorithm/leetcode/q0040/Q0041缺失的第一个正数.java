package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0041缺失的第一个正数
 * <p>
 * Data
 * 2020/5/20-17:56
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0041缺失的第一个正数 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0041缺失的第一个正数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(1, 2, 0),
                ArrayFactory.create(3, 4, -1, 1),
                ArrayFactory.create(7, 8, 9, 11, 12),
                ArrayFactory.create(-1, 1, 3),
                ArrayFactory.create(1, -1, 3),
                ArrayFactory.create(1, 1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(3, 2, 1, 2, 2, 2);
    }

    @Code(info = """
            给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

            示例 1:

            输入: [1,2,0]
            输出: 3
            示例 2:

            输入: [3,4,-1,1]
            输出: 2
            示例 3:

            输入: [7,8,9,11,12]
            输出: 1
             
            提示：
            你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
            """)
    // 这个问题真难啊
    public int firstMissingPositive(int[] nums) {
        LOGGER.info("nums = {}", ToString.apply(nums));

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length &&
                    (i + 1 != nums[i]) &&
                    nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        LOGGER.info("nums = {}", ToString.apply(nums));

        int i = 0;
        while (i < nums.length && nums[i] == i + 1)
            i++;

        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
