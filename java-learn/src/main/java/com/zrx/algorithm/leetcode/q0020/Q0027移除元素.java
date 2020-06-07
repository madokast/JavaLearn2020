package com.zrx.algorithm.leetcode.q0020;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0027移除元素
 * <p>
 * Data
 * 2020/5/11-15:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0027移除元素 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0027移除元素.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(3, 2, 2, 3), 3,
                ArrayFactory.create(0, 1, 2, 2, 3, 0, 4, 2), 2
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2, 5);
    }

    @Code(info = """
            给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

            不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

            元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

             

            示例 1:

            给定 nums = [3,2,2,3], val = 3,

            函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

            你不需要考虑数组中超出新长度后面的元素。
            示例 2:

            给定 nums = [0,1,2,2,3,0,4,2], val = 2,

            函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

            注意这五个元素可为任意顺序。

            你不需要考虑数组中超出新长度后面的元素。
             

            说明:

            为什么返回数值是整数，但输出的答案是数组呢?

            请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

            你可以想象内部操作如下:

            // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
            int len = removeElement(nums, val);

            // 在函数里修改输入数组对于调用者是可见的。
            // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
            for (int i = 0; i < len; i++) {
                print(nums[i]);
            }
            """, printInputParameters = 0)
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0] == val ? 0 : 1;


        int i = -1;
        int j = 0;


        while (j < nums.length) {
            while (j < nums.length && nums[j] == val)
                j++;

            if (j >= nums.length)
                break;

            if (j - i == 1) {
                j++;
                i++;
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
