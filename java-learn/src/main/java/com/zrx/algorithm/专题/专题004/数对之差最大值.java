package com.zrx.algorithm.专题.专题004;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 数对之差最大值
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

@Component
public class 数对之差最大值 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(数对之差最大值.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(1, 4, 17, 3, 2, 9)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                15
        );
    }

    @Code(group = "专题", number = 4, info = """
            数组中取两个元素，i<j，求max([i]-[j])
            动态规划法，dp[i] = max[0,i) - [i]
            返回 max(dp)
            """)
    public int solve节省空间(int[] arr) {
        int length = arr.length;

        int max = arr[0];

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < length; i++) {
            int cur = arr[i];
            int dpi = max - cur;
            max = Math.max(max, cur);

            ans = Math.max(ans, dpi);
        }

        return ans;
    }

    public int solve原算法(int[] arr) {
        int length = arr.length;

        int[] dp = new int[length];
        int[] max = new int[length];

        dp[0] = 0;
        max[0] = arr[0];

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < length; i++) {
            int cur = arr[i];
            dp[i] = max[i - 1] - cur;
            max[i] = Math.max(max[i - 1], cur);

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
