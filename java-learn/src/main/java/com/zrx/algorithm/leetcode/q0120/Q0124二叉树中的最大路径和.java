package com.zrx.algorithm.leetcode.q0120;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 二叉树中的最大路径和
 * <p>
 * Data
 * 2020/6/13-19:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0124二叉树中的最大路径和 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0124二叉树中的最大路径和.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个非空二叉树，返回其最大路径和。

            本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

            示例 1:

            输入: [1,2,3]

                   1
                  / \\
                 2   3

            输出: 6
            示例 2:

            输入: [-10,9,20,null,null,15,7]

               -10
               / \\
              9  20
                /  \\
               15   7

            输出: 42

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maxPathSum(TreeNode root) {
        return -1;
    }
}
