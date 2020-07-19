package com.zrx.algorithm.leetcode.q0180;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 买卖股票的最佳时机 IV
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0188买卖股票的最佳时机IV implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0188买卖股票的最佳时机IV.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                2, ArrayFactory.create(2, 4, 1),
                2, ArrayFactory.create(3, 2, 6, 5, 0, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                2, 7
        );
    }

    @Code(info = """
            给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

            设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

            注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

            示例 1:

            输入: [2,4,1], k = 2
            输出: 2
            解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
            示例 2:

            输入: [3,2,6,5,0,3], k = 2
            输出: 7
            解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
                 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maxProfit(int k, int[] prices) {
        if(k<1) return 0;
        int len = prices.length;
        if(len<2) return 0;

        k = Math.min(k,len);

        int[] sell = new int[k + 1];
        int[] buy = new int[k + 1];

        Arrays.fill(buy, -prices[0]);

        for (int i = 1; i < len; i++) {
            int p = prices[i];

            buy[1] = Math.max(-p, buy[1]);
            sell[1] = Math.max(sell[1], buy[1] + p);

            for (int j = 2; j <= k; j++) {
                buy[j] = Math.max(sell[j - 1] - p, buy[j]);
                sell[j] = Math.max(sell[j], buy[j] + p);
            }
        }


        return sell[k];
    }
}
