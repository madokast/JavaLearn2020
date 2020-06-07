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
 * 恢复二叉搜索树
 * <p>
 * Data
 * 2020/6/6-16:39
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0099恢复二叉搜索树 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0099恢复二叉搜索树.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            二叉搜索树中的两个节点被错误地交换。

            请在不改变其结构的情况下，恢复这棵树。

            示例 1:

            输入: [1,3,null,null,2]

               1
              /
             3
              \\
               2

            输出: [3,1,null,null,2]

               3
              /
             1
              \\
               2
            示例 2:

            输入: [3,1,4,null,null,2]

              3
             / \\
            1   4
               /
              2

            输出: [2,1,4,null,null,3]

              2
             / \\
            1   4
               /
              3
            进阶:

            使用 O(n) 空间复杂度的解法很容易实现。
            你能想出一个只使用常数空间的解决方案吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/recover-binary-search-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public void recoverTree(TreeNode root) {

    }
}
