package com.zrx.algorithm.leetcode.q0200;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 计数质数
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0204计数质数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0204计数质数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, 10
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                4
        );
    }

    @Code(info = """
            统计所有小于非负整数 n 的质数的数量。

            示例:

            输入: 10
            输出: 4
            解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
            """)
    public int countPrimes垃圾算法(int n) {
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (isP(i)) {
                pList.add(i);
                c++;
            }
            ;
        }

        return c;
    }

    List<Integer> pList = new ArrayList<>(256);

    private boolean isP(int n) {
        if (n == 2) return true;

        int sqrt = (int) Math.ceil(Math.sqrt(n));

        for (Integer i : pList) {
            if(i>sqrt) break;
            if (n % i == 0) return false;
        }

        return true;
    }
}
