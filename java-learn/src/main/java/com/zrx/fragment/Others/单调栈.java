package com.zrx.fragment.Others;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Description
 * 单调栈
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class 单调栈 {
    private final static Logger LOGGER = LoggerFactory.getLogger(单调栈.class);

    /**
     * 默认单调栈
     * 栈内元素从小到大排序
     *
     * @param nums 数组
     * @return 单调栈 pop
     */
    public int[] index(int[] nums) {
        int length = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(length);
        List<Integer> ret = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            int num = nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] > num) {
                ret.add(stack.pop());
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            ret.add(stack.pop());
        }

        return ret.stream().mapToInt(Integer::intValue).toArray();
    }

}
