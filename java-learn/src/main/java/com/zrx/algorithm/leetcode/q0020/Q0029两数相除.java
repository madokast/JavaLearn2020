package com.zrx.algorithm.leetcode.q0020;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0029两数相除
 * <p>
 * 好东西：
 * 1. 只用一种情况溢出
 * dividend == Integer.MIN_VALUE && divisor == -1
 * <p>
 * 2.判断商的符号
 * negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
 * <p>
 * 3.负数的范围较大，因此全部转为负数来计算
 *
 * <p>
 * Data
 * 2020/5/11-15:34
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0029两数相除 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0029两数相除.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                10, 3,
                7, -3,
                1, -1,
                2147483647, 2,
                -2147483648, 2,
                1100540749, -1090366779,
                2147483647, 1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(3, -2, -1, 2147483647 / 2, -2147483648 / 2, -1, 2147483647);
    }

    /**
     * 用了 long 不可以
     *
     *  public int divide(int dividend, int divisor) {
     *         if (dividend == 0) {
     *             return 0;
     *         }
     *         if (dividend == Integer.MIN_VALUE && divisor == -1) {
     *             return Integer.MAX_VALUE;
     *         }
     *         boolean negative;
     *         negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
     *         long t = Math.abs((long) dividend);
     *         long d= Math.abs((long) divisor);
     *         int result = 0;
     *         for (int i=31; i>=0;i--) {
     *             if ((t>>i)>=d) {//找出足够大的数2^n*divisor
     *                 result+=1<<i;//将结果加上2^n
     *                 t-=d<<i;//将被除数减去2^n*divisor
     *             }
     *         }
     *         return negative ? -result : result;//符号相异取反
     *     }
     */

    /**
     * class Solution {
     * public int divide(int dividend, int divisor) {
     * if (dividend == Integer.MIN_VALUE && divisor == -1) {
     * return Integer.MAX_VALUE;
     * }
     * if(dividend == 0 || divisor == 0) return 0;
     * int less = 0;//判断大于0的个数，用于判断商的符号
     * int t = divisor;
     * //int的范围为-2^32 ～ 2^32-1，负数的范围较大，因此全部转为负数来计算
     * if(dividend > 0){
     * less++;
     * dividend = -dividend;
     * }
     * if(divisor > 0){
     * less++;
     * divisor = -divisor;
     * }
     * //如果除数大于被除数，则直接返回0
     * if(dividend > divisor) return 0;
     * //递归获取商
     * int getcount = getcount(dividend, divisor);
     * //如果符号不同则返回负数
     * return  less == 1 ? -getcount:getcount;
     * }
     * <p>
     * int getcount(int count,int one){
     * int d =one,sum = 1;
     * //结束条件，判断当前的商小于或者等于1的情况
     * if(count - d > d){
     * //如果是3除以4 则返回0
     * if(count - d > 0) return 0;
     * //如果是5除以4 则返回1
     * return 1;
     * }
     * //递归获取值
     * for(int i = 0 ; i < 32 ; i++){
     * //指数增大除数
     * d = d << 1;
     * //相减
     * int temp = count - d;
     * sum = sum << 1;
     * //除数指数增大，直到大于被除数
     * if(count - d > d){
     * //继续递归相减后的值，当我们的temp/one的值小于等于1时递归结束
     * sum += getcount(temp,one);
     * break;
     * }
     * }
     * return sum;
     * }
     * }
     */


    @Code(info = """
            给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

            返回被除数 dividend 除以除数 divisor 得到的商。

            整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

             

            示例 1:

            输入: dividend = 10, divisor = 3
            输出: 3
            解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
            示例 2:

            输入: dividend = 7, divisor = -3
            输出: -2
            解释: 7/-3 = truncate(-2.33333..) = -2
             

            提示：

            被除数和除数均为 32 位有符号整数。
            除数不为 0。
            假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
            """)
    public int divide(int dividend, int divisor) {
        if (true)// 高级方法
            return div(dividend, divisor);

        if (dividend == 0)
            return 0;

        if (divisor == 1)
            return dividend;

        if (dividend == MIN || divisor == MIN)
            return divideSpecial(dividend, divisor);


        int sig = (dividend < 0 ^ divisor > 0) ? 1 : -1;
        LOGGER.info("sig = {}", sig);

        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;

        int half = dividend >> 1;

        int r = (half << 1) == dividend ? 0 : 1;

        int[] ints = divideWithRemain(half, divisor);

        int ret = ints[0] << 1;

        ret += divideWithRemain((ints[1] << 1) + r, divisor)[0];

        return ret * sig;
    }

    private final int MIN = Integer.MIN_VALUE;
    private final int HALF = 0x40000000;

    private int divideSpecial(int dividend, int divisor) {

        if (divisor == MIN) {
            return dividend == MIN ? 1 : 0;
        }

        // divisor!=MIN
        // dividend == MIN

        if (divisor == -1) {
            // 溢出
            return Integer.MAX_VALUE;
        }

//        if (divisor == 1)
//            return dividend;

        int sig = divisor >= 0 ? -1 : 1;

        divisor = divisor < 0 ? -divisor : divisor;
        dividend = HALF;


        int[] ints = divideWithRemain(dividend, divisor);

        int ret = (ints[0] << 1);
        int remain = ints[1];

        ret += divideWithRemain(remain << 1, divisor)[0];

        return ret * sig;
    }

    private int[] divideWithRemain(int dividend, int divisor) {
        if (divisor == 2) {
            int ret = dividend >> 1;
            return new int[]{ret, ret << 1 == dividend ? 0 : 1};
        }

        int ret = 0;

        int temp = dividend;

        if ((divisor << 1) < 0) {
            int r = dividend - divisor;
            if (r < 0)
                return new int[]{0, dividend};
            else {
                return new int[]{1, r};
            }
        }

        while (dividend >= divisor) {
            int d = divisor;
            int r = 1;
            while (dividend >= d) {
                d <<= 1;
                r <<= 1;
            }

//            LOGGER.info("r = {}", r);
//            LOGGER.info("d = {}", d);

            ret += (r >> 1);
            dividend -= (d >> 1);
        }

        LOGGER.info("{}/{}={}..{}", temp, divisor, ret, dividend);

        return new int[]{ret, dividend};
    }

    public int div(int dividend, int divisor) { // divisor 已经判断不为零
        // 只有一种情况溢出
        if (dividend == 0x80000000 && divisor == -1)
            return 0x7fffffff;

        // 判断符号，即一正一负时结果为负
        // int sign = (dividend ^ divisor) < 0 ? -1 : 1;

        // 全部转为负数，因为负数范围广一些
        // 同时判断符号
        int sign = 1;  // 符号，默认是正数

        if (dividend > 0) {
            dividend = -dividend;
            sign = -sign;
        }

        if (divisor > 0) {
            divisor = -divisor;
            sign = -sign;
        }

        // 以上两个括号都进入，说明两者都是正数，所以符号不变还是 1
        // 只进入一个，说明两者一正一负，符号变化

        // 下面对进行除法，核心是 dividend > (divisor<<n)

        // 因为 divisor 左移位可能会溢出，需要先处理
        // 当一个负数，以 10- 开头时，左移会发生溢出
//        if ((divisor & 0x40000000) == 0)
//            return dividend > divisor ? 0 : sign;

        if (dividend > divisor)
            return 0;

        int answer = 0;
        while (dividend <= divisor) {
            int times = 1;
            int d = divisor;

            // 1 比 -1 更容易溢出
            while (dividend < d) {
                if ((d << 1) >= 0 || (times << 1) <= 0)
                    break;

                d <<= 1;
                times <<= 1;
            }

            if (dividend <= d) {
                answer += times;
                dividend -= d;
            } else {
                answer += times >> 1;
                dividend -= d >> 1;
            }


        }

        return answer * sign;

    }
}
