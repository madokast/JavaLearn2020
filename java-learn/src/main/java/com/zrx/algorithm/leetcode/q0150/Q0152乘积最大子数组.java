package com.zrx.algorithm.leetcode.q0150;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 乘积最大子数组
 * <p>
 * Data
 * 2020/7/2-21:59
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0152乘积最大子数组 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0152乘积最大子数组.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(2, 3, -2, 4),
                ArrayFactory.create(-2, 0, -1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                6, 0
        );
    }

    @Code(info = """
            给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

             

            示例 1:

            输入: [2,3,-2,4]
            输出: 6
            解释: 子数组 [2,3] 有最大乘积 6。
            示例 2:

            输入: [-2,0,-1]
            输出: 0
            解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/maximum-product-subarray
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maxProduct(int[] nums) {
        int globalMax = 0;
        int currentMax = 0;
        int currentMin = 0;
        int preCurrentMax;
        int max = nums[0];

        for (int num : nums) {
            if (num > 0) {
                if (currentMax == 0) currentMax = num;
                else currentMax *= num;
                if (currentMin != 0) currentMin *= num;
            } else if (num < 0) {
                preCurrentMax = currentMax;
                currentMax = currentMin * num;
                currentMin = preCurrentMax == 0 ? num : preCurrentMax * num;
            } else {
                currentMax = 0;
                currentMin = 0;
            }
            globalMax = Math.max(globalMax, currentMax);
            max = Math.max(num, max);
        }

        return globalMax == 0 ? max : globalMax;
    }
}
