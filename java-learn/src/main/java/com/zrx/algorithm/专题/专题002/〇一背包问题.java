package com.zrx.algorithm.专题.专题002;

import com.zrx.Invoking;
import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 〇一背包问题
 * <p>
 * Data
 * 2020/5/24-17:32
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-05-24 17:32", details = "〇一背包问题")
public class 〇一背包问题 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(〇一背包问题.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                3,
                5,
                ArrayFactory.create(1, 2, 3, 4),
                ArrayFactory.create(2, 4, 4, 5)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(8);
    }

    @Code(group = "专题", number = 2)
    public int solve(int bagWeight, int[] weights, int[] values) {
        int number = weights.length;

        int[][] dp = new int[bagWeight + 1][number];

        for (int i = 0; i < number; i++) {
            int weight = weights[i];
            int value = values[i];

            for (int j = 1; j <= bagWeight; j++) {
                dp[j][i] = Math.max(
                        i - 1 >= 0 ? dp[j][i - 1] : 0,
                        (j - weight >= 0 && i - 1 >= 0) ? dp[j - weight][i - 1] + value : 0
                );
            }
        }

        return dp[bagWeight][number - 1];
    }

    @Invoking(createdTime = "2020-05-24 18:04")
    public void invoke() {
        this.run();
    }
}
