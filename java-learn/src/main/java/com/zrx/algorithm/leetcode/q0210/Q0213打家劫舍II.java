package com.zrx.algorithm.leetcode.q0210;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Description
 * 打家劫舍 II
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0213打家劫舍II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0213打家劫舍II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(2, 3, 2),
                ArrayFactory.create(1, 2, 3, 1),
                ArrayFactory.create(1, 3, 1, 3, 100)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                3, 4, 103
        );
    }

    @Code(info = """
            你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

            给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

            示例 1:

            输入: [2,3,2]
            输出: 3
            解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
            示例 2:

            输入: [1,2,3,1]
            输出: 4
            解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
                 偷窃到的最高金额 = 1 + 3 = 4 。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/house-robber-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int rob(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        switch (len) {
            case 0:
                return 0;
            case 1:
                return nums[0];
            case 2:
                return Math.max(nums[0], nums[1]);
            case 3:
                return Math.max(nums[0], Math.max(nums[1], nums[2]));
            default:
                int n0, n1, n2, ni, t;
                n0 = nums[0];
                n1 = nums[1];
                n2 = nums[2];

                int p11 = n0 + n2;
                int p10 = n0;
                int p01 = n2;
                int p00 = n1;

                int ans = Math.max(Math.max(p11, p10), Math.max(p01, p00));

                for (int i = 3; i < len - 1; i++) {
                    ni = nums[i];
                    t = p10;

                    p10 = Math.max(p11, p10);
                    p11 = t + ni;

                    t = p00;
                    p00 = Math.max(p01, p00);
                    p01 = t + ni;

                    ans = Math.max(ans, Math.max(Math.max(p11, p10), Math.max(p01, p00)));
                }

                ni = nums[len - 1];
                t = p00;
                p00 = Math.max(p01, p00);
                p01 = t + ni;

                ans = Math.max(ans, Math.max(p01, p00));

                return ans;
        }
    }
}
