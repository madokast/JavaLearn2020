package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * Data
 * 2020/5/13-17:46
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0034在排序数组中查找元素的第一个和最后一个位置 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0034在排序数组中查找元素的第一个和最后一个位置.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;

    }


    @Code(info = """
            给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

            你的算法时间复杂度必须是 O(log n) 级别。

            如果数组中不存在目标值，返回 [-1, -1]。

            示例 1:

            输入: nums = [5,7,7,8,8,10], target = 8
            输出: [3,4]
            示例 2:

            输入: nums = [5,7,7,8,8,10], target = 6
            输出: [-1,-1]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[] searchRange(int[] nums, int target) {
        // todo
        return null;
    }
}
