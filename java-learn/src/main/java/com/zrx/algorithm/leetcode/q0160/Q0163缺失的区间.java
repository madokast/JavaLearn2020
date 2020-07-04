package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        return InputFactory.create(1);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create();
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
        return null;
    }
}
