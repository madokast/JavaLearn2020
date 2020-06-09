package com.zrx.algorithm.leetcode.q0100;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.hibernate.validator.constraints.CodePointLength;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.zip.Inflater;

/**
 * Description
 * 二叉树的层序遍历
 * <p>
 * Data
 * 2020/6/8-22:15
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0102二叉树的层序遍历 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0102二叉树的层序遍历.class);

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
                        List.of(3),
                        List.of(9, 20),
                        List.of(15, 7)
                )
        );
    }

    @Code(info = """
            给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

             

            示例：
            二叉树：[3,9,20,null,null,15,7],

                3
               / \\
              9  20
                /  \\
               15   7
            返回其层次遍历结果：

            [
              [3],
              [9,20],
              [15,7]
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return Collections.emptyList();
        List<List<Integer>> ret = new LinkedList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()){
            List<Integer> layer = new LinkedList<>();
            Deque<TreeNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode first = queue.removeFirst();
                layer.add(first.val);
                if(first.left!=null) nextQueue.addLast(first.left);
                if(first.right!=null) nextQueue.addLast(first.right);
            }
            ret.add(layer);
            queue = nextQueue;
        }

        return ret;
    }

}
