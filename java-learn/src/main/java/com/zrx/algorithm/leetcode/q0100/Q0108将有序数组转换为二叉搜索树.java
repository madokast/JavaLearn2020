package com.zrx.algorithm.leetcode.q0100;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 将有序数组转换为二叉搜索树
 * <p>
 * Data
 * 2020/6/8-22:21
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0108将有序数组转换为二叉搜索树 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0108将有序数组转换为二叉搜索树.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(-10, -3, 0, 5, 9)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                TreeNode.of(0, -3, 9, -10, null, 5)
        );
    }

    @Code(info = """
            将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

            本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

            示例:

            给定有序数组: [-10,-3,0,5,9],

            一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

                  0
                 / \\
               -3   9
               /   /
             -10  5

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i >= j) return null;
        else {
            int mid = (i + j) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, i, mid);
            root.right = sortedArrayToBST(nums, mid + 1, j);
            return root;
        }
    }
}
