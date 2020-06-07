package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * x 的平方根
 * <p>
 * Data
 * 2020/5/28-14:00
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0069x的平方根 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0069x的平方根.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1, 4, 8, 2147395599);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2, 2, (int) (Math.sqrt(2147395599)));
    }

    @Code(info = """
            实现 int sqrt(int x) 函数。

            计算并返回 x 的平方根，其中 x 是非负整数。

            由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

            示例 1:

            输入: 4
            输出: 2
            示例 2:

            输入: 8
            输出: 2
            说明: 8 的平方根是 2.82842...,
                 由于返回类型是整数，小数部分将被舍去。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/sqrtx
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int mySqrt(int x) {
        if(x==0) return 0;

        int left = 1;
        int right = x;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            LOGGER.info("mid = {}", mid);
//            int mid2 = mid * mid;
            int r = x / mid;
            LOGGER.info("r = {}", r);
            if (r < mid) {
                right = mid - 1;
            } else if (r > mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return Math.min(right, left);
    }
}
