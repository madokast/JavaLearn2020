package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.constraints.DecimalMax;
import java.util.*;

/**
 * Description
 * 分数到小数
 * <p>
 * Data
 * 2020/7/4-22:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0166分数到小数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0166分数到小数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                1, 2,
                2, 1,
                2, 3,
                1, 7,
                1, 6,
                16, 99,
                -1, -2147483648
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                "0.5",
                "2",
                "0.(6)",
                "0.(142857)",
                "0.1(6)",
                "0.(16)",
                "0.0000000004656612873077392578125"
        );
    }

    @Code(info = """
            给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

            如果小数部分为循环小数，则将循环的部分括在括号内。

            示例 1:

            输入: numerator = 1, denominator = 2
            输出: "0.5"
            示例 2:

            输入: numerator = 2, denominator = 1
            输出: "2"
            示例 3:

            输入: numerator = 2, denominator = 3
            输出: "0.(6)"

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        boolean sign = true; // true -> +
        if (numerator > 0) {
            numerator = -numerator;
            sign = false;
        }

        if (denominator > 0) {
            denominator = -denominator;
            sign = !sign;
        }


        long integerPart = (long) numerator / denominator;
        StringBuilder decimalPart = new StringBuilder(32);
        String decimalPart1 = "";
        String decimalPart2 = "";

        long res = numerator % denominator;

        boolean hasRes = true;
        boolean clear = false;

        if (res == 0) hasRes = false;
        else {
            Map<Long, Integer> resMap = new HashMap<>();


            int index = 0;
            while (!resMap.containsKey(res)) {
                resMap.put(res, index);
                index++;
                res *= 10;
                decimalPart.append(res / denominator);
                LOGGER.info("{}/{} = {}", res, denominator, res / denominator);
                LOGGER.info("{}%{} = {}", res, denominator, res % denominator);
                res = res % denominator;
                if (res == 0) {
                    clear = true;
                    break;
                }
            }

            if (res != 0) {
                Integer firstAppear = resMap.get(res);
                LOGGER.info("firstAppear = {}", firstAppear);

                decimalPart1 = decimalPart.substring(0, firstAppear);
                decimalPart2 = decimalPart.substring(firstAppear, decimalPart.length());

                LOGGER.info("res = {}", res);

                LOGGER.info("integerPart = {}", integerPart);
                LOGGER.info("decimalPart = {}", decimalPart);
            }


        }

        return (sign ? "" : "-") + integerPart + (hasRes ? ("." + (clear ? decimalPart : (decimalPart1 + ("(" + decimalPart2 + ")")))) : "");
    }
}
