package com.zrx.algorithm.leetcode.q0270;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 整数转换英文表示
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0273整数转换英文表示 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0273整数转换英文表示.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                123,
                12345,
                1234567,
                1234567891,
                100,
                1000
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                "One Hundred Twenty Three",
                "Twelve Thousand Three Hundred Forty Five",
                "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
                "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
                "One Hundred",
                "One Thousand"
        );
    }

    @Code(info = """
            将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 。

            示例 1:

            输入: 123
            输出: "One Hundred Twenty Three"
            示例 2:

            输入: 12345
            输出: "Twelve Thousand Three Hundred Forty Five"
            示例 3:

            输入: 1234567
            输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
            示例 4:

            输入: 1 234 567 891
            输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/integer-to-english-words
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();

        if (num > 0) {
            int a = num % 1000;
            String solve = solveXXX(a);
            sb.insert(0, solve);
            num /= 1000;
        }

        if (num > 0) {
            int a = num % 1000;
            if (a != 0) {
                sb.insert(0, " Thousand ");
                String solve = solveXXX(a);
                sb.insert(0, solve);
            }

            num /= 1000;
        }

        if (num > 0) {
            int a = num % 1000;
            if (a != 0) {
                sb.insert(0, " Million ");
                String solve = solveXXX(a);
                sb.insert(0, solve);
            }
            num /= 1000;
        }

        if (num > 0) {
            int a = num % 1000;
            if (a != 0) {
                sb.insert(0, " Billion ");
                String solve = solveXXX(a);
                sb.insert(0, solve);
            }
            num /= 1000;
        }

        return sb.toString().trim();
    }

    private String solveXXX(int a) {
        //Eight Hundred Ninety One
        if (a == 0) return "";
        else if (a < 10) return solve1(a);
        else if (a < 20) return solve1x(a);
        else if (a < 100) {
            int x0 = (a / 10) * 10;
            int x = a % 10;
            String sx0 = solveX0(x0);
            if (x == 0) return sx0;
            else return sx0 + " " + solve1(x);
        } else {
            int x00 = a / 100;
            String s = solve1(x00) + " Hundred";
            int xx = a % 100;
            if (xx == 0) return s;
            else return s + " " + solveXXX(xx);
        }

    }

    private String solve1(int a) {
        switch (a) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }

        return null;
    }

    private String solve1x(int a) {
        switch (a) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }

        return null;
    }

    private String solveX0(int a) {
        switch (a) {
            case 10:
                return "Ten";
            case 20:
                return "Twenty";
            case 30:
                return "Thirty";
            case 40:
                return "Forty";
            case 50:
                return "Fifty";
            case 60:
                return "Sixty";
            case 70:
                return "Seventy";
            case 80:
                return "Eighty";
            case 90:
                return "Ninety";
        }

        return null;
    }
}
