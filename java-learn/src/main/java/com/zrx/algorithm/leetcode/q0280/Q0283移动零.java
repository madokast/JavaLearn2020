package com.zrx.algorithm.leetcode.q0280;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
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
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

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
    public void moveZeroes(int[] nums) {

    }
}
