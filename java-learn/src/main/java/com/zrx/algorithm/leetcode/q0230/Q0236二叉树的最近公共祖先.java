package com.zrx.algorithm.leetcode.q0230;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * 二叉树的最近公共祖先
 * <pre>
 *     class Solution {
 *     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
 *
 *         // Value of current node or parent node.
 *         int parentVal = root.val;
 *
 *         // Value of p
 *         int pVal = p.val;
 *
 *         // Value of q;
 *         int qVal = q.val;
 *
 *         if (pVal > parentVal && qVal > parentVal) {
 *             // If both p and q are greater than parent
 *             return lowestCommonAncestor(root.right, p, q);
 *         } else if (pVal < parentVal && qVal < parentVal) {
 *             // If both p and q are lesser than parent
 *             return lowestCommonAncestor(root.left, p, q);
 *         } else {
 *             // We have found the split point, i.e. the LCA node.
 *             return root;
 *         }
 *     }
 * }
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian--2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </pre>
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0236二叉树的最近公共祖先 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0236二叉树的最近公共祖先.class);

    TreeNode tree = TreeNode.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                3,
                tree, tree.left, tree.right
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                tree
        );
    }

    @Code(info = """
            给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

            百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

            例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]



             

            示例 1:

            输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
            输出: 3
            解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
            示例 2:

            输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
            输出: 5
            解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
             

            说明:

            所有节点的值都是唯一的。
            p、q 为不同节点且均存在于给定的二叉树中。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path0 = path(root, p);
        List<TreeNode> path1 = path(root, q);

        TreeNode ans = root;
        int s0 = path0.size();
        int s1 = path1.size();

        int s = Math.min(s0,s1);

        for (int i = 0; i < s; i++) {
            TreeNode t0 = path0.get(i);
            TreeNode t1 = path1.get(i);

            if(t0==t1) ans = t0;
            else break;
        }

        return ans;
    }

    private List<TreeNode> path(TreeNode from, TreeNode to) {
        LinkedList<TreeNode> ans = new LinkedList<>();
        ans.addLast(from);
        path(to, ans, new boolean[]{false});
        return ans;
    }

    private void path(TreeNode to, Deque<TreeNode> ans, boolean[] find) {
        if (find[0]) return;

        TreeNode last = ans.getLast();
        if (last == to) {
            find[0] = true;
        } else {
            TreeNode right = last.right;
            if (right != null) {
                ans.addLast(right);
                path(to, ans, find);
                if (find[0]) return;
                ans.removeLast();
            }


            TreeNode left = last.left;

            if (left != null) {
                ans.addLast(left);
                path(to, ans, find);
                if (find[0]) return;
                ans.removeLast();
            }
        }
    }
}
