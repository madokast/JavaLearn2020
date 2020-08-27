package com.zrx.algorithm.leetcode.q0260;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.OptionalSet;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 只出现一次的数字 III
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0260只出现一次的数字III implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0260只出现一次的数字III.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(1, 2, 1, 3, 2, 5),
                (Object) ArrayFactory.create(1, 2, 1, 3, 2, 5),
                (Object) ArrayFactory.create(1, 2, 1, 3, 2, 5),
                (Object) ArrayFactory.create(1, 2, 1, 3, 2, 5)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                OptionalSet.of(
                        new int[]{3, 5},
                        new int[]{5, 3}
                ), OptionalSet.of(
                        new int[]{3, 5},
                        new int[]{5, 3}
                ), OptionalSet.of(
                        new int[]{5, 3},
                        new int[]{3, 5}
                ), OptionalSet.of(
                        new int[]{5, 3},
                        new int[]{3, 5}
                )
        );
    }

    @Code(info = """
            给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

            示例 :

            输入: [1,2,1,3,2,5]
            输出: [3,5]
            注意：

            结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
            你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/single-number-iii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[] singleNumber(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s = s ^ num;
        }

        int leadingZeros = Integer.numberOfLeadingZeros(s);
        int selector = 1 << (32 - 1 - leadingZeros);
        int a = 0;
        int b = 0;

        for (int num : nums) {
            if ((num & selector) == 0) {
                a = a ^ num;
            } else {
                b = b ^ num;
            }
        }


        return new int[]{a, b};
    }
}
