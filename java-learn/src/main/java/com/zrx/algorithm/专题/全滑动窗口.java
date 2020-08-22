package com.zrx.algorithm.专题;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 全滑动窗口
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

@Component
public class 全滑动窗口 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(全滑动窗口.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(4, 1, 2, 2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                (Object) ArrayFactory.create(4, 2, 1, 1)
        );
    }

    @Code(group = "专题", number = 3, info = """
            全滑动窗口
            给定一个长度为n数组arr1，要求返回一个同长度的数组arr2
            满足 arr2[i] = "长度为i+1的滑动窗口在数组arr1上时，窗口内元素最小值的最大值"
            比如输入  4 1 2 2
            返回 4 2 1 1
            """)
    public int[] solve(int[] nums) {
        int length = nums.length;

        int[] ret = new int[length];
        Arrays.fill(ret, Integer.MIN_VALUE);

        int[] minLength = minLength(nums);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        ret[0] = max;
        ret[length - 1] = min;

        for (int i = 0; i < minLength.length; i++) {
            int winLen = minLength[i];
            int num = nums[i];
            ret[winLen - 1] = Math.max(ret[winLen - 1], num);
        }

        for (int i = 0; i < ret.length; i++) {
            if (ret[i] == Integer.MIN_VALUE) {
                int j = i + 1;
                while (ret[j] == Integer.MIN_VALUE) j++;
                Arrays.fill(ret, i, j, ret[j]);
                i = j;
            }
        }

        return ret;
    }

    /**
     * 正单调栈，最小元素
     * 4122
     * 1422
     *
     * @param nums 数组
     * @return minLength[i]，表示包含i的nums的子数组的最大长度，且这个子数组中，nums[i]最小
     */
    public int[] minLength(int[] nums) {
        int length = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(length);

        int[] ret = new int[length];

        for (int i = 0; i < length; i++) {
            int num = nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] > num) {
                int pop = stack.pop();
                if (stack.isEmpty()) {
                    ret[pop] = i - (-1) - 1;
                } else {
                    int left = stack.peek();
                    ret[pop] = i - left - 1;
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (stack.isEmpty()) {
                ret[pop] = length - (-1) - 1;
            } else {
                int left = stack.peek();
                ret[pop] = length - left - 1;
            }
        }


        return ret;
    }
}
