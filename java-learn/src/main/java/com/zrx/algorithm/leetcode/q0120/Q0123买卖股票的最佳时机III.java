package com.zrx.algorithm.leetcode.q0120;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 买卖股票的最佳时机 III
 * <p>
 * Data
 * 2020/6/13-19:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0123买卖股票的最佳时机III implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0123买卖股票的最佳时机III.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(3, 3, 5, 0, 0, 3, 1, 4),
                ArrayFactory.create(1, 2, 3, 4, 5),
                ArrayFactory.create(7, 6, 4, 3, 1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                6, 4, 0
        );
    }

    @Code(info = """
            给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

            设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

            注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

            示例 1:

            输入: [3,3,5,0,0,3,1,4]
            输出: 6
            解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
                 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
            示例 2:

            输入: [1,2,3,4,5]
            输出: 4
            解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  \040
                 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  \040
                 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
            示例 3:

            输入: [7,6,4,3,1]\040
            输出: 0\040
            解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maxProfit(int[] prices) {
        int length = prices.length;

        int[] bug1 = new int[length + 1];
        int[] bug2 = new int[length + 1];
        int[] sell1 = new int[length + 1];
        int[] sell2 = new int[length + 1];

        bug1[0] = Integer.MIN_VALUE;
        bug2[0] = Integer.MIN_VALUE;
        sell1[0] = 0;
        sell2[0] = 0;


        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            bug1[i + 1] = Math.max(bug1[i], -price);
            sell1[i + 1] = Math.max(sell1[i], price + bug1[i]);

            bug2[i + 1] = Math.max(bug2[i], sell1[i] - price);
            sell2[i + 1] = Math.max(sell2[i], price + bug2[i]);
        }

        return Math.max(sell1[length], sell2[length]);
    }
}
