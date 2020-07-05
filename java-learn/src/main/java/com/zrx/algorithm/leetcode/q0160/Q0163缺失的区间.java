package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 缺失的区间
 * <p>
 * Data
 * 2020/7/4-22:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0163缺失的区间 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0163缺失的区间.class);

    @Override
    public List<Input> getInputs() {
        //[-2147483648,2147483647]
        //-2147483648
        //2147483647
        return InputFactory.create(
                3,
                ArrayFactory.create(0, 1, 3, 50, 75), 0, 99,
                ArrayFactory.create(-2147483648, 2147483647), -2147483648, 2147483647
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of("2", "4->49", "51->74", "76->99"),
                List.of("-2147483647->2147483646")
        );
    }

    @Code(info = """
            给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。

            示例：

            输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
            输出: ["2", "4->49", "51->74", "76->99"]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/missing-ranges
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int length = nums.length;
        if (length == 0) {
            if (lower == upper) return List.of(String.valueOf(lower));
            else return List.of(lower + "->" + upper);
        }

        List<String> answer = new ArrayList<>();

        int first = nums[0];
        if (lower == first) {
            ;
        } else if(lower == first - 1) {
            answer.add(String.valueOf(lower));
        } else if (lower < first - 1) {
            answer.add(lower + "->" + (first - 1));
        }

        LOGGER.info("answer = {}", answer);

        for (int i = 1; i < length; i++) {
            int num = nums[i];
            int pre = nums[i - 1];
            if(num==pre) continue;

            if (pre == num - 2) {
                answer.add(String.valueOf(pre + 1));
            } else if (pre < num - 2) {
                answer.add((pre + 1) + "->" + (num - 1));
            }
        }

        LOGGER.info("answer = {}", answer);

        int last = nums[length - 1];
        if (last == upper - 1) {
            answer.add(String.valueOf(upper));
        } else if (last < upper - 1) {
            answer.add((last + 1) + "->" + upper);
        }


        LOGGER.info("answer = {}", answer);


        return answer;
    }
}
