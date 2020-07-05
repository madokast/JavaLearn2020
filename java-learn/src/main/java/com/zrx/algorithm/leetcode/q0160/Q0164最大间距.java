package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Description
 * 最大间距
 * <p>
 * Data
 * 2020/7/4-22:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0164最大间距 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0164最大间距.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(3, 6, 9, 1),
                ArrayFactory.create(10),
                ArrayFactory.create(1, 10000000)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(3, 0, 10000000 - 1);
    }

    @Code(info = """
            给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

            如果数组元素个数小于 2，则返回 0。

            示例 1:

            输入: [3,6,9,1]
            输出: 3
            解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
            示例 2:

            输入: [10]
            输出: 0
            解释: 数组元素个数小于 2，因此返回 0。
            说明:

            你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
            请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
            通过次数15,886提交次数28,759

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/maximum-gap
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maximumGap(int[] nums) {
        int length = nums.length;
        if (length < 2) return 0;


        double max = Arrays.stream(nums).max().getAsInt();
        double min = Arrays.stream(nums).min().getAsInt();

        int size = (int) Math.ceil((max - min) / (length - 1));

        int num = (int) Math.ceil((max - min) / size);

        int[] maxBox = new int[num + 1];
        Arrays.fill(maxBox, Integer.MIN_VALUE);
        int[] minBox = new int[num + 1];
        Arrays.fill(minBox, Integer.MAX_VALUE);

        for (int n : nums) {
            int index = (int) Math.ceil((n - min) / size);
            maxBox[index] = Math.max(maxBox[index], n);
            minBox[index] = Math.min(minBox[index], n);
        }

        LOGGER.info("minBox = {}", minBox);
        LOGGER.info("maxBox = {}", maxBox);

        int ans = 0;
        for (int i = 0; i < num ; i++) {
            int preMax = maxBox[i];
            while (preMax == Integer.MIN_VALUE) {
                i++;
                preMax = maxBox[i];
            }
            int next = 1;
            if(i+next>num) break;
            int curMin = minBox[i + next];
            while (curMin == Integer.MAX_VALUE) {
                next++;
                if(i+next>num) break;
                curMin = minBox[i + next];
            }

            ans = Math.max(ans, curMin - preMax);
        }

        return ans;
    }
}
