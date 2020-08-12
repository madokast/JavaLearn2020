package com.zrx.algorithm.leetcode.q0210;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 组合总和 III
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0216组合总和III implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0216组合总和III.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                3, 7,
                3, 9,
                2, 18
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        RepeatableSet.of(1, 2, 4)
                ), RepeatableSet.of(
                        RepeatableSet.of(1, 2, 6),
                        RepeatableSet.of(1, 3, 5),
                        RepeatableSet.of(2, 3, 4)
                ), RepeatableSet.of()
        );
    }

    @Code(info = """
            找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

            说明：

            所有数字都是正整数。
            解集不能包含重复的组合。 
            示例 1:

            输入: k = 3, n = 7
            输出: [[1,2,4]]
            示例 2:

            输入: k = 3, n = 9
            输出: [[1,2,6], [1,3,5], [2,3,4]]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/combination-sum-iii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dps(ans, new LinkedList<Integer>(), 0, n, k);
        return ans;
    }

    void dps(List<List<Integer>> ans, Deque<Integer> stack, int curSum, int n, int k) {
        if (curSum == n && stack.size() == k) {
            ArrayList<Integer> e = new ArrayList<>(stack);
            Collections.reverse(e);
            ans.add(e);
        } else if (stack.size() < k) {
            int last = n - curSum;
            Integer peek = stack.isEmpty() ? 0 : stack.peek();
            for (int i = peek + 1; i <= Math.min(last, 9); i++) {
                stack.push(i);
                dps(ans, stack, curSum + i, n, k);
                stack.pop();
            }
        }
    }
}
