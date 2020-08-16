package com.zrx.algorithm.leetcode.q0230;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 二叉搜索树的最近公共祖先
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0235二叉搜索树的最近公共祖先 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0235二叉搜索树的最近公共祖先.class);

    TreeNode tree01 = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                3,
                tree01, tree01.right, tree01.left,
                tree01, tree01.left.left, tree01.left.right,
                tree01, tree01, tree01.right
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                tree01, tree01.left, tree01
        );
    }

    @Code(info = """
            给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

            百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
            满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

            例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

            示例 1:

            输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
            输出: 6\040
            解释: 节点 2 和节点 8 的最近公共祖先是 6。
            示例 2:

            输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
            输出: 2
            解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
             

            说明:

            所有节点的值都是唯一的。
            p、q 为不同节点且均存在于给定的二叉搜索树中。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;

        int pVal = p.val;

        int qVal = q.val;

        if (parentVal > pVal) {
            if (parentVal > qVal) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (parentVal < qVal) {
                return root;
            } else
                return root;
        } else if (parentVal < pVal) {
            if (parentVal > qVal) {
                return root;
            } else if (parentVal < qVal) {
                return lowestCommonAncestor(root.right, p, q);
            } else
                return root;
        } else
            return root;
    }
}
