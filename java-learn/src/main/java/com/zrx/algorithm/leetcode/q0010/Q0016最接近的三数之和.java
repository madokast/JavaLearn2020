package com.zrx.algorithm.leetcode.q0010;

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
 * Q0016最接近的三数之和
 * <p>
 * Data
 * 2020/4/10-22:18
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0016最接近的三数之和 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0016最接近的三数之和.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(-1, 2, 1, -4), 1,
                ArrayFactory.create(-3, -2, -5, 3, -4), -1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2, -2);
    }

    @Code(info = {
            "给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。" +
                    "返回这三个数的和。假定每组输入只存在唯一答案。\n" +
                    "例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.\n" +
                    "与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).\n"
    })
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    if (sum - target < Math.abs(ans - target)) {
                        ans = sum;
                    }
                    k--;
                } else if (sum < target) {
                    if (target - sum < Math.abs(ans - target)) {
                        ans = sum;
                    }
                    j++;
                } else
                    return target;
            }
        }

        return ans;
    }
}
