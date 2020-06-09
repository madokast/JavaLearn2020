package com.zrx.algorithm.leetcode.q0110;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 平衡二叉树
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
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
        return false;
    }
}
