package com.zrx.algorithm.leetcode.q0100;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * Q0103二叉树的锯齿形层次遍历
 * <p>
 * Data
 * 2020/6/8-22:16
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0103二叉树的锯齿形层次遍历 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0103二叉树的锯齿形层次遍历.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                TreeNode.of(3, 9, 20, null, null, 15, 7),
                TreeNode.of(1, 2, 3, 4, null, null, 5)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        //[[1],[3,2],[4,5]]

        return AnswerFactory.create(
                List.of(
                        List.of(3),
                        List.of(20, 9),
                        List.of(15, 7)
                ),
                List.of(
                        List.of(1),
                        List.of(3, 2),
                        List.of(4, 5)
                )
        );

    }

    @Code(info = """
            给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

            例如：
            给定二叉树 [3,9,20,null,null,15,7],

                3
               / \\
              9  20
                /  \\
               15   7
            返回锯齿形层次遍历如下：

            [
              [3],
              [20,9],
              [15,7]
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> ret = new LinkedList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        boolean order = false;

        while (!queue.isEmpty()) {
            List<Integer> layer = new LinkedList<>();
            Deque<TreeNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode first = null;
                if (order) {
                    first = queue.removeFirst();
                } else {
                    first = queue.removeLast();
                }
                layer.add(first.val);
                if (order) {
                    if (first.right != null) nextQueue.addLast(first.right);
                    if (first.left != null) nextQueue.addLast(first.left);
                } else {
                    if (first.left != null) nextQueue.addFirst(first.left);
                    if (first.right != null) nextQueue.addFirst(first.right);
                }
            }
            order = !order;
            ret.add(layer);
            queue = nextQueue;
        }

        return ret;
    }
}
