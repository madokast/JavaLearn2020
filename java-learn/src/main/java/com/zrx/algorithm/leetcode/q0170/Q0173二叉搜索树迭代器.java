package com.zrx.algorithm.leetcode.q0170;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * 二叉搜索树迭代器
 * <p>
 * Data
 * 2020/7/6-9:22
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0173二叉搜索树迭代器 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0173二叉搜索树迭代器.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1, true);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(true);
    }

    @Code(info = """
            实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

            调用 next() 将返回二叉搜索树中的下一个最小的数。

             

            示例：



            BSTIterator iterator = new BSTIterator(root);
            iterator.next();    // 返回 3
            iterator.next();    // 返回 7
            iterator.hasNext(); // 返回 true
            iterator.next();    // 返回 9
            iterator.hasNext(); // 返回 true
            iterator.next();    // 返回 15
            iterator.hasNext(); // 返回 true
            iterator.next();    // 返回 20
            iterator.hasNext(); // 返回 false
             

            提示：

            next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
            你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class BSTIterator {

        Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode pop = stack.pop();

            TreeNode temp = pop.right;

            if (temp != null) {
                stack.push(temp);

                while (temp.left != null) {
                    stack.push(temp.left);
                    temp = temp.left;
                }
            }
            return pop.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
