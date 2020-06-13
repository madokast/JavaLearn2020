package com.zrx.algorithm.leetcode.q0110;

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
 * 路径总和
 * <p>
 * Data
 * 2020/6/9-19:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0112路径总和 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0112路径总和.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22,
                TreeNode.of(1, 2), 1,
                TreeNode.of(1, -2, -3, 1, 3, -2, null, -1), -1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(true, false, true);
    }

    @Code(info = """
            说明: 叶子节点是指没有子节点的节点。

            示例: 
            给定如下二叉树，以及目标和 sum = 22，

                          5
                         / \\
                        4   8
                       /   / \\
                      11  13  4
                     /  \\      \\
                    7    2      1
            返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/path-sum
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean hasPathSum(TreeNode root, int sum) {
        //LOGGER.info("root.toTreeString(4,4) = {}", root.toTreeString(4, 4));

        if (root == null) return false;
        sum -= root.val;
        if (sum == 0 && (root.right == null && root.left == null)) return true;

        return hasPathSum(root.right, sum) || hasPathSum(root.left, sum);
    }
}
