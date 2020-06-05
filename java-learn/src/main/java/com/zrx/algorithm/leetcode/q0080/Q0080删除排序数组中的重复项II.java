package com.zrx.algorithm.leetcode.q0080;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 删除排序数组中的重复项 II
 * <p>
 * Data
 * 2020/6/2-11:46
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0080删除排序数组中的重复项II implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0080删除排序数组中的重复项II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(1, 1, 1, 2, 2, 3),
                ArrayFactory.create(0, 0, 1, 1, 1, 1, 2, 3, 3),
                ArrayFactory.create(0, 0, 0)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(5, 7, 2);
    }

    @Code(info = """
            给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

            不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

            示例 1:

            给定 nums = [1,1,1,2,2,3],

            函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

            你不需要考虑数组中超出新长度后面的元素。
            示例 2:

            给定 nums = [0,0,1,1,1,1,2,3,3],

            函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。

            你不需要考虑数组中超出新长度后面的元素。
            说明:

            为什么返回数值是整数，但输出的答案是数组呢?

            请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

            你可以想象内部操作如下:

            // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
            int len = removeDuplicates(nums);

            // 在函数里修改输入数组对于调用者是可见的。
            // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
            for (int i = 0; i < len; i++) {
                print(nums[i]);
            }

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int removeDuplicates(int[] nums) {
        int length = nums.length;

        if (length <= 2)
            return length;

        int j = -1;
        int pre = nums[0] - 1;
        int times = 1;
        for (int i = 0; i < length; i++) {
            int cur = nums[i];

            if (cur == pre) {
                times++;

                if (times == 2) {
                    j++;
                    swap(nums, i, j);
                } else if (times == 3) {
                    while (++i < length && nums[i] == pre)
                        ;
                    if (i < length) {
                        pre = nums[i];
                        times = 1;
                        j++;
                        swap(nums, i, j);
                    } else
                        break;
                }

            } else {
                pre = cur;
                times = 1;
                j++;
                swap(nums, i, j);
            }
        }


        return j + 1;
    }

    private void swap(int[] a, int i, int j) {
        if (i != j && a[i] != a[j]) {
            a[i] = a[i] ^ a[j];
            a[j] = a[i] ^ a[j];
            a[i] = a[i] ^ a[j];
        }
    }
}
