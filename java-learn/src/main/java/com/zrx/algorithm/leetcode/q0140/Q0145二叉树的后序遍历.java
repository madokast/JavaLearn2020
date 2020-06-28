package com.zrx.algorithm.leetcode.q0140;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 二叉树的后序遍历
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0145二叉树的后序遍历 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0145二叉树的后序遍历.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                TreeNode.of(1, null, 2, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of(3, 2, 1)
        );
    }

    @Code(info = """
            给定一个二叉树，返回它的 后序 遍历。

            示例:

            输入: [1,null,2,3]\040\040
               1
                \\
                 2
                /
               3\040

            输出: [3,2,1]
            进阶: 递归算法很简单，你可以通过迭代算法完成吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Boolean> colorStack = new LinkedList<>();

        stack.push(root);
        colorStack.push(WHITE);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            Boolean color = colorStack.pop();

            if (color == WHITE) {
                TreeNode left = pop.left;
                TreeNode right = pop.right;

                stack.push(pop);
                colorStack.push(GREY);

                if (right != null) {
                    stack.push(right);
                    colorStack.push(WHITE);
                }

                if (left != null) {
                    stack.push(left);
                    colorStack.push(WHITE);
                }
            }

            if (color == GREY) {
                ans.add(pop.val);
            }
        }

        return ans;
    }

    private static final Boolean GREY = false;
    private static final Boolean WHITE = true;
}
