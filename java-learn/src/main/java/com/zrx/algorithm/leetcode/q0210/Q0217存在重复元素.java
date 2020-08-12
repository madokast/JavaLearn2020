package com.zrx.algorithm.leetcode.q0210;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description
 * 存在重复元素
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0217存在重复元素 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0217存在重复元素.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(1, 2, 3, 1),
                ArrayFactory.create(1, 2, 3, 4),
                ArrayFactory.create(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, false, true
        );
    }

    @Code(info = """
            给定一个整数数组，判断是否存在重复元素。

            如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

             

            示例 1:

            输入: [1,2,3,1]
            输出: true
            示例 2:

            输入: [1,2,3,4]
            输出: false
            示例 3:

            输入: [1,1,1,3,3,4,3,2,4,2]
            输出: true

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/contains-duplicate
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }
}
