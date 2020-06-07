package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 子集
 * <p>
 * Data
 * 2020/5/31-13:51
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0078子集 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0078子集.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(1, 2, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        RepeatableSet.of(),
                        RepeatableSet.of(1),
                        RepeatableSet.of(2),
                        RepeatableSet.of(3),
                        RepeatableSet.of(1, 2),
                        RepeatableSet.of(1, 3),
                        RepeatableSet.of(2, 3),
                        RepeatableSet.of(1, 2, 3)
                )
        );
    }

    @Code(info = """
            给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

            说明：解集不能包含重复的子集。

            示例:

            输入: nums = [1,2,3]
            输出:
            [
              [3],
              [1],
              [2],
              [1,2,3],
              [1,3],
              [2,3],
              [1,2],
              []
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/subsets
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        int num = 1 << length;

        List<List<Integer>> answers = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            int t = i;
            List<Integer> answer = new ArrayList<>(length);


            for (int value : nums) {
                if ((t & 1) == 1) {
                    answer.add(value);
                }
                t = t >> 1;
            }

            answers.add(answer);

        }

        return answers;
    }
}
