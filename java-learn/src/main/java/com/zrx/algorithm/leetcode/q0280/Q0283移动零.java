package com.zrx.algorithm.leetcode.q0280;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 移动零
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0283移动零 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0283移动零.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(0, 1, 0, 3, 12),
                (Object) ArrayFactory.create(1, 2),
                (Object) ArrayFactory.create(2, 1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                (Object) ArrayFactory.create(1, 3, 12, 0, 0),
                (Object) ArrayFactory.create(1, 2),
                (Object) ArrayFactory.create(2, 1)
        );
    }

    @Code(info = """
            给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

            示例:

            输入: [0,1,0,3,12]
            输出: [1,3,12,0,0]
            说明:

            必须在原数组上操作，不能拷贝额外的数组。
            尽量减少操作次数。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/move-zeroes
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[] moveZeroes(int[] nums) {
        int length = nums.length;

        int i = 0;
        while (i < length && nums[i] != 0) i++;
        for (int j = 0; j < length; j++) {
            if (nums[j] != 0 && i < j) {
                swap(nums, i, j);
                i++;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
