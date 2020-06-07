package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 二叉树的中序遍历
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
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
    public List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }
}
