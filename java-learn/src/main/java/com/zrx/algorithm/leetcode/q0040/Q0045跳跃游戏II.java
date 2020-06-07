package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Code;
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
                (Object) ArrayFactory.create(2, 3, 1, 1, 4),
                (Object) ArrayFactory.create(0)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2, 0);
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
        // 很慢的动态规划方法
//        return jumpDp(nums);

        // 贪心算法
        return jumpGreed(nums);
    }

    // 贪心算法
    private int jumpGreed(int[] nums) {
        int stepNumber = 0;
        int pos = 0;


        // 还没到达终点
        while (pos < nums.length - 1) {
            // 当前位置可以跳 1-cur
            int cur = nums[pos];

            // 局部最优
            int localMax = 0;
            // 满足局部最优时，下一跳到的位置
            int nextPosition = 0;

            // 下一跳可以到 i
            for (int i = pos + 1; i <= pos + cur; i++) {

                // i 到了终点，那就立马返回
                if (i >= nums.length - 1) {
                    return ++stepNumber;
                }

                // 下一条位置的值
                int next = nums[i];

                if (i + next > localMax) {
                    localMax = i + next;
                    nextPosition = i;
                }
            }

            stepNumber++;
            pos = nextPosition;
        }

        return stepNumber;
    }


    // 很慢的动态规划方法
    private int jumpDp(int[] nums) {
        int length = nums.length;
        int[] times = new int[length];

        // 若处于终点，当然是跳 0 次
        times[length - 1] = 0;

        for (int i = length - 2; i >= 0; i--) {

            // 当前可以跳的距离
            int distance = nums[i];

            int min = times[i + 1];

            for (int j = i + 2; j <= i + distance && j < length; j++) {
                min = Math.min(min, times[j]);
            }

            times[i] = 1 + min;
        }

        return times[0];
    }
}
