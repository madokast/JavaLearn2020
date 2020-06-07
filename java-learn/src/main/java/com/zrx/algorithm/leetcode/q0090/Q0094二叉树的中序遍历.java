package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 二叉树的中序遍历
 * 神奇的颜色标记法
 * <pre>
 *     class Solution:
 *     def inorderTraversal(self, root: TreeNode) -> List[int]:
 *         WHITE, GRAY = 0, 1
 *         res = []
 *         stack = [(WHITE, root)]
 *         while stack:
 *             color, node = stack.pop()
 *             if node is None: continue
 *             if color == WHITE:
 *                 stack.append((WHITE, node.right))
 *                 stack.append((GRAY, node))
 *                 stack.append((WHITE, node.left))
 *             else:
 *                 res.append(node.val)
 *         return res
 *
 * 作者：hzhu212
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </pre>
 * <p>
 * Data
 * 2020/6/6-16:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0094二叉树的中序遍历 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0094二叉树的中序遍历.class);

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
                List.of(1, 3, 2)
        );
    }

    @Code(info = """
            给定一个二叉树，返回它的中序 遍历。

            示例:

            输入: [1,null,2,3]
               1
                \\
                 2
                /
               3

            输出: [1,3,2]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<Integer> inorderTraversal颜色算法(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Boolean> colorStack = new LinkedList<>();

        nodeStack.push(root);
        colorStack.push(false);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Boolean color = colorStack.pop();

            if (node==null) {
                continue;
            }

            if(color){
                list.add(node.val);
            }else{
                nodeStack.push(node.right);
                nodeStack.push(node);
                nodeStack.push(node.left);

                colorStack.push(false);
                colorStack.push(true);
                colorStack.push(false);
            }
        }

        return list;
    }



    public List<Integer> inorderTraversal非递归算法(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (stack.peek().left != null) stack.push(stack.peek().left);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            list.add(pop.val);

            if (pop.right != null) {
                stack.push(pop.right);
                while (stack.peek().left != null) stack.push(stack.peek().left);
            }
        }

        return list;
    }

    public List<Integer> inorderTraversal递归算法(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node.left != null) inorderTraversal(node.left, list);
        list.add(node.val);
        if (node.right != null) inorderTraversal(node.right, list);
    }
}
