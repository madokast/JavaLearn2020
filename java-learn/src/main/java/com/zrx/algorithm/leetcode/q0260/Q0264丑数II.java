package com.zrx.algorithm.leetcode.q0260;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 丑数 II
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0264丑数II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0264丑数II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, 10
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                12
        );
    }

    @Code(info = """
            编写一个程序，找出第 n 个丑数。

            丑数就是质因数只包含 2, 3, 5 的正整数。

            示例:

            输入: n = 10
            输出: 12
            解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
            说明:  

            1 是丑数。
            n 不超过1690。
            通过次数32,039提交次

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/ugly-number-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>(n);
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = list.get(i2) * 2;
            int n3 = list.get(i3) * 3;
            int n5 = list.get(i5) * 5;

            int min = Math.min(
                    n2,
                    Math.min(
                            n3,
                            n5
                    )
            );

            list.add(min);

            if(min==n2) i2++;
            if(min==n3) i3++;
            if(min==n5) i5++;
        }

        return list.get(n - 1);
    }
}
