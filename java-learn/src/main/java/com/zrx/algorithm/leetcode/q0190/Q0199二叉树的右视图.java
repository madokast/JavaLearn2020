package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 二叉树的右视图
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0199二叉树的右视图 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0199二叉树的右视图.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                TreeNode.of(1, 2, 3, null, 5, null, 4)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of(1, 3, 4)
        );
    }

    @Code(info = """
            给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

            示例:

            输入: [1,2,3,null,5,null,4]
            输出: [1, 3, 4]
            解释:

               1            <---
             /   \\
            2     3         <---
             \\     \\
              5     4       <---

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return Collections.emptyList();
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (queue.isEmpty()) ans.add(poll.val);

                if (poll.left != null) queue2.offer(poll.left);
                if (poll.right != null) queue2.offer(poll.right);
            }

            queue = queue2;
        }

        return ans;
    }
}
