package com.zrx.algorithm.leetcode.q0230;

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
 * 二叉搜索树中第K小的元素
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0230二叉搜索树中第K小的元素 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0230二叉搜索树中第K小的元素.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                TreeNode.of(3, 1, 4, null, 2), 1,
                TreeNode.of(5, 3, 6, 2, 4, null, null, 1), 3
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                1, 3
        );
    }

    @Code(info = """
            给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

            说明：
            你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

            示例 1:

            输入: root = [3,1,4,null,2], k = 1
               3
              / \\
             1   4
              \\
               2
            输出: 1
            示例 2:

            输入: root = [5,3,6,2,4,null,null,1], k = 3
                   5
                  / \\
                 3   6
                / \\
               2   4
              /
             1
            输出: 3
            进阶：
            如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int kthSmallest(TreeNode root, int k) {

        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Boolean> colorStack = new LinkedList<>();

        stack.push(root);
        colorStack.push(true);


        while (k > 0) {
            TreeNode pop = stack.pop();
            Boolean color = colorStack.pop();
            if (color) {

                if (pop.right != null) {
                    stack.push(pop.right);
                    colorStack.push(true);
                }

                stack.push(pop);
                colorStack.push(false);

                if (pop.left != null) {
                    stack.push(pop.left);
                    colorStack.push(true);
                }


            } else {
                LOGGER.info("pop = {}", pop.val);

                if (k == 1) return pop.val;
                else k--;
            }
        }

        return -1;
    }
}
