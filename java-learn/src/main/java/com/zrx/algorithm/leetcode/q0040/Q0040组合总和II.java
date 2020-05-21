package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * Q0040组合总和II
 * <p>
 * Data
 * 2020/5/20-17:27
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0040组合总和II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0040组合总和II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(10, 1, 2, 7, 6, 1, 5), 8,
                ArrayFactory.create(2, 5, 2, 1, 2), 5,
                ArrayFactory.create(2, 1), 4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        RepeatableSet.of(1, 7),
                        RepeatableSet.of(1, 2, 5),
                        RepeatableSet.of(2, 6),
                        RepeatableSet.of(1, 1, 6)
                ),
                RepeatableSet.of(
                        RepeatableSet.of(1, 2, 2),
                        RepeatableSet.of(5)
                ),
                RepeatableSet.of()
        );
    }

    @Code(info = """
            给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

            candidates 中的每个数字在每个组合中只能使用一次。

            说明：

            所有数字（包括目标数）都是正整数。
            解集不能包含重复的组合。 
            示例 1:

            输入: candidates = [10,1,2,7,6,1,5], target = 8,
            所求解集为:
            [
              [1, 7],
              [1, 2, 5],
              [2, 6],
              [1, 1, 6]
            ]
            示例 2:

            输入: candidates = [2,5,2,1,2], target = 5,
            所求解集为:
            [
              [1,2,2],
              [5]
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/combination-sum-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    // 这估计是最典型的回溯问题
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Set<List<Integer>> answer = new HashSet<>();

        solve(candidates, target, 0, answer, new ArrayDeque<>(candidates.length), 0);

        return new ArrayList<>(answer);
    }

    private void solve(int[] candidates, int target, int sum, Set<List<Integer>> answer, Deque<Integer> trace, int start) {
        //LOGGER.info("sum = {}, start = {}", sum, start);
        if (sum == target) {
            ArrayList<Integer> t = new ArrayList<>(trace);
            t.sort(Integer::compareTo);
            answer.add(t);
        } else if (sum < target) {
            for (int i = start; i < candidates.length; i++) {
                int candidate = candidates[i];
                trace.addLast(candidate);
                solve(candidates, target, sum + candidate, answer, trace, i + 1);
                trace.removeLast();
            }
        }
    }
}
