package com.zrx.algorithm.leetcode.q0250;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import org.springframework.stereotype.Component;
/**
 * Description
 *
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0257二叉树的所有路径 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0257二叉树的所有路径.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            给定一个二叉树，返回所有从根节点到叶子节点的路径。

            说明: 叶子节点是指没有子节点的节点。

            示例:

            输入:

               1
             /   \\
            2     3
             \\
              5

            输出: ["1->2->5", "1->3"]

            解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/binary-tree-paths
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }
}
