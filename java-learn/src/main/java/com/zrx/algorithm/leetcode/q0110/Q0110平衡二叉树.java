package com.zrx.algorithm.leetcode.q0110;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 平衡二叉树
 * <pre>
 *     class Solution {
 *     public boolean isBalanced(TreeNode root) {
 *         return recur(root) != -1;
 *     }
 *
 *     private int recur(TreeNode root) {
 *         if (root == null) return 0;
 *         int left = recur(root.left);
 *         if(left == -1) return -1;
 *         int right = recur(root.right);
 *         if(right == -1) return -1;
 *         return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
 *     }
 * }
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/balanced-binary-tree-di-gui-fang-fa-by-jin40789108/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </pre>
 * <p>
 * Data
 * 2020/6/9-19:32
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0110平衡二叉树 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0110平衡二叉树.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1,
                TreeNode.of(3, 9, 20, null, null, 15, 7),
                TreeNode.of(1, 2, 2, 3, 3, null, null, 4, 4),
                TreeNode.of(1, 2, 2, 3, null, null, 3, 4, null, null, 4)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, false, false
        );
    }

    @Code(info = """
            给定一个二叉树，判断它是否是高度平衡的二叉树。

            本题中，一棵高度平衡二叉树定义为：

            一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

            示例 1:

            给定二叉树 [3,9,20,null,null,15,7]

                3
               / \\
              9  20
                /  \\
               15   7
            返回 true 。

            示例 2:

            给定二叉树 [1,2,2,3,3,null,null,4,4]

                   1
                  / \\
                 2   2
                / \\
               3   3
              / \\
             4   4

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/balanced-binary-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        List<TreeNode> list = new ArrayList<>(128);
        list.add(root);
        int layerNum = 1;
        while (layerNum > 0) {
            int nextLayerNumber = 0;
            int size = list.size();
            for (int i = 0; i < layerNum; i++) {
                TreeNode node = list.get(size - 1 - i);
                if (node.left != null) {
                    list.add(node.left);
                    nextLayerNumber++;
                }
                if (node.right != null) {
                    list.add(node.right);
                    nextLayerNumber++;
                }
            }

            layerNum = nextLayerNumber;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            TreeNode node = list.get(i);
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null) {
                if (right == null) {
                    node.val = 0;
                } else {
                    int h = right.val + 1;
                    if (h > 1) return false;
                    node.val = h;
                }
            } else {
                if (right == null) {
                    int h = left.val + 1;
                    if (h > 1) return false;
                    node.val = h;
                } else {
                    int rh = right.val;
                    int lh = left.val;
                    if (Math.abs(rh - lh) > 1) return false;
                    node.val = Math.max(rh, lh) + 1;

                }
            }
        }

        return true;
    }


    public boolean isBalanced慢(TreeNode root) {
        if (root == null) return true;
        else {
            high(root);

            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();

                TreeNode left = pop.left;
                TreeNode right = pop.right;

                int leftHigh;
                int rightHigh;

                if (left != null) {
                    stack.push(left);
                    leftHigh = left.val;
                } else {
                    leftHigh = 0;
                }
                if (right != null) {
                    stack.push(right);
                    rightHigh = right.val;
                } else
                    rightHigh = 0;

                if (Math.abs(leftHigh - rightHigh) > 1) return false;
            }
        }

        return true;
    }

    private int high(TreeNode node) {
        if (node == null) return 0;
        else {
            int h = Math.max(high(node.left), high(node.right)) + 1;
            node.val = h;
            return h;
        }
    }
}
