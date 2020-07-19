package com.zrx.algorithm.leetcode.q0180;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 旋转数组
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0189旋转数组 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0189旋转数组.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(1, 2, 3, 4, 5, 6, 7),3,
                ArrayFactory.create(-1, -100, 3, 99),2
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ArrayFactory.create(5, 6, 7, 1, 2, 3, 4),
                ArrayFactory.create(3, 99, -1, -100)
        );
    }

    @Code(info = """
            给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

            示例 1:

            输入: [1,2,3,4,5,6,7] 和 k = 3
            输出: [5,6,7,1,2,3,4]
            解释:
            向右旋转 1 步: [7,1,2,3,4,5,6]
            向右旋转 2 步: [6,7,1,2,3,4,5]
            向右旋转 3 步: [5,6,7,1,2,3,4]
            示例 2:

            输入: [-1,-100,3,99] 和 k = 2
            输出: [3,99,-1,-100]
            解释:\040
            向右旋转 1 步: [99,-1,-100,3]
            向右旋转 2 步: [3,99,-1,-100]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/rotate-array
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[] rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);

        return nums;
    }

    private void reverse(int[] s, int startIn, int endIn) {
        while (startIn < endIn) {
            s[startIn] = (s[startIn] ^ s[endIn]);
            s[endIn] = (s[startIn] ^ s[endIn]);
            s[startIn] = (s[startIn] ^ s[endIn]);

            startIn++;
            endIn--;
        }
    }
}
