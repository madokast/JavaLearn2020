package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 完全二叉树的节点个数
 * 更好的方法是二分法
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0222完全二叉树的节点个数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0222完全二叉树的节点个数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                TreeNode.of(1, 2, 3, 4, 5, 6),
                TreeNode.of(1, 2, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                6, 3
        );
    }

    @Code(info = """
            给出一个完全二叉树，求出该树的节点个数。

            说明：

            完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

            示例:

            输入:\040
                1
               / \\
              2   3
             / \\  /
            4  5 6

            输出: 6

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int countNodes(TreeNode root) {
        int depth = depth(root);
        LOGGER.info("depth = {}", depth);
        if (depth <= 1) return depth;
        int right = (1 << (depth - 1)) - 1;
        int left = 0;

        LOGGER.info("right = {}", right);

        while (right > left) {
            int mid = (right + left) >> 1;
            if (exists(root, depth, mid)) left = mid + 1;
            else right = mid;
        }


        LOGGER.info("left = {}", left);
        LOGGER.info("right = {}", right);


        return (1 << (depth - 1)) - 1 + right + (exists(root, depth, right) ? 1 : 0);
    }

    boolean exists(TreeNode root, int depth, int index) {
        while (depth > 1) {
            int mid = 1 << (depth - 2); // 1
            if (index >= mid) {
                root = root.right; // 1
                index -= mid; // 0
            } else {
                root = root.left;
            }

            depth--;
        }

        return root != null;
    }

    int depth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }

        return depth;
    }


    public int countNodes垃圾方法(TreeNode root) {
        if (root == null) return 0;
        else return countNodes垃圾方法(root.left) + countNodes垃圾方法(root.right) + 1;
    }
}
