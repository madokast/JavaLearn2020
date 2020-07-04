package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 寻找峰值
 * <p>
 * Data
 * 2020/7/4-22:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0162寻找峰值 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0162寻找峰值.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create();
    }

    @Code(info = """
            峰值元素是指其值大于左右相邻值的元素。

            给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

            数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

            你可以假设 nums[-1] = nums[n] = -∞。

            示例 1:

            输入: nums = [1,2,3,1]
            输出: 2
            解释: 3 是峰值元素，你的函数应该返回其索引 2。
            示例 2:

            输入: nums = [1,2,1,3,5,6,4]
            输出: 1 或 5\040
            解释: 你的函数可以返回索引 1，其峰值元素为 2；
                 或者返回索引 5， 其峰值元素为 6。
            说明:

            你的解法应该是 O(logN) 时间复杂度的。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/find-peak-element
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int findPeakElement(int[] nums) {
        return 1;
    }
}
