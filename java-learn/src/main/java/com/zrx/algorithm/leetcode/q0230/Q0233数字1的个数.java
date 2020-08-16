package com.zrx.algorithm.leetcode.q0230;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 数字 1 的个数
 * 一次性通过，我太开心了
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0233数字1的个数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0233数字1的个数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, 13
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                6
        );
    }

    @Code(info = """
            给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。

            示例:

            输入: 13
            输出: 6\040
            解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/number-of-digit-one
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int countDigitOne(int n) {
        int base = 1;

        int n0 = n;

        int ret = 0;

        int cur = 0;
        int pre = 0;
        int post = 0;

        while (n > 0) {
            pre = n / 10;
            int last = n0 - pre * base * 10;
            cur = last / base;
            post = last - cur * base;

            ret += pre * base;
            if (cur == 1) {
                ret += post + 1;
            } else if (cur > 1) {
                ret += base;
            }


            base *= 10;
            n = pre;
        }

        return ret;
    }
}
