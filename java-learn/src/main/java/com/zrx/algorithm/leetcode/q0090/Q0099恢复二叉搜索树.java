package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 恢复二叉搜索树
 * <p>
 * Data
 * 2020/6/6-16:39
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0099恢复二叉搜索树 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0099恢复二叉搜索树.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                TreeNode.of(1, 3, null, null, 2),
                TreeNode.of(3, 1, 4, null, null, 2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                TreeNode.of(3, 1, null, null, 2),
                TreeNode.of(2, 1, 4, null, null, 3)
        );
    }

    @Code(info = """
            二叉搜索树中的两个节点被错误地交换。

            请在不改变其结构的情况下，恢复这棵树。

            示例 1:

            输入: [1,3,null,null,2]

               1
              /
             3
              \\
               2

            输出: [3,1,null,null,2]

               3
              /
             1
              \\
               2
            示例 2:

            输入: [3,1,4,null,null,2]

              3
             / \\
            1   4
               /
              2

            输出: [2,1,4,null,null,3]

              2
             / \\
            1   4
               /
              3
            进阶:

            使用 O(n) 空间复杂度的解法很容易实现。
            你能想出一个只使用常数空间的解决方案吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/recover-binary-search-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public TreeNode recoverTree(TreeNode root) {
        //recoverTree(root, null, null, null, null);

        pre = null;
        err = null;
        errNext = null;
        swap = false;


        inorderTraversal(root);


        if (!swap) {
            swap(err, errNext);
        }


        return root;
    }

    private TreeNode pre;
    private TreeNode err;
    private TreeNode errNext;
    private boolean swap;


    private void inorderTraversal(TreeNode node) {
        LOGGER.info("pre = {}", pre);
        if (swap) return;

        if (node.left != null) inorderTraversal(node.left);

        if (pre != null) {
            if (pre.val > node.val) {
                if (err != null) {
                    swap(err, node);
                    swap = true;
                } else {
                    err = pre;
                    errNext = node;
                }
            }
        }

        pre = node;
        if (node.right != null) inorderTraversal(node.right);
    }


    private void recoverTree(TreeNode node, Integer low, TreeNode lowTree, Integer high, TreeNode highTree) {
        int val = node.val;

        if (low != null) {
            if (val < low) {
                swap(node, lowTree);
                return;
            }
        }

        if (high != null) {
            if (val > high) {
                swap(node, highTree);
                return;
            }
        }

        if (node.left != null) {
            recoverTree(node.left, low, lowTree, val, node);
        }

        if (node.right != null) {
            recoverTree(node.right, val, node, high, highTree);
        }

    }

//    private TreeNode recoverTreeHelper(TreeNode node) {
//        int val = node.val;
//
//        if (node.left != null) {
//            node.left = recoverTreeHelper(node.left);
//
//            if (node.left.val > val) {
//                swap(node, node.left);
//            }
//        }
//
//        if (node.right != null) {
//            node.right = recoverTreeHelper(node.right);
//
//            if (node.right.val < val) {
//                swap(node, node.right);
//            }
//        }
//
//        return node;
//    }

    private void swap(TreeNode t1, TreeNode t2) {
        t1.val = t1.val ^ t2.val;
        t2.val = t1.val ^ t2.val;
        t1.val = t1.val ^ t2.val;
    }
}
