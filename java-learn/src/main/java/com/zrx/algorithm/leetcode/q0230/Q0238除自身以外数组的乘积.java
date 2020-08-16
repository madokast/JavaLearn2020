package com.zrx.algorithm.leetcode.q0230;

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
 * 除自身以外数组的乘积
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0238除自身以外数组的乘积 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0238除自身以外数组的乘积.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(1, 2, 3, 4)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                (Object) ArrayFactory.create(24, 12, 8, 6)
        );
    }

    @Code(info = """
            给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

             

            示例:

            输入: [1,2,3,4]
            输出: [24,12,8,6]
             

            提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

            说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

            进阶：
            你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/product-of-array-except-self
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] arr1 = Arrays.copyOf(nums, length);
        int[] arr2 = Arrays.copyOf(nums, length);

        arr1[0] = 1;
        for (int i = 1; i < length; i++) {
            arr1[i] = nums[i - 1] * arr1[i - 1];
        }

        arr2[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            arr2[i] = nums[i + 1] * arr2[i + 1];
        }

        for (int i = 0; i < length; i++) {
            nums[i] = arr1[i] * arr2[i];
        }

        return nums;
    }
}
