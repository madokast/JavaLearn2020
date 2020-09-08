package com.zrx.algorithm.leetcode.q0290;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Nim 游戏
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0292Nim游戏 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0292Nim游戏.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, 4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                false
        );
    }

    @Code(info = """
            你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。

            你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。

            示例:

            输入: 4
            输出: false\040
            解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
                 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/nim-game
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public boolean canWinNim动态规划(int n) {
        if (n <= 3) return true;

        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;

        for (int i = 4; i <= n; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 2] && dp[i - 3]);
        }

        return dp[n];
    }
}
