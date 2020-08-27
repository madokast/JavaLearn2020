package com.zrx.algorithm.leetcode.q0250;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * Description
 *
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0257二叉树的所有路径 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0257二叉树的所有路径.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                TreeNode.of(1, 2, 3, null, 5)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        "1->2->5", "1->3"
                )
        );
    }

    @Code(info = """
            给定一个二叉树，返回所有从根节点到叶子节点的路径。

            说明: 叶子节点是指没有子节点的节点。

            示例:

            输入:

               1
             /   \\
            2     3
             \\
              5

            输出: ["1->2->5", "1->3"]

            解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/binary-tree-paths
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        dps(root, stack, ans);

        return ans.stream().map(path -> path.stream().map(String::valueOf).collect(Collectors.joining("->")))
                .collect(Collectors.toList());
    }

    private void dps(TreeNode node, Deque<TreeNode> stack, List<List<Integer>> ans) {
        List<TreeNode> path = new ArrayList<>(2);
        if (node.left != null) path.add(node.left);
        if (node.right != null) path.add(node.right);

        if (path.isEmpty()) {
            List<Integer> collect = stack.stream().map(t -> t.val).collect(Collectors.toList());
            Collections.reverse(collect);
            ans.add(collect);
        } else {
            for (TreeNode n : path) {
                stack.push(n);
                dps(n, stack, ans);
                stack.pop();
            }
        }
    }
}
