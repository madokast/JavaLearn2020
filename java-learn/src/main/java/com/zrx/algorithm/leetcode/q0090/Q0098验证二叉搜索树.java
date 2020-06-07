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
 * 验证二叉搜索树
 * <p>
 * Data
 * 2020/6/6-16:38
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0098验证二叉搜索树 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0098验证二叉搜索树.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个二叉树，判断其是否是一个有效的二叉搜索树。

            假设一个二叉搜索树具有如下特征：

            节点的左子树只包含小于当前节点的数。
            节点的右子树只包含大于当前节点的数。
            所有左子树和右子树自身必须也是二叉搜索树。
            示例 1:

            输入:
                2
               / \\
              1   3
            输出: true
            示例 2:

            输入:
                5
               / \\
              1   4
                 / \\
                3   6
            输出: false
            解释: 输入为: [5,1,4,null,null,3,6]。
                 根节点的值为 5 ，但是其右子节点值为 4 。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/validate-binary-search-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isValidBST(TreeNode root) {
        return false;
    }
}
