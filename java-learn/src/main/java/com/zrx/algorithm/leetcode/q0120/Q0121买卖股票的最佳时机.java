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
 * 买卖股票的最佳时机
 * <p>
 * Data
 * 2020/6/13-19:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0121买卖股票的最佳时机 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0121买卖股票的最佳时机.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(7, 1, 5, 3, 6, 4),
                ArrayFactory.create(7, 6, 4, 3, 1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                5, 0
        );
    }

    @Code(info = """
            给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

            如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

            注意：你不能在买入股票前卖出股票。

             

            示例 1:

            输入: [7,1,5,3,6,4]
            输出: 5
            解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
                 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
            示例 2:

            输入: [7,6,4,3,1]
            输出: 0
            解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maxProfit(int[] prices) {
        int length = prices.length;

        int[] bug = new int[length + 1];
        int[] sell = new int[length + 1];

        bug[0] = Integer.MIN_VALUE;
        sell[0] = 0;


        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            bug[i + 1] = Math.max(bug[i], -price);
            sell[i + 1] = Math.max(sell[i], price + bug[i]);
        }

        return sell[length];
    }
}
