package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 打家劫舍
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0198打家劫舍 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0198打家劫舍.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(1, 2, 3, 1),
                ArrayFactory.create(2, 7, 9, 3, 1),
                ArrayFactory.create(2, 1, 1, 2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                4, 12, 4
        );
    }

    @Code(info = """
            你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

            给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

             

            示例 1：

            输入：[1,2,3,1]
            输出：4
            解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
                 偷窃到的最高金额 = 1 + 3 = 4 。
            示例 2：

            输入：[2,7,9,3,1]
            输出：12
            解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
                 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
             

            提示：

            0 <= nums.length <= 100
            0 <= nums[i] <= 400

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/house-robber
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int rob(int[] nums) {
        int cur = 0;
        int not = 0;

        for (int num : nums) {
            int oldMax = Math.max(not, cur);
            cur = not + num;
            not = oldMax;
        }


        return Math.max(cur, not);
    }
}
