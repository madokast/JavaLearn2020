package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 跳跃游戏
 * <p>
 * Data
 * 2020/5/26-15:57
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0055跳跃游戏 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0055跳跃游戏.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info= """
            给定一个非负整数数组，你最初位于数组的第一个位置。

            数组中的每个元素代表你在该位置可以跳跃的最大长度。

            判断你是否能够到达最后一个位置。

            示例 1:

            输入: [2,3,1,1,4]
            输出: true
            解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
            示例 2:

            输入: [3,2,1,0,4]
            输出: false
            解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/jump-game
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean canJump(int[] nums) {
        return false;
    }
}
