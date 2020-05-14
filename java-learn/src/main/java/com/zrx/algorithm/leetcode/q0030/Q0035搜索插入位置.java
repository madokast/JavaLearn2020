package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 搜索插入位置
 * <p>
 * Data
 * 2020/5/13-17:47
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0035搜索插入位置 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0035搜索插入位置.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

            你可以假设数组中无重复元素。

            示例 1:

            输入: [1,3,5,6], 5
            输出: 2
            示例 2:

            输入: [1,3,5,6], 2
            输出: 1
            示例 3:

            输入: [1,3,5,6], 7
            输出: 4
            示例 4:

            输入: [1,3,5,6], 0
            输出: 0

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/search-insert-position
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int searchInsert(int[] nums, int target) {
        // todo

        return 0;
    }
}
