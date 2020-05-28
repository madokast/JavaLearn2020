package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 最大子序和
 * <p>
 * Data
 * 2020/5/26-15:55
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0053最大子序和 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0053最大子序和.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(-2,1,-3,4,-1,2,1,-5,4)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(6);
    }

    @Code(info = """
            给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

            示例:

            输入: [-2,1,-3,4,-1,2,1,-5,4],
            输出: 6
            解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
            进阶:

            如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/maximum-subarray
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maxSubArray(int[] nums) {

        int globeMax = Integer.MIN_VALUE;
        int currentMax = 0;

        for (int num : nums) {
            currentMax+=num;

            if(currentMax<0)
                currentMax=0;
            else if(currentMax>globeMax)
                globeMax = currentMax;
        }


        return globeMax;
    }
}
