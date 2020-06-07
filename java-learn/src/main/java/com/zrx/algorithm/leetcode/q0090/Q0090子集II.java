package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * 子集 II
 * <p>
 * Data
 * 2020/6/6-16:25
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0090子集II implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0090子集II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(1,2,2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        RepeatableSet.of(2),
                        RepeatableSet.of(1),
                        RepeatableSet.of(1, 2, 2),
                        RepeatableSet.of(2, 2),
                        RepeatableSet.of(1, 2),
                        RepeatableSet.of()
                )
        );
    }

    @Code(info = """
            给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

            说明：解集不能包含重复的子集。

            示例:

            输入: [1,2,2]
            输出:
            [
              [2],
              [1],
              [1,2,2],
              [2,2],
              [1,2],
              []
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/subsets-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 我觉得就是深度优先搜索

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();


        back(new LinkedList<>(), nums, 0, ans);


        return ans;
    }

    private void back(Deque<Integer> stack, int[] nums, int start, List<List<Integer>> ans) {
        ans.add((new ArrayList<>(stack)));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            stack.addLast(nums[i]);
            back(stack, nums, i + 1, ans);
            stack.removeLast();
        }
    }
}
