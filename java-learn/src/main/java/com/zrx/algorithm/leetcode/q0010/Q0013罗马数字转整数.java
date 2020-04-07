package com.zrx.algorithm.leetcode.q0010;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0013罗马数字转整数
 * <p>
 * Data
 * 2020/4/5-12:11
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0013罗马数字转整数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0013罗马数字转整数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "III", "IV", "IX", "LVIII", "MCMXCIV"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(3, 4, 9, 58, 1994);
    }

    @Code(info = {
            "罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。\n" +
                    "字符          数值\n" +
                    "I             1\n" +
                    "V             5\n" +
                    "X             10\n" +
                    "L             50\n" +
                    "C             100\n" +
                    "D             500\n" +
                    "M             1000\n" +
                    "例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。\n" +
                    "通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：\n" +
                    "I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。\n" +
                    "X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 \n" +
                    "C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。\n" +
                    "给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。\n" +
                    "示例 1:\n" +
                    "输入: \"III\"\n" +
                    "输出: 3\n" +
                    "示例 2:\n" +
                    "输入: \"IV\"\n" +
                    "输出: 4\n" +
                    "示例 3:\n" +
                    "输入: \"IX\"\n" +
                    "输出: 9\n" +
                    "示例 4:\n" +
                    "输入: \"LVIII\"\n" +
                    "输出: 58\n" +
                    "解释: L = 50, V= 5, III = 3.\n" +
                    "示例 5:\n" +
                    "输入: \"MCMXCIV\"\n" +
                    "输出: 1994\n" +
                    "解释: M = 1000, CM = 900, XC = 90, IV = 4.\n",
            "执行用时 :4 ms, 在所有 Java 提交中击败了99.98%的用户"
    })
    public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    num += 1000;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'C':
                    if (i == s.length() - 1)
                        num += 100;
                    else if (s.charAt(i + 1) == 'D') {
                        num += 400;
                        i++;
                    } else if (s.charAt(i + 1) == 'M') {
                        num += 900;
                        i++;
                    } else
                        num += 100;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'X':
                    if (i == s.length() - 1)
                        num += 10;
                    else if (s.charAt(i + 1) == 'C') {
                        num += 90;
                        i++;
                    } else if (s.charAt(i + 1) == 'L') {
                        num += 40;
                        i++;
                    } else
                        num += 10;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'I':
                    if (i == s.length() - 1)
                        num += 1;
                    else if (s.charAt(i + 1) == 'V') {
                        num += 4;
                        i++;
                    } else if (s.charAt(i + 1) == 'X') {
                        num += 9;
                        i++;
                    } else
                        num += 1;
            }
        }

        return num;
    }

    //private final String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    //private final int[] romanNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private final char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    private final short[] romanNum = {1000, 500, 100, 50, 10, 5, 1};
}
