package com.zrx.algorithm.leetcode.q0110;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 路径总和 II
 * <p>
 * Data
 * 2020/6/9-19:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0113路径总和II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0113路径总和II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        List.of(5, 4, 11, 2),
                        List.of(5, 8, 4, 5)
                )
        );
    }

    @Code(info = """
            给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

            说明: 叶子节点是指没有子节点的节点。

            示例:
            给定如下二叉树，以及目标和 sum = 22，

                          5
                         / \\
                        4   8
                       /   / \\
                      11  13  4
                     /  \\    / \\
                    7    2  5   1
            返回:

            [
               [5,4,11,2],
               [5,8,4,5]
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/path-sum-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(root.val);
        back(root, sum, root.val, stack, ans);

        return ans;
    }

    private void back(TreeNode root, int sum, int curSum, Deque<Integer> stack, List<List<Integer>> ans) {
        if (curSum == sum && (root.left == null && root.right == null)) {
            ArrayList<Integer> t = new ArrayList<>(stack);
            Collections.reverse(t);
            ans.add(t);
        }
        else {
            TreeNode left = root.left;
            TreeNode right = root.right;

            if (left != null) {
                stack.push(left.val);
                back(left, sum, curSum + left.val, stack, ans);
                stack.pop();
            }

            if (right != null) {
                stack.push(right.val);
                back(right, sum, curSum + right.val, stack, ans);
                stack.pop();
            }
        }
    }
}
