package com.zrx.algorithm.leetcode.Q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 只出现一次的数字
 * <p>
 * Data
 * 2020/6/21-17:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class q0136只出现一次的数字 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(q0136只出现一次的数字.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

            说明：

            你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

            示例 1:

            输入: [2,2,1]
            输出: 1
            示例 2:

            输入: [4,1,2,1,2]
            输出: 4

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/single-number
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int singleNumber(int[] nums) {
        return -1;
    }

}
