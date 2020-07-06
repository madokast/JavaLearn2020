package com.zrx.algorithm.leetcode.q0170;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0179最大数
 * <p>
 * Data
 * 2020/7/6-9:22
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0179最大数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0179最大数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create();
    }

    @Code(info = """
            给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

            示例 1:

            输入: [10,2]
            输出: 210
            示例 2:

            输入: [3,30,34,5,9]
            输出: 9534330
            说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/largest-number
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String largestNumber(int[] nums) {
        return null;
    }
}
