package com.zrx.algorithm.leetcode.q0020;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0026删除排序数组中的重复项
 * <p>
 * Data
 * 2020/5/11-15:09
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0026删除排序数组中的重复项 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0026删除排序数组中的重复项.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(1, 1, 2),
                ArrayFactory.create(0, 0, 1, 1, 1, 2, 2, 3, 3, 4),
                ArrayFactory.create(1, 2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2, 5, 2);
    }

    @Code(info = """
            给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

            不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

             

            示例 1:

            给定数组 nums = [1,1,2],

            函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

            你不需要考虑数组中超出新长度后面的元素。
            示例 2:

            给定 nums = [0,0,1,1,1,2,2,3,3,4],

            函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

            你不需要考虑数组中超出新长度后面的元素。
             

            说明:

            为什么返回数值是整数，但输出的答案是数组呢?

            请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

            你可以想象内部操作如下:

            // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
            int len = removeDuplicates(nums);

            // 在函数里修改输入数组对于调用者是可见的。
            // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
            for (int i = 0; i < len; i++) {
                print(nums[i]);
            }
            """, printInputParameters = 0)
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return 1;

        // len>1

        int i = 0;
        int j = 1;

        while (j < nums.length) {

            while (j < nums.length && nums[i] == nums[j])
                j++;

            if (j >= nums.length) break;

            if (j - i == 1) {
                i++;
                j++;
            } else {
                swap(nums, ++i, j++);
            }
        }


        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
