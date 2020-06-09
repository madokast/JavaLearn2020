package com.zrx.algorithm.leetcode.q0100;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;

/**
 * Description
 * 相同的树
 * <p>
 * Data
 * 2020/6/8-22:12
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0100相同的树 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0100相同的树.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                TreeNode.of(1, 2, 3), TreeNode.of(1, 2, 3),
                TreeNode.of(1, 2), TreeNode.of(1, null, 2),
                TreeNode.of(1, 2, 1), TreeNode.of(1, 1, 2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true,
                false,
                false
        );
    }

    @Code(info = """
            给定两个二叉树，编写一个函数来检验它们是否相同。

            如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

            示例 1:

            输入:       1         1
                      / \\       / \\
                     2   3     2   3

                    [1,2,3],   [1,2,3]

            输出: true
            示例 2:

            输入:      1          1
                      /           \\
                     2             2

                    [1,2],     [1,null,2]

            输出: false
            示例 3:

            输入:       1         1
                      / \\       / \\
                     2   1     1   2

                    [1,2,1],   [1,1,2]

            输出: false

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/same-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
