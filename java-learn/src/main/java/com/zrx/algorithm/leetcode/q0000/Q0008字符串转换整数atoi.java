package com.zrx.algorithm.leetcode.q0000;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0008字符串转换整数atoi
 * <p>
 * Data
 * 2020/3/31-20:54
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0008字符串转换整数atoi implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0008字符串转换整数atoi.class);

    @Override
    public List<Input> getInputs() {
        return List.of(
                Input.create("42"),
                Input.create("-42"),
                Input.create("4193 with words"),
                Input.create("words and 987"),
                Input.create("-91283472332"),
                Input.create("99991283472332"),
                Input.create(Integer.MAX_VALUE + "aaaa"),
                Input.create(Integer.MIN_VALUE + "aaa")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return List.of(
                Answer.create(42),
                Answer.create(-42),
                Answer.create(4193),
                Answer.create(0),
                Answer.create(Integer.MIN_VALUE),
                Answer.create(Integer.MAX_VALUE),
                Answer.create(Integer.MAX_VALUE),
                Answer.create(Integer.MIN_VALUE)
        );
    }

    @Code(info = {
            "请你来实现一个 atoi 函数，使其能将字符串转换成整数。\n" +
                    "首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。\n" +
                    "当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。\n" +
                    "该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。\n" +
                    "注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。\n" +
                    "在任何情况下，若函数不能进行有效的转换时，请返回 0。\n" +
                    "说明：\n" +
                    "假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。\n" +
                    "示例 1:\n" +
                    "输入: \"42\"\n" +
                    "输出: 42\n" +
                    "示例 2:\n" +
                    "输入: \"   -42\"\n" +
                    "输出: -42\n" +
                    "解释: 第一个非空白字符为 '-', 它是一个负号。\n" +
                    "     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。\n" +
                    "示例 3:\n" +
                    "输入: \"4193 with words\"\n" +
                    "输出: 4193\n" +
                    "解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。\n" +
                    "示例 4:\n" +
                    "输入: \"words and 987\"\n" +
                    "输出: 0\n" +
                    "解释: 第一个非空字符是 'w', 但它不是数字或正、负号。\n" +
                    "     因此无法执行有效的转换。\n" +
                    "示例 5:\n" +
                    "输入: \"-91283472332\"\n" +
                    "输出: -2147483648\n" +
                    "解释: 数字 \"-91283472332\" 超过 32 位有符号整数范围。 \n" +
                    "     因此返回 INT_MIN (−231) 。\n"
    })
    public int myAtoi(String str) {
        int symbol = 1;
        int ret = 0;
        boolean start = false;
        final char BLANK_SPACE = ' ';

        final int MAX_10 = Integer.MAX_VALUE / 10;
        final int MAX_LAST = Integer.MAX_VALUE - MAX_10 * 10;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '+':
                    if (start)
                        if(symbol<0&&ret<0)
                            return ret;
                        else return symbol*ret;
                    else
                        start = true;
                    break;
                case '-':
                    if (start)
                        if(symbol<0&&ret<0)
                            return ret;
                        else return symbol*ret;
                    else {
                        start = true;
                        symbol = -1;
                    }
                    break;
                case BLANK_SPACE:
                    if (start)
                        if(symbol<0&&ret<0)
                            return ret;
                        else return symbol*ret;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (!start)
                        start = true;
                    if (symbol == 1) {
                        // 正数 判断溢出
                        if(ret>MAX_10||(ret==MAX_10&&(str.charAt(i) - '0')>MAX_LAST))
                            return Integer.MAX_VALUE;
                    }else {
                        // 负数判断溢出
                        if(ret>MAX_10||(ret==MAX_10&&(str.charAt(i) - '0')>MAX_LAST+1))
                            return Integer.MIN_VALUE;
                    }
                    ret = ret * 10 + (str.charAt(i) - '0');
                    break;
                default:
                    if(symbol<0&&ret<0)
                        return ret;
                    else return symbol*ret;

            }
        }

        if(symbol<0&&ret<0)
            return ret;
        else return symbol*ret;
    }
}
