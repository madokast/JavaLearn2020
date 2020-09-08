package com.zrx.algorithm.leetcode.q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * q0137只出现一次的数字II
 * <p>
 * Data
 * 2020/6/21-17:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class q0137只出现一次的数字II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(q0137只出现一次的数字II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(2, 2, 3, 2),
                ArrayFactory.create(0, 1, 0, 1, 0, 1, 99)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                3, 99
        );
    }

    @Code(info = """
            给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

            说明：

            你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

            示例 1:

            输入: [2,2,3,2]
            输出: 3
            示例 2:

            输入: [0,1,0,1,0,1,99]
            输出: 99

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/single-number-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int singleNumber(int[] nums) {
        int t1 = 0;
        int t2 = 0;

        for (int num : nums) {
            t2 ^= (t1 & num);
            t1 ^= num;

            int allOne = t1&t2;
            t1^=allOne;
            t2^=allOne;
        }


        return t1;
    }
}
