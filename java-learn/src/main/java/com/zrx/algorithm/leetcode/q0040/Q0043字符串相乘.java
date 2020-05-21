package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Description
 * Q0043字符串相乘
 * <p>
 * Data
 * 2020/5/20-18:15
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0043字符串相乘 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0043字符串相乘.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "2", "3",
                "123", "456",
                "140", "721"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                "6",
                "56088",
                (140 * 721) + ""
        );
    }

    @Code(info = """
            给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

            示例 1:

            输入: num1 = "2", num2 = "3"
            输出: "6"
            示例 2:

            输入: num1 = "123", num2 = "456"
            输出: "56088"
            说明：

            num1 和 num2 的长度小于110。
            num1 和 num2 只包含数字 0-9。
            num1 和 num2 均不以零开头，除非是数字 0 本身。
            不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
            """)
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 == 1 && num1.charAt(0) == '0')
            return "0";
        if (len2 == 1 && num2.charAt(0) == '0')
            return "0";

        List<MyBigInteger> factors = new ArrayList<>(len2);


        if (len1 > len2) {
            MyBigInteger myBigInteger = new MyBigInteger(num1);

            for (int i = len2 - 1; i >= 0; i--) {
                int b = num2.charAt(i) - '0';
                factors.add(
                        myBigInteger.copy().multiply(b).multiply10(len2 - i - 1)
                );
            }

        } else {
            MyBigInteger myBigInteger = new MyBigInteger(num2);

            for (int i = len1 - 1; i >= 0; i--) {
                int b = num1.charAt(i) - '0';
                factors.add(
                        myBigInteger.copy().multiply(b).multiply10(len1 - i - 1)
                );
            }
        }

        LOGGER.info("factors = {}", factors);

        MyBigInteger ans = factors.get(0);
        for (int i = 1; i < factors.size(); i++) {
            ans.add(factors.get(i));
            LOGGER.info("ans = {}", ans);
        }

        return ans.toString();
    }

    static class MyBigInteger {
        byte[] data;
        int left;
        int right;

        public MyBigInteger() {
        }

        MyBigInteger(String number) {
            int length = number.length();

            right = 256;
            left = right - length + 1;
            data = new byte[512];

            for (int i = left; i <= right; i++) {
                data[i] = (byte) (number.charAt(i - left) - '0');
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(right - left + 1);
            for (int i = left; i <= right; i++) {
                sb.append(data[i]);
            }
            return sb.toString();
        }

        // n 0-9
        MyBigInteger multiply(int n) {
            if (n == 0) {
                left = right;
                Arrays.fill(data, (byte) 0);
            } else {
                byte carry = 0;
                for (int i = right; i >= left; i--) {
                    byte b = data[i];
                    byte mul = (byte) (b * n + carry);

                    if (mul >= 10) {
                        data[i] = (byte) (mul % 10);
                        carry = (byte) (mul / 10);
                    } else {
                        data[i] = mul;
                        carry = 0;
                    }
                }

                if (carry > 0) {
                    left--;
                    data[left] = carry;
                }
            }

            return this;
        }

        MyBigInteger multiply10() {
            if (left == right && data[left] == 0) {
            } else {
                right++;
                data[right] = 0;
            }

            return this;
        }

        MyBigInteger multiply10(int number) {
            if (left == right && data[left] == 0) {
            } else {
                right += number;
            }

            return this;
        }

        MyBigInteger add(MyBigInteger another) {
            int lenThis = length();
            int lenAno = another.length();

            int lenMax = Math.max(lenThis, lenAno);

            byte carry = 0;
            for (int i = 0; i < lenMax; i++) {
                byte a = this.data[this.right - i];
                byte b = another.data[another.right - i];

                byte sum = (byte) (a + b + carry);

                if (sum >= 10) {
                    this.data[this.right - i] = (byte) (sum - 10);
                    carry = 1;
                } else {
                    this.data[this.right - i] = sum;
                    carry = 0;
                }
            }

            this.left = this.right - lenMax + 1;

            if (carry > 0) {
                left--;
                data[left] = carry;
            }

            return this;
        }

        int length() {
            return right - left + 1;
        }

        MyBigInteger copy() {
            MyBigInteger ret = new MyBigInteger();
            ret.data = Arrays.copyOf(data, data.length);
            ret.left = left;
            ret.right = right;

            return ret;
        }
    }
}
