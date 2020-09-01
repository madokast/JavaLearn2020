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
 * 寻找重复数
 * 超级难的题目
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0287寻找重复数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0287寻找重复数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(1, 3, 4, 2, 2),
                ArrayFactory.create(3, 1, 3, 4, 2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                2, 3
        );
    }

    @Code(info = """
            给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
            假设只有一个重复的整数，找出这个重复的数。

            示例 1:

            输入: [1,3,4,2,2]
            输出: 2
            示例 2:

            输入: [3,1,3,4,2]
            输出: 3
            说明：

            不能更改原数组（假设数组是只读的）。
            只能使用额外的 O(1) 的空间。
            时间复杂度小于 O(n2) 。
            数组中只有一个重复的数字，但它可能不止重复出现一次。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/find-the-duplicate-number
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (nums[slow] != nums[fast]);

        fast = 0;
        while (nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return nums[slow];
    }
}
