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
 * 二叉树的最小深度
 * <p>
 * Data
 * 2020/6/9-19:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0111二叉树的最小深度 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0111二叉树的最小深度.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个二叉树，找出其最小深度。

            最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

            说明: 叶子节点是指没有子节点的节点。

            示例:

            给定二叉树 [3,9,20,null,null,15,7],

                3
               / \\
              9  20
                /  \\
               15   7
            返回它的最小深度  2.

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int minDepth(TreeNode root) {
        return -1;
    }
}
