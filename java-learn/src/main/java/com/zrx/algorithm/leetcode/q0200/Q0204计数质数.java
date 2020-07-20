package com.zrx.algorithm.leetcode.q0200;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            统计所有小于非负整数 n 的质数的数量。

            示例:

            输入: 10
            输出: 4
            解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
            """)
    public int countPrimes(int n) {
return -1;
    }
}
