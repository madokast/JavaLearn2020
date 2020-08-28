package com.zrx.algorithm.leetcode.q0260;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Description
 * 缺失数字
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0268缺失数字 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0268缺失数字.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(3, 0, 1),
                ArrayFactory.create(9, 6, 4, 2, 3, 5, 7, 0, 1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                2, 8
        );
    }

    @Code(info = """
            给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

             

            示例 1:

            输入: [3,0,1]
            输出: 2
            示例 2:

            输入: [9,6,4,2,3,5,7,0,1]
            输出: 8
             

            说明:
            你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/missing-number
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int missingNumber(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] != n && nums[i] != i) {
                swap(nums, i, nums[i]);
            }
        }

        LOGGER.info("nums = {}", nums);

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }

        return n;
    }

    void swap(int[] arr, int i, int j) {
        int ai = arr[i];
        int aj = arr[j];
        if (ai != aj) {
            arr[i] = aj;
            arr[j] = ai;
        }
    }
}
