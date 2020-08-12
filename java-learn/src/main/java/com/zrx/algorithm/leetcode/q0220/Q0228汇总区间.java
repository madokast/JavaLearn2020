package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 汇总区间
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0228汇总区间 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0228汇总区间.class);

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
            给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。

            示例 1:

            输入: [0,1,2,4,5,7]
            输出: ["0->2","4->5","7"]
            解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
            示例 2:

            输入: [0,2,3,4,6,8,9]
            输出: ["0","2->4","6","8->9"]
            解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/summary-ranges
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> summaryRanges(int[] nums) {
return null;
    }
}
