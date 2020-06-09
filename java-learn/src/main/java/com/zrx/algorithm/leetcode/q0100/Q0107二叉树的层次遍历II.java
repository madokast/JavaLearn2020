package com.zrx.algorithm.leetcode.q0100;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 二叉树的层次遍历 II
 * <p>
 * Data
 * 2020/6/8-22:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0107二叉树的层次遍历II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0107二叉树的层次遍历II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                TreeNode.of(3, 9, 20, null, null, 15, 7)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of(
                        List.of(15, 7),
                        List.of(9, 20),
                        List.of(3)
                )
        );
    }


    @Code(info = """
            给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

            例如：
            给定二叉树 [3,9,20,null,null,15,7],

                3
               / \\
              9  20
                /  \\
               15   7
            返回其自底向上的层次遍历为：

            [
              [15,7],
              [9,20],
              [3]
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> ret = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            List<Integer> layer = new LinkedList<>();
            Deque<TreeNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode first = queue.removeFirst();
                layer.add(first.val);
                if (first.left != null) nextQueue.addLast(first.left);
                if (first.right != null) nextQueue.addLast(first.right);
            }
            ret.add(layer);
            queue = nextQueue;
        }

        Collections.reverse(ret);

        return ret;
    }
}
