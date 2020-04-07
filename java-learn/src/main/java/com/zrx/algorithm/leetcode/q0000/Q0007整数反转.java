package com.zrx.algorithm.leetcode.q0000;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 整数反转
 * <p>
 * Data
 * 2020/3/31-20:42
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0007整数反转 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0007整数反转.class);

    @Override
    public List<Input> getInputs() {
        return List.of(
                Input.create(123),
                Input.create(-123),
                Input.create(120)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return List.of(
                Answer.create(321),
                Answer.create(-321),
                Answer.create(21)
        );
    }

    @Code(info = {
            "给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。\n" +
                    "示例 1:\n" +
                    "输入: 123\n" +
                    "输出: 321\n" +
                    " 示例 2:\n" +
                    "输入: -123\n" +
                    "输出: -321\n" +
                    "示例 3:\n" +
                    "输入: 120\n" +
                    "输出: 21\n" +
                    "注意:\n" +
                    "假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。\n"
    })
    public int reverse(int x) {
        if (x == 0)
            return x;

        int symbol = x > 0 ? 1 : -1;

        int ret = 0;

        x = Math.abs(x);

        final int max_10 = Integer.MAX_VALUE / 10;//214748364
        final int last = Integer.MAX_VALUE - max_10 * 10;//7

        while (x > 0) {
            if (ret > max_10)
                return 0;
            if (ret == max_10 && x % 10 > last)
                return 0;

            ret = ret * 10 + x % 10;

            x /= 10;
        }

        return ret * symbol;

    }
}
