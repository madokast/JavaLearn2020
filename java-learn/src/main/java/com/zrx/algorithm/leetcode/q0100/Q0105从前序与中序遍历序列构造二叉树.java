package com.zrx.algorithm.leetcode.q0100;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 从前序与中序遍历序列构造二叉树
 * <p>
 * Data
 * 2020/6/8-22:18
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0105从前序与中序遍历序列构造二叉树 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0105从前序与中序遍历序列构造二叉树.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(3, 9, 20, 15, 7), ArrayFactory.create(9, 3, 15, 20, 7)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                TreeNode.of(3, 9, 20, null, null, 15, 7)
        );
    }

    @Code(info = """
            根据一棵树的前序遍历与中序遍历构造二叉树。

            注意:
            你可以假设树中没有重复的元素。

            例如，给出

            前序遍历 preorder = [3,9,20,15,7]
            中序遍历 inorder = [9,3,15,20,7]
            返回如下的二叉树：

                3
               / \\
              9  20
                /  \\
               15   7

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int sp, int[] inorder, int si, int ei) {
        if (si >= ei) return null;
        else {
            int val = preorder[sp];
            TreeNode root = new TreeNode(val);
            int im = si;
            for (; im < ei; im++) if (inorder[im] == val) break;
            root.left = buildTree(preorder, sp + 1, inorder, si, im);
            root.right = buildTree(preorder, sp + (im - si) + 1, inorder, im + 1, ei);
            return root;
        }
    }
}
