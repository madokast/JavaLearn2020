package com.zrx.algorithm.leetcode.q0010;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 整数转罗马数字
 * <p>
 * Data
 * 2020/4/5-11:42
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0012整数转罗马数字 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0012整数转罗马数字.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                3, 4, 9, 58, 1994
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create("III", "IV", "IX", "LVIII", "MCMXCIV");
    }

    @Code(info = {
            "罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。\n" +
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
                    "给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。\n" +
                    "示例 1:\n" +
                    "输入: 3\n" +
                    "输出: \"III\"\n" +
                    "示例 2:\n" +
                    "输入: 4\n" +
                    "输出: \"IV\"\n" +
                    "示例 3:\n" +
                    "输入: 9\n" +
                    "输出: \"IX\"\n" +
                    "示例 4:\n" +
                    "输入: 58\n" +
                    "输出: \"LVIII\"\n" +
                    "解释: L = 50, V = 5, III = 3.\n" +
                    "示例 5:\n" +
                    "输入: 1994\n" +
                    "输出: \"MCMXCIV\"\n" +
                    "解释: M = 1000, CM = 900, XC = 90, IV = 4.\n",
            "执行用时 :4 ms, 在所有 Java 提交中击败了100.00%的用户"
    })
    public String intToRoman(int num) {
        // 贪心算法
        StringBuilder sb = new StringBuilder();

        int t = num / 1000;
        sb.append(p4[t]);

        num -= t * 1000;
        t = num / 100;
        sb.append(p3[t]);

        num -= t * 100;
        t = num / 10;
        sb.append(p2[t]);

        num -= t * 10;
        sb.append(p1[num]);

        return sb.toString();
    }

    //private final String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    //private final int[] romanNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static final String[] p4 = {"", "M", "MM", "MMM"};//0000 1000 2000 3000
    private static final String[] p3 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] p2 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] p1 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
}

