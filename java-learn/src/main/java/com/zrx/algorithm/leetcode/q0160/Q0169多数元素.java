package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 多数元素
 * <p>
 * Data
 * 2020/7/4-22:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0169多数元素 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0169多数元素.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create();
    }

    @Code(info = """
            给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

            你可以假设数组是非空的，并且给定的数组总是存在多数元素。

             

            示例 1:

            输入: [3,2,3]
            输出: 3
            示例 2:

            输入: [2,2,1,1,1,2,2]
            输出: 2

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/majority-element
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int majorityElement(int[] nums) {
        return -1;
    }
}
