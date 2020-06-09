package com.zrx.algorithm.leetcode.q0100;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

/**
 * Description
 * 对称二叉树
 * <p>
 * Data
 * 2020/6/8-22:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0101对称二叉树 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0101对称二叉树.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                TreeNode.of(1, 2, 2, 3, 4, 4, 3),
                TreeNode.of(1, 2, 2, null, 3, null, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, false
        );
    }

    @Code(info = """
            给定一个二叉树，检查它是否是镜像对称的。

             

            例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

                1
               / \\
              2   2
             / \\ / \\
            3  4 4  3
             

            但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

                1
               / \\
              2   2
               \\   \\
               3    3

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/symmetric-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isSymmetric(TreeNode root) {
        return root==null||isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;

        return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }


    private boolean isSymmetric错误方法(TreeNode root) {
        Deque<TreeNode> treeNodeDeque1 = new LinkedList<>();
        Deque<TreeNode> treeNodeDeque2 = new LinkedList<>();

        Deque<Boolean> colorQueue1 = new LinkedList<>();
        Deque<Boolean> colorQueue2 = new LinkedList<>();

        Deque<Integer> ansQueue1 = new LinkedList<>();
        Deque<Integer> ansQueue2 = new LinkedList<>();

        treeNodeDeque1.push(root);
        treeNodeDeque2.push(root);

        colorQueue1.push(false);
        colorQueue2.push(false);

        while (treeNodeDeque1.size() != 0) {
            TreeNode t1 = treeNodeDeque1.pop();
            TreeNode t2 = treeNodeDeque2.pop();

            Boolean c1 = colorQueue1.pop();
            Boolean c2 = colorQueue2.pop();

            if (t1 != null) {
                if (c1) {
                    ansQueue1.push(t1.val);
                } else {
                    treeNodeDeque1.push(t1.left);
                    treeNodeDeque1.push(t1);
                    treeNodeDeque1.push(t1.right);

                    colorQueue1.push(false);
                    colorQueue1.push(true);
                    colorQueue1.push(false);
                }
            }

            if (t2 != null) {
                if (c2) {
                    ansQueue2.push(t2.val);
                } else {
                    treeNodeDeque2.push(t2.left);
                    treeNodeDeque2.push(t2);
                    treeNodeDeque2.push(t2.right);

                    colorQueue2.push(false);
                    colorQueue2.push(true);
                    colorQueue2.push(false);
                }
            }

            while ((ansQueue1.size() != 0) && (ansQueue2.size() != 0)) {
                Integer a1 = ansQueue1.pop();
                Integer a2 = ansQueue2.pop();

                if (!a1.equals(a2)) return false;
            }
        }


        return (ansQueue1.size() == 0) && (ansQueue2.size() == 0);
    }
}
