package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Q0039组合总和
 * 解出来了，但是速度太慢
 * <p>
 * Data
 * 2020/5/19-23:46
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0039组合总和 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0039组合总和.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(2, 3, 6, 7), 7,
                ArrayFactory.create(2, 3, 5), 8
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        List.of(7),
                        List.of(2, 2, 3)
                ),
                RepeatableSet.of(
                        RepeatableSet.of(2, 2, 2, 2),
                        RepeatableSet.of(2, 3, 3),
                        RepeatableSet.of(3, 5)
                )
        );
    }

    @Code(info = """
            给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

            candidates 中的数字可以无限制重复被选取。

            说明：

            所有数字（包括 target）都是正整数。
            解集不能包含重复的组合。 
            示例 1:

            输入: candidates = [2,3,6,7], target = 7,
            所求解集为:
            [
              [7],
              [2,2,3]
            ]
            示例 2:

            输入: candidates = [2,3,5], target = 8,
            所求解集为:
            [
              [2,2,2,2],
              [2,3,3],
              [3,5]
            ]
            """)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(new ArrayList<>(), 0, candidates, target, ans);

        return ans;
    }

    // 速度慢
    private void solve(List<Integer> cur, int sum, int[] candidates, int target, List<List<Integer>> ans) {
        for (int candidate : candidates) {
            int newSum = sum + candidate;

            if (newSum == target) {
                ArrayList<Integer> copy = new ArrayList<>(cur);
                copy.add(candidate);

                copy.sort(Integer::compareTo);

                if(!ans.contains(copy))
                    ans.add(copy);
            } else if (newSum < target) {
                ArrayList<Integer> copy = new ArrayList<>(cur);
                copy.add(candidate);

                solve(copy, newSum, candidates, target, ans);
            }
        }

    }
}
