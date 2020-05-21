package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0045跳跃游戏II
 * <p>
 * Data
 * 2020/5/20-18:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0045跳跃游戏II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0045跳跃游戏II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(2, 3, 1, 1, 4)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2);
    }

    @Code(info = """
            给定一个非负整数数组，你最初位于数组的第一个位置。

            数组中的每个元素代表你在该位置可以跳跃的最大长度。

            你的目标是使用最少的跳跃次数到达数组的最后一个位置。

            示例:

            输入: [2,3,1,1,4]
            输出: 2
            解释: 跳到最后一个位置的最小跳跃数是 2。
                 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
            说明:

            假设你总是可以到达数组的最后一个位置。
            """)
    public int jump(int[] nums) {
        return 0;
    }
}
